package com.book.tools;

import com.book.common.Constants;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.aspectj.bridge.Version.getTime;

/**
 * @author${罗显}
 * @date 2019/2/25
 * @time 10:05
 * 时间工具类
 */
@Slf4j
public class DateUtils {

    /**
     * 1.获取当前时间 format 格式
     */
    public static String getDateTime(DateTimeFormatter dtf){
        return dtf.format(LocalDateTime.now());
    }
    /**
     * 2.LocalDateTime 转换成String
     */
    public static String parseLocalDateTime(LocalDateTime localDateTime,DateTimeFormatter dtf){
        return dtf.format(localDateTime);
    }
    /**
     * 3.String 转换成 LocalDateTime
     */
    public static LocalDateTime parseString(String date){
        return LocalDateTime.parse(date, Constants.dtf);
    }
    /**
     * 4.获取当前日期的年月日
     */
    public static String curYearMonthDay(){
        LocalDate date = LocalDate.now();
        return date.getYear()+"年"+date.getMonthValue()+"月"+date.getDayOfMonth()+"日";
    }
    /**
     *
     */
    public static String getDateFormat(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }



}
