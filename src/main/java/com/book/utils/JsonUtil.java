package com.book.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: Json工具类
 * Date: 2018-06-11
 * Time: 16:16
 */
public class JsonUtil {

    private JsonUtil() {

    }

    /**
     * Objec转json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String json = null;
        if (object == null) {
            return json;
        }
        return JSON.toJSONString(object);
    }

    /**
     * json转Object
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * json转Map
     *
     * @param json
     * @return
     */
    public static Map<String, Object> toMap(String json) {
        return JSON.parseObject(json, Map.class);
    }

    /**
     * json转Map string
     *
     * @param json
     * @return
     */
    public static Map<String, String> toStringMap(String json) {
        Map<String, String> rstMap = null;
        Map<String, Object> map = toMap(json);
        if (map != null) {
            rstMap = new HashMap<String, String>();
            for (String s : map.keySet()) {
                rstMap.put(s, map.get(s) != null ? map.get(s).toString() : null);
            }
        }
        return rstMap;
    }

    /**
     * json转list
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    public static Map<String, String> URLRequest(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit = null;

        String strUrlParam = URL;
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

}