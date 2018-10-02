package com.book.jpaRepository;

import com.book.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:52
 * @Version 1.0
 */
public interface UserInfoMapper extends JpaRepository<UserInfo,Integer> {

}
