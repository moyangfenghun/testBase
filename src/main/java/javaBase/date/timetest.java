package javaBase.date;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class timetest {
	public void date() {
		Calendar time = Calendar.getInstance();
		System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy/MM/dd D");
		System.out.println(sFormat.format(time.getTime()));
	}
	
	//获取格林尼治时间
	public void getsss() {
		Date date=new Date();
		//date.getTime();
		Calendar.getInstance().getTimeInMillis();
		System.currentTimeMillis();
		Clock.systemDefaultZone().millis();//java 8
		System.out.println(System.currentTimeMillis()+"||"+ date.getTime());
	}
	public void getdatemaxmonth() {
		Calendar time = Calendar.getInstance();
		System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	public void gettime() {
		Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
 
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
	}
	public void formate() {
		SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
 
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
	}
	//获取昨天的这个时候
	public void getyesterday() {
		LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);//减一天

        System.out.println(yesterday);
	}
}
