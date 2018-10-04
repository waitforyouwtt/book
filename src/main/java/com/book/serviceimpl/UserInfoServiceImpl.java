package com.book.serviceimpl;

import com.book.dao.UserInfoDao;
import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:55
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public void batchInsert(List<UserInfo> userInfoList) {
        userInfoDao.batchInsert(userInfoList);
    }
}
