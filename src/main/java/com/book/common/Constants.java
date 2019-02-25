package com.book.common;

import java.time.format.DateTimeFormatter;

/**
 * @author${罗显}
 * @date 2019/2/21
 * @time 16:18
 */
public class Constants {

    public static String YES = "YES";
    public static String NO  = "NO";

    public static String UPPER = "Upper";
    public static String LOWER = "Lower";

    public static String START_WITH = "start";
    public static String END_WITH = "end";

    public static final String CHARSET_ENCODING = "UTF-8";
    public static final char SEPARATOR = '_';

    public static final String YYMMDD = "yyMMdd";
    public static final String YEAR_MONTH_DAY = "yyyy-mm-dd";
    public static final String YEAR_MONTH_DAY_H_M_S = "yyyy-mm-dd hh:mm:ss";

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");


}
