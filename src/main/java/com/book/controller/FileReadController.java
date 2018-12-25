package com.book.controller;

import com.book.entity.UserInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Row;

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

    public static final char SEPARATOR = '|';

    public static final String LINE_ENDING = "\n";

    @RequestMapping(value = "/exclImport",method = RequestMethod.POST)
    public String importExcl(@RequestParam("file") MultipartFile excl, HttpServletRequest request) {

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

}
