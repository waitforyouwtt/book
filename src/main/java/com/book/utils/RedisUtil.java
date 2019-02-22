package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by ${罗显} on 2018/10/22
 */
@Repository
public class RedisUtil {
    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value) {
        ValueOperations<String, String > ops = template.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}
