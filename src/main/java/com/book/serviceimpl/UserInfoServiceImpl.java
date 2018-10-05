package com.book.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.book.dao.ExcelDao;
import com.book.dao.UserInfoDao;
import com.book.entity.Tbagent;
import com.book.entity.UserInfo;
import com.book.enums.ResultEnum;
import com.book.exception.GlobalException;
import com.book.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:55
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    private ExcelDao excelDao;

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public void batchInsert(List<UserInfo> userInfoList) {
        userInfoDao.batchInsert(userInfoList);
    }

    private final static String XLS = "xls";
    public static final String XLSX = "xlsx";
    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public Integer importExcel(MultipartFile myFile) {
        //1.  使用HSSFWorkbook 打开或者创建 “Excel对象”
        //2.  用HSSFWorkbook返回对象或者创建sheet对象
        //3.  用sheet返回行对象，用行对象得到Cell对象
        //4.  对Cell对象进行读写

        List<Tbagent> tbagents = new ArrayList<>();
        Workbook workbook = null;
        //  获取文件名
        String fileName = myFile.getOriginalFilename();
        logger.info("【fileName】{}", fileName);
        if (fileName.endsWith(XLS)) {
            try {
                //  2003版本
                workbook = new HSSFWorkbook(myFile.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (fileName.endsWith(XLSX)) {
            try {
                //  2007版本
                workbook = new XSSFWorkbook(myFile.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 文件不是Excel文件
            throw new GlobalException(ResultEnum.FILE_IS_NOT_EXCEL);
        }
        Sheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();
        logger.info("【rows】{}", rows);
        if (rows == 0) {
            // 数据为空 请填写数据
            throw new GlobalException(ResultEnum.DATA_IS_NULL);
        }
        long startTime = System.currentTimeMillis();

        HashMap<String,String> mapWorkId=new HashMap<String,String>();
        HashMap<String,String> tmapWorkId=new HashMap<String,String>();

        for (int i = 1; i <= rows + 1; i++) {
            Row row = sheet.getRow(i);

            if (row != null) {

                Tbagent tbagent = new Tbagent();
                //  部门
                String department = getCellValue(row.getCell(0));
                tbagent.setDepartment(department);
                //  用户姓名
                String username = getCellValue(row.getCell(1));
                tbagent.setUsername(username);
                //  工号
                String jobNumer = getCellValue(row.getCell(2));
                if (!StringUtils.isEmpty(jobNumer)) {
                    Integer job_number = Integer.parseInt(jobNumer);
                    tbagent.setJob_number(Integer.valueOf(jobNumer));
                }
                // 身份证后六位
                String idcard = getCellValue(row.getCell(3));
                tbagent.setIdcard(idcard);
                // 公司排名
                String companyRankings = getCellValue(row.getCell(4));
                if (!StringUtils.isEmpty(companyRankings)) {
                    Integer new_companyRankings = Integer.parseInt(companyRankings);
                    tbagent.setCompany_rankings(new_companyRankings);
                }
                // 事业部排名
                String departmenRanks = getCellValue(row.getCell(5));
                if (!StringUtils.isEmpty(departmenRanks)) {
                    Integer new_departmentRanks = Integer.parseInt(departmenRanks);
                    tbagent.setDepartment_rankings(new_departmentRanks);
                }
                // 大区排名
                String region_Ranks = getCellValue(row.getCell(6));
                if (!StringUtils.isEmpty(region_Ranks)) {
                    Integer new_region_Rankings = Integer.parseInt(region_Ranks);
                    //logger.info("【大区排名】{}",new_region_Rankings);
                    tbagent.setRegion_rankings(new_region_Rankings);
                }//  距离公司第一名差距
                String distance_first_company = getCellValue(row.getCell(7));
                if (!StringUtils.isEmpty(distance_first_company)) {
                    Long new_distance_first_company = Long.parseLong(distance_first_company);
                    tbagent.setDistance_first_company(new_distance_first_company);
                }
                // 距离事业部第一名差距
                String distance_first_deparment = getCellValue(row.getCell(8));
                if (!StringUtils.isEmpty(distance_first_deparment)) {
                    Long new_distance_first_deparment = Long.parseLong(distance_first_deparment);
                    tbagent.setDistance_first_department(new_distance_first_deparment);
                }
                // 距离大区第一名差距
                String distance_first_region = getCellValue(row.getCell(9));
                if (!StringUtils.isEmpty(distance_first_region)) {
                    Long new_distance_first_region = Long.parseLong(distance_first_region);
                    tbagent.setDistance_first_region(new_distance_first_region);
                }
                String sexCell = getCellValue(row.getCell(10));
                if (org.apache.commons.lang3.StringUtils.isNotBlank(sexCell) && ! "男".equals(sexCell) && ! "女".equals(sexCell)){
                    throw new RuntimeException("性别错误!");
                }else{
                    tbagent.setSex(sexCell);
                }

                //判断工号是否重复
                int newNum=i+1;
                //如果Map集合中包含指定的键名，则返回true；否则返回false。
                if(mapWorkId.containsKey(tbagent.getJob_number())){
                    //拿到先前保存的行号
                    String lineNum=mapWorkId.get(tbagent.getJob_number());
                   logger.info("先前保存的行号lineNum:"+lineNum);

                    if(tmapWorkId.containsKey(tbagent.getJob_number())){
                        //拿到先前保存的所有行号记录
                        String str=tmapWorkId.get(tbagent.getJob_number());
                        //更新后，显示效果：——》行重复：在第 2 ，3 , 5
                        tmapWorkId.put(tbagent.getJob_number().toString(), str+" ,"+newNum);

                    }else{
                        //最后显示效果：——》行重复：在第 2 ，3
                        tmapWorkId.put(tbagent.getJob_number().toString(), "重复：行数位于第  "+lineNum+" ,"+newNum);
                    }

                }
                //把i行的第column列的值与行号保存到map中
                mapWorkId.put(tbagent.getJob_number().toString(), newNum+"");
                //System.out.println(JSON.toJSON(tbagent));
                //tbagentMapper.insert(tbagent);
                tbagents.add(tbagent);
            }
        }

        if (tmapWorkId.size() > 0){
            String msg1 = "";
            if (tmapWorkId.size()>0){
                Iterator<Map.Entry<String, String>> it=tmapWorkId.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
                    msg1  += "重复的工号为：" +entry.getKey() +" "+entry.getValue() +";";
                }
            }
            logger.info("重复的行:"+ msg1);
        }else{
            logger.info("没有重复的行");
        }


        //  批量插入 五秒完成
        excelDao.batchInsert(tbagents);
        long endTime = System.currentTimeMillis();
        long totaltime = endTime - startTime;
        //  将近两万条数据 3秒解析完成
        logger.info("【消耗时间为】{}", totaltime);
        logger.info("【第一条数据为】{}", JSON.toJSON(tbagents.get(0)));
        return rows;
    }

    public String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                // 数字
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue() + " ";
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            //  日期格式化
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        } else {
                            value = "";
                        }
                    } else {
                        //  解析cell时候 数字类型默认是double类型的 但是想要获取整数类型 需要格式化
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                //  字符串
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                //  Boolean类型
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue() + "";
                    break;
                // 空值
                case HSSFCell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                // 错误类型
                case HSSFCell.CELL_TYPE_ERROR:
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }

        }
        return value.trim();
    }
}
