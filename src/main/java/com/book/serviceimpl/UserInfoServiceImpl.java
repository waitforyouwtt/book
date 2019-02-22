package com.book.serviceimpl;

import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.findByNickNameAndPassword(userInfo.getNickName(),userInfo.getPassword());
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoMapper.save(userInfo);
    }
}
