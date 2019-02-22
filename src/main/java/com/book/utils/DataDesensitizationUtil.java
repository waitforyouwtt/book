package com.book.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ${罗显} on 2018/10/22
 * 数据脱敏
 */
public class DataDesensitizationUtil {
    /**
     * 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     *
     * @param fullName
     * @param index    1 为第index位
     * @return
     */
    public static String left(String fullName, int index) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, index);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * [身份证号] 110****58，前面保留3位明文，后面保留2位明文
     *
     * @param name
     * @param index 3
     * @param end   2
     * @return
     */
    public static String around(String name, int index, int end) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.left(name, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(name, end), StringUtils.length(name), "*"), "***"));
    }

    /**
     * [固定电话] 后四位，其他隐藏<例子：****1234>
     *
     * @param num
     * @return
     */
    public static String right(String num, int end) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, end), StringUtils.length(num), "*");
    }

    public static void main(String[] args) {
        System.out.println(DataDesensitizationUtil.around("13020109560", 3, 4));
    }
}
