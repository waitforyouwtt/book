package com.book.signmodel;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 14:54
 * @Version 1.0
 */
public class SignModelTest {

    //简单工厂
    public void productTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct( 1 );
        //todo something
    }


}
