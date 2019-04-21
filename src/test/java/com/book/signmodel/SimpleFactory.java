package com.book.signmodel;

import com.book.signmodel.Concrete2Product;
import com.book.signmodel.Concrete3Product;
import com.book.signmodel.ConcreteProduct;
import com.book.signmodel.Product;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 14:52
 * @Version 1.0
 */
public class SimpleFactory {

    public Product createProduct(int type){
        if (type == 1){
            return new ConcreteProduct();
        }else if(type == 2){
            return  new Concrete2Product();
        }
        return new Concrete3Product();
    }
}
