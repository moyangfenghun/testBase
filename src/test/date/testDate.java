package yers.test.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

import org.junit.Test;

public class testDate {
	@Test
	public void test(){
		String date="2019-04-11 07:22:01";
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime dateTime=LocalDateTime.now();
		//新版日期转化为字符串
		DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = dateTime.format(timeFormatter);
		//字符串转化为日期类型
		LocalDateTime parse2 = LocalDateTime.parse(date,timeFormatter);
		
		System.out.println(format);
		System.out.println(parse2.format(timeFormatter));
		//获取秒数
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		//获取毫秒数
		Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		//date转localdatetime
//		date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
		//将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
//		Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
	}
}
