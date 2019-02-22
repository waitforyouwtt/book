package com.book.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.book.entity.BatchParams;
import com.book.entity.BatchReductionParams;
import com.book.entity.UserInfo;
import com.book.service.OtherService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 15:49
 */
@Controller
public class FileReadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${static.resources.domain}")
    private String staticResourceDomain;

    @Autowired
    OtherService infoService;

    public static final char SEPARATOR = '|';

    public static final String LINE_ENDING = "\n";

    @RequestMapping(value = "/exclImport",method = RequestMethod.POST)
    public String importExcel1(@RequestParam("file") MultipartFile excl, HttpServletRequest request) {

        if(excl.isEmpty()){
          throw new IllegalArgumentException("文件不存在!");
        }
        String fileName = excl.getOriginalFilename();
        //转化为流的形式
        InputStream is = null;
        try {
            is = excl.getInputStream();
            List<UserInfo> listMer = new ArrayList<UserInfo>();
            List<Row> list = ExcelUtil.getExcelRead(fileName,is, true);
            //首先是读取行 也就是一行一行读，然后在取到列，遍历行里面的行，根据行得到列的值
            List<String> loanIds = new ArrayList<>();
            for (Row row : list) {
                /****************得到每个元素的值start**********************/
                Cell cell_0 = row.getCell(0);
                Cell cell_1 = row.getCell(1);
                //得到列的值，也就是你需要解析的字段的值
                String loanId = ExcelUtil.getValue(cell_0);
                String editor = ExcelUtil.getValue(cell_1);

                loanIds.add(loanId);
            }
            System.out.println("得到的集合是："+loanIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "/exclImport2",method = RequestMethod.POST)
    public String importExcel(@RequestParam("file") MultipartFile excl, HttpServletRequest request) {

        if(excl.isEmpty()){
            throw new IllegalArgumentException("文件不存在!");
        }

        try ( InputStream is = excl.getInputStream()){
            // 解析每行结果在listener中处理
          //  List<Object> data = EasyExcelFactory.read(new BufferedInputStream(is), new Sheet(1, 1));
            List<Object> data2 = EasyExcelFactory.read(new BufferedInputStream(is), new Sheet(1, 1, BatchParams.class));

            List<BatchReductionParams> batchReductionParams = new ArrayList<>();

            for (Object o: data2) {
                BatchParams batchParams = (BatchParams) o;
                BatchReductionParams reductionParams = new BatchReductionParams();
                reductionParams.setLoanId(batchParams.getLoanId());
                reductionParams.setTerm(batchParams.getTerm());
                batchReductionParams.add(reductionParams);
            }
            logger.info("得到的数据是{}",batchReductionParams.toString());

        } catch (Exception e) {
           logger.info("异常了{}",e);
           return "failed";
        }
        return "success";
    }

    @ApiOperation(value = "前往导入excel页面")
    @RequestMapping(value = "/toExcel",method = RequestMethod.POST)
    public  String toExcel(Model model) {
        model.addAttribute("staticResourceDomain", staticResourceDomain);
        return "excel";
    }
    @ApiOperation(value = "导入excel 动作")
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public  String importExcel(@RequestParam("myfile")MultipartFile myFile) {
        ModelAndView modelAndView = new ModelAndView();

        Integer nums = infoService.importExcel(myFile);
        modelAndView.addObject("msg","导入数成功");
        return "success";
    }
}
