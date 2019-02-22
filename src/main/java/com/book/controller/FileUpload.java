package com.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/mvc")
public class FileUpload {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 前往文件上传页面
     */
    @RequestMapping(value = "/upload-page")
    public String uploadPage(){
        return "upload-page";
    }

    /**
     * 文件上传相关代码
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        long size = file.getSize();
        double fileSize = size /1024;

        if(fileSize > 300){
            return "单张图片不允许超过300KB，请压缩后再上传!";
        }

        System.out.println("获取文件大小："+size);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://test//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


    /**
     * 实现多文件上传[两种方式都可以]
     * */
    @RequestMapping(value="/multi-file-upload",method= RequestMethod.POST)
    // public @ResponseBody String multifileUpload(@RequestParam("files")List<MultipartFile> files){
    public @ResponseBody
    String multifileUpload(HttpServletRequest request){

        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("files");

        if(files.isEmpty()){
            return "false";
        }

        String path = "E:/test" ;

        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                //判断文件父目录是否存在
                if(!dest.getParentFile().exists()){
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }

}
