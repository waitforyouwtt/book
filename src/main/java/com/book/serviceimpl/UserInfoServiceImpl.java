package com.book.serviceimpl;

import com.book.dao.UserInfoDao;
import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author${罗显}
 * @date 2019/2/22
 * @time 11:21
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.findByNickNameAndPassword(userInfo.getNickName(),userInfo.getPassword());
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoMapper.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }
}
