package com.book.service;

import com.book.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:54
 * @Version 1.0
 */
public interface FileService {
    /**
     * 批量导入数据
     * @param tbagentList
     */
    void batchInsert(List<UserInfo> userInfoList);

  /*  UserInfo addUserInfo(UserInfo userInfo);*/

    /**
     * Excel批量导入
     * @param file
     * @return
     */
    Integer importExcel(MultipartFile file);
}
