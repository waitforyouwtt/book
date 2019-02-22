package com.book.jpaRepository;

import com.book.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:52
 * @Version 1.0
 */
public interface UserInfoMapper extends JpaRepository<UserInfo,Integer> {
    /**
     * 根据用户昵称和密码查询用户信息
     * @param nickName
     * @param passWord
     */
    UserInfo findByNickNameAndPassword(String nickName,String passWord);
}
