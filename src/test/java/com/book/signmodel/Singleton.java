package com.book.signmodel;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 14:15
 * @Version 1.0
 */
public class Singleton {
    //懒汉模式
    private static Singleton instanceL;
    private Singleton (){}
    public static Singleton getInstanceL(){
        if(instanceL == null){
            instanceL = new Singleton();
        }
        return instanceL;
    }

    //饿汉模式
    private static Singleton instanceE = new Singleton();
    public static Singleton getInstanceE(){
        if (instanceE == null){
            instanceE = new Singleton();
        }
        return instanceE;
    }
    //双重检索
    private volatile static Singleton singletonS;
    public static Singleton getInstanceS(){
        if (singletonS == null){
            synchronized (Singleton.class){
                if (singletonS == null){
                    singletonS = new Singleton();
                }
            }
        }
        return singletonS;
    }
}
