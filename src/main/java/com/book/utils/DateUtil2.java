package com.book.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Created by ${罗显} on 2018/10/22
 */
public class DateUtil2 {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //1. 获得当天的日期
    public static LocalDate getNow(){
        LocalDate date = LocalDate.now();
        return date;
    }
    //2. 获取当前日期的年月日
    public static String curYearMonthDay(){
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        return year+"年"+month+"月"+day+"日";
    }
    //3. 获取特定的日期
    public static LocalDate givenDate(){
        LocalDate givenDate = LocalDate.of(2016, 7, 27);
        return givenDate;
    }
    //4. 比较两个日期是否相等
    public static boolean equalsDate(LocalDate var1,LocalDate var2){
        if (var1 == null || var2 == null){
            return false;
        }
        if(var1.equals(var2)) {
            return true;
        }else {
            return false;
        }
    }
    //5. 比较MonthDay是否相同
    public static boolean equalsMonthDay(LocalDate var1){

        LocalDate day = LocalDate.now();
        MonthDay birthday = MonthDay.of(var1.getMonth(), day.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(day);
        if(currentMonthDay.equals(birthday)) {
            return true;
        }else {
            return false;
        }
    }
    //6.获取当前时间
    public static LocalTime getTime(){
        LocalTime time = LocalTime.now();
        return time;
    }
    //7.在现有的时间上增加小时
    public static LocalTime addHourse(int hour){
        LocalTime time = LocalTime.now();
        // adding two hours
        LocalTime newTime = time.plusHours(2);
        return newTime;
    }
    //8.计算一周后的日期
    public static LocalDate aWeekLater(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        return nextWeek;
    }
    //9、计算一年前
    public static LocalDate previousYear(){
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, YEARS);
        return previousYear;
    }
    //9-2 计算一年后的日期
    public static LocalDate nextYear(){
        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plus(1, YEARS);
        return nextYear;
    }
    //10、使用Java 8的Clock时钟类
    public static Clock systemUTC(){
        Clock clock = Clock.systemUTC();
        return clock;
    }
    //11.判断日期是早于还是晚于另一个日期
    public boolean isBefore(LocalDate tommorow){
        LocalDate today = LocalDate.now();
        if(tommorow.isAfter(today)){
            return false;
        }else{
            return true;
        }
    }

    //13.如何表示信用卡到期这类固定日期，答案就在YearMonth
    public static YearMonth daoqi(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        return creditCardExpiry;
    }
    //14.Java 8中检查闰年
    public static String runYear(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            return "平年";
        }else {
            return "闰年";
        }
    }
    //18.在Java 8中如何使用预定义的格式化工具去解析或格式化日期.
    public static LocalDate toString(String dayAfterTommorrow, String format){
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        return formatted;
    }
    //19.diy 日期
    public static String diyDate() throws DateTimeParseException {
        LocalDateTime arrivalDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss");
        String landing = arrivalDate.format(format);
        return landing;
    }

    public static String getDateyyyyMMddHHmmss() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date())+"0000";
    }
    /**
     * 获取指定日期所在周的第一天和最后一天,用下划线连接
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastOfMonth(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1);
        String first = new SimpleDateFormat(resultDateFormat).format(c.getTime());
        System.out.println("first:"+first);
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat(resultDateFormat).format(ca.getTime());
        System.out.println("last:"+last);
        return first+"_"+last;
    }

    /**
     * 每周的第一天和最后一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     * @return
     * @throws ParseException
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

        System.out.println("data1----:"+data1+",\n data2----:"+data2);
        return data1 + "_" + data2;
    }

    public static void main(String[] args) throws ParseException {
        //getFirstAndLastOfMonth("2018-10-22","yyyy-MM-dd","yyyy-MM-dd hh:mm:ss");
        getFirstAndLastOfMonth("2018-10-22","yyyy-MM-dd","yyyy-MM-dd hh:mm:ss");
    }
}
