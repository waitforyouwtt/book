package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @Author: 一点点
 * @Date: 2018/10/7 9:58
 * @Version 1.0
 */
@Component
public class RedisToken {

    @Autowired
    private BaseRedisService baseRedisService;

    private static final long TOKENTIME = 60*60;

    public String getToken(){
        String token = "token"+ UUID.randomUUID();
        baseRedisService.setString(token,token,TOKENTIME);
        return token;
    }

    public boolean checkToken(String tokenKey){
        String tokenValue = baseRedisService.getString(tokenKey);
        if(StringUtils.isEmpty(tokenValue)){
            return false;
        }
        // 保证每个接口对应的token只能访问一次，保证接口幂等性问题
        baseRedisService.delKey(tokenKey);
        return true;
    }
}
