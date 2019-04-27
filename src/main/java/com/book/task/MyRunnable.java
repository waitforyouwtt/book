package com.book.task;

import com.book.utils.FrameSpringBeanUtil;
import com.book.utils.RedisUtil;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: 一点点
 * @Date: 2019/4/23 20:51
 * @Version 1.0
 */
public class MyRunnable implements Runnable {

    //因为是多线程所以无法注入bean 对象，只能通过下面方法去获取bean 对象

    private JedisCluster jedisCluster = FrameSpringBeanUtil.getBean(JedisCluster.class);

    @Override
    public void run() {
        //加锁，调用工具类
        boolean lock = RedisUtil.tryGetDistributedLock( jedisCluster,MyRunnable.class.toString(),MyRunnable.class.toString(),3000 );
        //加锁成功则执行业务，不成功不执行业务
        if (lock){
            System.out.println("执行业务代码");
            //业务执行完成解锁，如果在执行业务中或者解锁异常，宕机，锁会根据加锁时的key 过期时间自己消除
            RedisUtil.releaseDistributedLock( jedisCluster,MyRunnable.class.toString(),MyRunnable.class.toString() );
        }

    }
}
