package com.book.dao.slaver;

import com.book.entity.UserInfo;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:54
 * @Version 1.0
 */
public interface UserInfoSlaverDao {
    /**
     * 批量导入数据
     * @param
     */
    void batchInsert(List<UserInfo> userInfoList);

    UserInfo addUserInfo(UserInfo userInfo);

    List<UserInfo> findAll();

    int addUser(UserInfo userInfo);

    int deleteUserById(Long id);

    int updateUserById(UserInfo user);

    UserInfo queryUserById(Long id);

    List<UserInfo> queryUserList();
}
