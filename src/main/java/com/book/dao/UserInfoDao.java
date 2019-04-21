package com.book.dao;

import com.book.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:54
 * @Version 1.0
 */
public interface UserInfoDao {
    /**
     * 批量导入数据
     * @param
     */
    void batchInsert(List<UserInfo> userInfoList);

    UserInfo addUserInfo(UserInfo userInfo);

    List<UserInfo> findAll();
}
