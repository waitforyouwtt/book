package com.book;

import com.book.common.Constants;
import com.book.tools.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;

public class DateTest {

	@Test
	public void saveUser(){
		System.out.println("获取时间："+DateUtils.getDateTime(Constants.dtf));
		System.out.println("LocalDateTime 转换成String:"+ DateUtils.parseLocalDateTime(LocalDateTime.now(),Constants.dtf));
		System.out.println("LocalDateTime 转换成String:"+ DateUtils.parseString("2018-02-12 17:07:05"));
		System.out.println("获取当前日期的年月日:"+ DateUtils.curYearMonthDay());
		System.out.println("----"+DateUtils.getDateFormat(Constants.YEAR_MONTH_DAY));


	}

}
