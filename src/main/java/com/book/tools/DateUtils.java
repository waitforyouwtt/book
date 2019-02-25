package com.book.tools;

import com.book.common.Constants;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


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
     * 5.获取下n月
     *
     * @return
     */
    public static Date getNextMon(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +month);
        return calendar.getTime();
    }
    /**
     * 6.获取指定日期的 周的第一天和最后一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     */
    public static String getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        return data1 + "_" + data2;
    }

    /**
     * 7.根据类型在原时间上加相应的天数/
     * @param date
     * @param number
     * @param type
     * @return
     */
    public static Date addTime(Date date, int number,String type){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        if(Constants.YEAR.equals(type)){
            calendar.add(Calendar.YEAR, number);
        }else if(Constants.MONTH.equals(type)){
            calendar.add(Calendar.MONTH, number);
        }else if(Constants.DAY.equals(type)){
            calendar.add(Calendar.DAY_OF_MONTH, number);
        }else if(Constants.HOUR.equals(type)){
            calendar.add(Calendar.HOUR, number);
        }else if(Constants.MINUTE.equals(type)){
            calendar.add(Calendar.MINUTE, number);
        }
        return calendar.getTime();
    }
    /**
     * 8.根据字符串和指定格式生成日期
     *
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 9.计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 10.date 转 string
     * return yyyyMMdd
     * @param date
     * @return
     */
    public static String fyFormatDate(Date date,String format) {
        SimpleDateFormat sdf = null;
        if(Constants.YEAR_MONTH_DAY.equals(format)){
            sdf =  new SimpleDateFormat(Constants.YEAR_MONTH_DAY);
        }else if(Constants.YEAR_MONTH_DAY_H_M_S.equals(format)){
            sdf = new SimpleDateFormat(Constants.YEAR_MONTH_DAY_H_M_S);
        }
        return sdf.format(date);
    }
    /**
     * 11.instant 转date
     * @param instant
     */
    public static Date fromInstant(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     *  12.在现有的时间上增加小时
     */

    public static LocalTime addHourse(int hour){
        LocalTime time = LocalTime.now();
        // adding two hours
        LocalTime newTime = time.plusHours(hour);
        return newTime;
    }
    //13.计算一周后的日期
    public static LocalDate aWeekLater(int week){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(week, ChronoUnit.WEEKS);
        return nextWeek;
    }
    // 14. java.util.Date --> java.time.LocalDateTime
    public static void UDateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public void UDateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }




}
