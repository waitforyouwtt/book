/*
package com.book.file;


import com.easou.datasource.service.util.CSVUtils;
import com.easou.datasource.service.ExcelCsvFileParserService;
import com.easou.datasource.service.util.ExcelUtils;
import com.easou.datasource.service.util.FileOperateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

*/
/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 16:31
 *//*

public class ExcelCsvFileParserServiceImpl implements ExcelCsvFileParserService {

    @Override
    public Map<String, Object> HandlerFile(boolean isPreview,String filename,String fullPath) {
        //  判断文件类型 是excel 文件还是csc
        if (".csv".equals(filename.toLowerCase().substring(filename.toLowerCase().lastIndexOf('.')))) {
            return new CSVUtils(isPreview).getCSVInfo(filename, fullPath);
        } else {
            return new ExcelUtils(isPreview).getExcelInfo(filename, fullPath);
        }
    }
    @Override
    public boolean handlePreviewCancel(String userId,String fileName){
        boolean isDelete  = false;
        // 获取上传目录
        File upload = FileOperateUtil.getAbsoluteUploadPath();
        // 临时存放文件目录
        String tmpPath= upload + File.separator +userId+File.separator;
        String fullPath = tmpPath + fileName;
        File tempFilePath = new File(fullPath);
        if (tempFilePath.exists()) {
            isDelete = tempFilePath.delete();
        }
        return isDelete;
    }

    @Override
    public String getUploadPath(String userId, MultipartFile file) {
        String filename = file.getOriginalFilename();
        // 获取上传目录
        File upload = FileOperateUtil.getAbsoluteUploadPath();
        // 临时存放文件目录
        String tmpPath= upload + File.separator +userId+File.separator;
        File tempFilePath = new File(tmpPath);
        if (!tempFilePath.exists()) tempFilePath.mkdirs();
        String fullPath = tmpPath + filename;
        try {
            // 保存临时文件
            file.transferTo(new File(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullPath;
    }
}
*/
