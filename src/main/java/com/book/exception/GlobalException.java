package com.book.exception;

import com.book.enums.ResultEnum;

/**
 * @Author: 一点点
 * @Date: 2018/10/4 14:15
 * @Version 1.0
 */
public class GlobalException extends RuntimeException {

    private Integer code;

    public GlobalException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

   public GlobalException(Integer code, java.lang.String message){

        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
