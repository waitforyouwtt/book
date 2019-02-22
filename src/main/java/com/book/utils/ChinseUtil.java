package com.book.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${罗显} on 2018/10/25
 */
public class ChinseUtil {
    public ChinseUtil() {
    }

    public static boolean isChineseStr(String str) {
        Pattern pattern = Pattern.compile("^[\u4E00-\u9FA5]+$");
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; ++i) {
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if (!matcher.matches()) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println(true);
        return true;
    }


    public static int getLength(String s) {
        int valueLength = 0;
        String chinese = s;

        for (int i = 0; i < s.length(); ++i) {
            String temp = s.substring(i, i + 1);
            if (temp.matches(chinese)) {
                ++valueLength;
            } else {
                ++valueLength;
            }
        }
        System.out.println("长度："+valueLength);
        return valueLength;
    }

    public static void main(String[] args) {
        isChineseStr("abc");
        getLength("中国");
    }
}
