package com.book;

import com.book.common.Constants;
import com.book.tools.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {

	@Test
	public void saveUser() throws ParseException {
		System.out.println("获取时间："+DateUtils.getDateTime(Constants.dtf));
		System.out.println("LocalDateTime 转换成String:"+ DateUtils.parseLocalDateTime(LocalDateTime.now(),Constants.dtf));
		System.out.println("LocalDateTime 转换成String:"+ DateUtils.parseString("2018-02-12 17:07:05"));
		System.out.println("获取当前日期的年月日:"+ DateUtils.curYearMonthDay());
		System.out.println("获取下n月"+DateUtils.getNextMon(2));

		SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simFormat.parse("2008-01-23 22:45:56");
		System.out.println("获取每周的第一天和最后一天:"+DateUtils.getFirstAndLastOfWeek("2019-02-25",Constants.YEAR_MONTH_DAY,Constants.YEAR_MONTH_DAY));
		//System.out.println("获取前days日:"+DateUtils.getDateForDayBefor(2,Constants.YEAR_MONTH_DAY));
		System.out.println("时间相加："+DateUtils.addTime(date,2, Constants.YEAR));
		System.out.println("根据字符串和指定格式生成日期："+DateUtils.getDate("2019-02-25", Constants.YEAR_MONTH_DAY));

		Date smdate = new Date();
		Date bdate = simFormat.parse("2008-02-23 22:45:56");
		System.out.println("计算两个日期之间相差的天数："+DateUtils.daysBetween(smdate,bdate));
		System.out.println("date 转 string："+DateUtils.fyFormatDate(smdate,Constants.YEAR_MONTH_DAY_H_M_S));
		Instant instant = Instant.ofEpochMilli(0L);
		System.out.println("instant 转date："+DateUtils.fromInstant(instant));
		System.out.println("在现有的时间上增加小时："+DateUtils.addHourse(2));
		System.out.println("计算一周后的日期："+DateUtils.aWeekLater(2));

	}

}
