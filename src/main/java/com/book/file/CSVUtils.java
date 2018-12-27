/*
package com.book.file;

import com.csvreader.CsvReader;
import info.monitorenter.cpdetector.io.*;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 16:28
 *//*

public class CSVUtils {

    // 预览或者正式上传（true 为预览）
    private boolean isPriview = true;

    public CSVUtils() {
    }

    public CSVUtils(boolean isPriview) {
        this.isPriview = isPriview;
    }

    */
/**
     * 导出**
     *
     * @param file     @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList 数据
     * @return
     *//*

    public static boolean exportCsv(File file, List<String> dataList) {
        boolean isSucess = false;
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(osw);
            if (dataList != null && !dataList.isEmpty()) {
                for (String data : dataList) {
                    bw.append(data).append("\r");
                }
            }
            isSucess = true;
        } catch (Exception e) {
            isSucess = false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    */
/**
     * 导入
     *
     * @param file csv文件(路径+文件)
     * @return
     *//*

    public static List<String> importCsv(File file) {
        List<String> dataList = new ArrayList<String>();

        BufferedReader br = null;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");

            br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }



    */
/**
     * 调用该方法的模块:
     *  本地调用
     * 功能描述:
     *  获取该文件内容的编码格式
     * @param:
     * @return:
     * @auther: solmyr
     * @date: 2018/8/16 下午3:29
     *//*

    private Charset getFileEncode(String filePath) {
        try {
            File file = new File(filePath);
            CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
            detector.add(new ParsingDetector(false));
            detector.add(JChardetFacade.getInstance());
            detector.add(ASCIIDetector.getInstance());
            detector.add(UnicodeDetector.getInstance());
            Charset charset = null;
            charset = detector.detectCodepage(file.toURI().toURL());
            if (charset != null) {
                return charset;
            }
        } catch (Exception e) {
            log.error("get file encode error, filePath: " + filePath, e);
        }
        return Charset.forName("UTF-8");
    }



    */
/**
     * 获取 csv 文件信息
     *
     * @param fileName 文件名
     * @param tmpFilePath    接收到的文件对象
     * @return
     *//*

    public Map<String, Object> getCSVInfo(String fileName, String tmpFilePath) {
        Map<String, Object> result = new HashMap<String, Object>();
        String filePath = tmpFilePath;
        List titleList = new ArrayList();
        List valueList = new ArrayList();
        Map rowColumns = new HashMap();
        try {
            Charset fileEncode = getFileEncode(filePath);
            File fa = new File(filePath);
            FileInputStream fi = new FileInputStream(fa);
            CsvReader cr = new CsvReader(fi, fileEncode);
            int i = 0;
            while (cr.readRecord()) {
                if (i == 0) {
                    String[] rs = cr.getValues();
                    for (String s : rs) {
                        Map temp = new HashMap();
                        temp.put("name", s);
                        titleList.add(temp);
                    }
                } else {
                    if (isPriview && i > 100) break;
                    List temp = new ArrayList();
                    String[] rs = cr.getValues();
                    int k = 0;
                    for (String s : rs) {
                        Object value = rowColumns.get(k);
                        String val = (String) value;
                        if (!"string".equals(val)) {
                            if(!"double".equals(val)){
                                rowColumns.put(k, FileOperateUtil.getType(s));
                            }
                        }
                        temp.add(s);
                        k++;
                    }
                    valueList.add(temp);
                }
                i++;
            }
            cr.close();
            fi.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isPriview){
            valueList.add(0, rowColumns);
        }
        result.put("error", null);
        result.put("tablename", fileName.substring(0, fileName.lastIndexOf('.')));
        result.put("schema", titleList);
        result.put("data", valueList);
        result.put("columnstypes", rowColumns);
        return result;
    }
}
*/
