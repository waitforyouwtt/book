package com.book.serviceimpl;

import com.book.dao.master.UserInfoMasterDao;
import com.book.entity.UserInfo;
import com.book.jpaRepository.UserInfoMapper;
import com.book.service.UserInfoService;
import com.book.utils.SendEMail;
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
    UserInfoMasterDao userInfoDao;
    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.findByNickNameAndPassword(userInfo.getNickName(),userInfo.getPassword());
    }

    @Override
    public UserInfo addUserInfo(UserInfo userInfo) {
        String emailMsg = "请点击<a href='http://127.0.0.1:8080/mvc/activeServlet?activeCode=\"+userInfo.getActiveCode()+\"'>激活邮箱</a>";
        SendEMail.sendMail(userInfo.getEmail(), emailMsg);

        UserInfo u= new UserInfo(  );
        u.setUserId(  "111");
        return u;
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }
}
