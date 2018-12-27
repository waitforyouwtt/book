/*
package com.book.file;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 16:27
 *//*

public class ExcelUtils {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    // 是否是预览
    private boolean isPriview = true;

    //构造方法
    public ExcelUtils() {
    }

    //构造方法
    public ExcelUtils(boolean isPriview) {
        this.isPriview=isPriview;
    }
    //获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    */
/**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     *//*

    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    */
/**
     * 读EXCEL文件
     *
     * @param
     * @return
     *//*

    public Map<String, Object> getExcelInfo(String fileName, String tmpFilePath) {
        Map<String, Object> result = new HashMap<String, Object>();
        File fa = new File(tmpFilePath);
        InputStream is = null;
        try {
            is= new FileInputStream(fa);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //验证文件名是否合格
            if (!validateExcel(fileName)) {
                errorMsg = "文件不是excel格式";
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            // 获取excel内容
            Workbook wb = getExcelInfo(is, isExcel2003);

            List customerList = null;
            List titleList = null;
            Map columnstypes = null;
            // 读取标题信息 其中也设置了有效列数量
            titleList = readExcelTitle(wb);
            //读取Excel信息
            customerList = readExcelValue(wb);
            if(isPriview){
                columnstypes = getColumnType(wb);
                customerList.add(0, columnstypes);
            }
            result.put("error", errorMsg);
            result.put("tablename", fileName.substring(0, fileName.lastIndexOf('.')));
            result.put("schema", titleList);
            result.put("data", customerList);
            result.put("columnstypes", columnstypes);

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    */
/**
     * 根据excel里面的内容
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     *//*

    public Workbook getExcelInfo(InputStream is, boolean isExcel2003) {
        */
/** 根据版本选择创建Workbook的方式 *//*

        Workbook wb = null;
        try {
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {  //当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            return wb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    */
/**
     * 读取Excel内容
     *
     * @param wb
     * @return
     *//*

    private List readExcelValue(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        //得到Excel的列数(前提是有行数)
        // 0816 已经在获取标题的时候设置了有效列  totalCells
        if (isPriview && totalRows > 100) {
            totalRows = 101;
        }

        // 记录空行 规则 如果空行大于1行 下面的视为垃圾数据 忽略 20180820  yunguang modified
        int blankLine=0;

        List valueList = new ArrayList();
        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                // 遇到空白行 获取的行数加1
                this.totalRows++;
                blankLine++;
                if (blankLine > 1) {
                    // totalrows 重新定义总行数  20180820  yunguang modified
                    this.totalRows = r;
                    break;
                }
                continue;
            } else {  // 无空白行 重置计数器
                blankLine = 0;
            }
            List temp = new ArrayList();
            // 标记是否为插入的空白行 识别规则 插入的数据后第一个单元格为空
            boolean addFlag = false;
            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    String cellValue = getCellValue(cell);
                    // 针对又见插入的行 poi默认它不算空行 判断该行如果有一个 不为空 该条记录视为有效 20180820  yunguang modified
                    if ("".equals(cellValue) && (!addFlag)) {
                        addFlag = false;
                    } else {
                        addFlag = true;

                    }
                    if("".equals(cellValue)){
                        temp.add("\\N");
                    }
                    else {
                        temp.add(cellValue);
                    }

                } else {
                    temp.add("\\N");
                }
            }
            if (addFlag) { // 判断是否为有效数据
                valueList.add(temp);
            }
        }
        return valueList;
    }


    */
/**
     * 读取Excel表头
     *
     * @param wb
     * @return
     *//*

    private List readExcelTitle(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List titleList = new ArrayList();
        // 读取标题
        Row row = sheet.getRow(0);
        if (row == null) return null;

        //循环Excel的列
        for (int c = 0; c < this.totalCells; c++) {
            Map temp = new HashMap();
            Cell cell = row.getCell(c);
            if (null != cell) {
                temp.put("name", getCellValue(cell));
                titleList.add(temp);
            }
            else {
                // 0816  遇到一个空白标题 结束
                this.totalCells=c;
                break;
            }
        }
        return titleList;
    }

    */
/**
     * 读取Excel表头
     *
     * @param wb
     * @return
     *//*

    private Map getColumnType(Workbook wb) {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        if (this.totalRows > 101) {
            totalRows = 101;
        }
        // 0,string
        Map rowColumns = new HashMap();
        // 记录空行 规则 如果空行大于1行 下面的视为垃圾数据 忽略 20180820  yunguang modified
        int blankLine=0;

        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                this.totalRows++;
                blankLine ++;
                if (blankLine > 1) {
                    // totalrows 重新定义总行数  20180820  yunguang modified
                    this.totalRows = r;
                    break;
                }
                continue;
            }
            else {  // 无空白行 重置计数器
                blankLine = 0;
            }
            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    String cellValue = getCellValue(cell);
                    Object value = rowColumns.get(c);
                    String val = (String) value;
                    String valType =FileOperateUtil.getType(cellValue);
                    if (!"string".equals(val)) {
                        if("string".equals(valType)){
                            rowColumns.put(c,valType);
                        }
                        else if(!"double".equals(val)){
                            rowColumns.put(c,valType);
                        }
                    }
                }
                else {
                    rowColumns.put(c,"string");
                }
            }
        }
        return rowColumns;
    }

    private String getCellValue(Cell cell) {
        String value = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    // 数据格式
                    DecimalFormat df = new DecimalFormat("#.########");
                    value = df.format(cell.getNumericCellValue())+"";
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue())+"";
                } else {
                    // 针对十位数以上的数字出现科学记数法的处理 20180820  yunguang modified
                    value =   new DecimalFormat("#").format(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case BLANK:
                value = "";
                break;
            default:
                value = cell.toString();
                break;
        }
        return value;
    }

}
*/
