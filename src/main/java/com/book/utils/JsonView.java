package com.book.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: 一点点
 * @Date: 2018/10/4 13:02
 * @Version 1.0
 */
public class JsonView {

    // 默认成功code
    private final static Integer def_success_code = 0;

    private Integer code;

    private String msg = "";

    private Object data;

    public static JsonView build(Integer code, String msg, Object data) {
        return new JsonView(code, msg, data);
    }

    public static JsonView success(Object data) {
        return new JsonView(data);
    }

    public static JsonView success() {
        return new JsonView(null);
    }

    public JsonView() {

    }

    public static JsonView build(Integer code, String msg) {
        return new JsonView(code, msg, null);
    }

    public JsonView(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonView(Object data) {
        this.code = def_success_code;
        this.msg = "success";
        this.data = data;
    }

    public static  JsonView buildPage(Integer pages, Object data) {
        JSONObject json = new JSONObject();
        json.put("pages", pages);
        json.put("data", data);
        return new JsonView(json);
    }
}
