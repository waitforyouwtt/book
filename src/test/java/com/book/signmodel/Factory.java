package com.book.signmodel;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 15:32
 * @Version 1.0
 */
public abstract class Factory {

    abstract  public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
        //todo something
    }
}
