package com.book.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 15:54
 */
public class ExcelUtil {

    private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);
    //读取文件的方法
    /**
     * 获取解析文件行数据
     * @param fileName : 文件地址
     * @param isTitle  : 是否过滤第一行解析
     * @return
     * @throws Exception
     */
    public static List<Row> getExcelRead(String fileName, InputStream is, boolean isTitle) throws Exception{
        try {
            //判断其兼容版本 调用了判断版本的方法
            Workbook workbook = getWorkbook(fileName,is);
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            List<Row> list = new ArrayList<Row>();
            for (Row row : sheet) {
                // 跳过第一行的目录
                if (count == 0 && isTitle) {
                    count++;
                    continue;
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            log.info("错误信息{}",e);
            throw new RuntimeException("请先解密，再上传文件。");
        }
    }

//判断版本的方法

    public static Workbook getWorkbook(String fileName,InputStream is) throws Exception{
        Workbook workbook = null;
      /*  try {
            *//** 判断文件的类型，是2003还是2007 *//*
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }

            if (isExcel2003) {
                workbook = new HSSFWorkbook(is);
            } else {
                workbook = new XSSFWorkbook(is);
            }
        } catch (Exception e) {
            throw e;
        }*/

        if(fileName.endsWith("xls")){
            //2003
            workbook = new HSSFWorkbook(is);
        }else if(fileName.endsWith("xlsx")){
            //2007
            workbook = new XSSFWorkbook(is);
            System.out.println("得到的结果："+workbook);
        }
        return workbook;
    }

    //得到celL值的方法：
    public static String getValue(Cell cell){
        if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(cell.getBooleanCellValue());
        }else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            double value = cell.getNumericCellValue();
            return new BigDecimal(value).toString();
        }else if (cell.getCellType() ==HSSFCell.CELL_TYPE_STRING){
            return String.valueOf(cell.getStringCellValue());
        }else{
            return String.valueOf(cell.getStringCellValue());
        }
    }

}
