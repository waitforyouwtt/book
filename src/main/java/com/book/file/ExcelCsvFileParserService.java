/*
package com.book.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
*/
/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 16:29
 *//*

public interface ExcelCsvFileParserService {

    */
/**
     * 获取上传文件的目录
     * @param userId 用户ID
     * @param file 用户上传的文件
     * @return
     *//*

    String getUploadPath(String userId,MultipartFile file);

    */
/**
     * 上传文件取消获取上传完成
     * 删除临时文件
     * @param userId 用户ID
     * @param fileName 用户上传的文件名
     * @return
     *//*

    boolean handlePreviewCancel(String userId,String fileName);

    */
/**
     * 获取处理后的结果
     * @param isPreview
     * @param filename
     * @param fullPath
     * @return
     *//*

    Map<String, Object> HandlerFile(boolean isPreview,String filename,String fullPath);

}
*/
