package test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class mydate  {
	@Test
	public void test() throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		//Date date=new Date();
		//date=dateFormat.parse("2015-06-3");将字符日期化
		//System.out.println(date);
		//将日期字符化
		//new timetest().getsss();
		Calendar calendar=Calendar.getInstance();
		System.out.println(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, -3);
		System.out.println(dateFormat.format(calendar.getTime()));
	}
}
