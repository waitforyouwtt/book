package com.book.controller;

import java.io.InputStream;

/**
 * @author${罗显}
 * @date 2018/12/27
 * @time 13:49
 */
public class FileUtil {
    public static InputStream getResourcesFileInputStream(String fileName) {

        System.out.println("当前路径是："+Thread.currentThread().getContextClassLoader());
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }
}
