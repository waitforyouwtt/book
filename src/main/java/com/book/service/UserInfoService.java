package com.book.service;

import com.book.entity.UserInfo;

/**
 * @author${罗显}
 * @date 2019/2/22
 * @time 11:20
 */
public interface UserInfoService {
    /**
     * 用户登陆
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    UserInfo save(UserInfo userInfo);
}
