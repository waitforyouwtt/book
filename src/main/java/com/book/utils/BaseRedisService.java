package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 一点点
 * @Date: 2018/10/7 9:59
 * @Version 1.0
 */
@Component
public class BaseRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,Object data,Long timeout){
        if(data instanceof String){
            String value = (String) data;
            stringRedisTemplate.opsForValue().set(key,value);
        }
        if(timeout != null){
            stringRedisTemplate.expire(key,timeout,TimeUnit.SECONDS);
        }
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void delKey(String key){
        stringRedisTemplate.delete(key);
    }

}
