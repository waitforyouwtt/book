package com.book.signmodel;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 15:35
 * @Version 1.0
 */
public class ConcreteFactory1 extends Factory{
    @Override
    public Product factoryMethod() {
        return  new Concrete2Product();
    }
}
