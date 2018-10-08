package com.book.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 一点点
 * @Date: 2018/10/7 10:43
 * @Version 1.0
 * 解决接口幂等性问题,支持网络延迟和表单提交
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {
    //区分请求来源
    String type();
}
