package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
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

    private static final String LOCK_SUCCESS= "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIER_TIME = "PX";
    private static final Long   RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param jedis 客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超时实践 毫秒
     * @return
     */
    public static boolean tryGetDistributedLock(JedisCluster jedis,String lockKey,String requestId,int expireTime){
        //设置锁并设置超时时间，lockKey 标识redis key ,requestId 标识redis value  ,set_if_not_exist 表示有值不设置setNX
        //set_with_expire_time 表示是否设置超时时间PX 设置，expireTime 表示设置超时时间的毫秒值
        String result = jedis.set( lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIER_TIME,expireTime );
       if (LOCK_SUCCESS.equals( requestId )){
           return true;
       }
       return false;
    }

    /**
     * 释放分布式锁
     * @param jedis 客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(JedisCluster jedis,String lockKey,String requestId){
        /**
         * 利用Lua 脚本代码，首先获取锁对应的value 值，检查是否与requestId相等，如果相等则删除锁
         * eval 命令执行Lua 代码的时候，Lua 代码将被当成一个命令去执行，并且直到eval 命令执行完成，
         * redis 才会执行其他命令，这样就不会出现上一个代码执行完挂了后边的出现问题，还是一致性的解决
         */
        String script = "if redis.call('get',KEYS[1] == argv(1) then return redis.call('del',KEYS[1])) else return 0 end";
        Object result = jedis.eval( script, Collections.singletonList(lockKey),Collections.singletonList( requestId ) );

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
