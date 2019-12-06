package application.caiji;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import newVersionOrInstance.http.HttpClientUtil;
import newVersionOrInstance.http.httprequestUtil;

public class maintest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始...");
//		Date date=new Date();
//		String sendGet = httprequestUtil.sendGet("http://datacollect.cnbkw.com:8088/tuiguangnew/ordertotuiguang?size=100");
//		long s=  new Date().getTime()-date.getTime();
//		System.out.println(sendGet+"| "+ s*1.0/1000);
		
//		System.out.println(new BigDecimal("12.3")+"|");
		
//		String sendGet = httprequestUtil.sendGet("https://cn.bing.com/?FORM=Z9FD1");
//		System.out.println(sendGet);
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.MONTH,10);
		int actualMaximum = calendar.getActualMaximum(Calendar.DATE);
		System.out.println(actualMaximum);
		System.out.println(calendar.getMaximum(Calendar.DATE));
		System.out.println(calendar.getActualMaximum(Calendar.MONTH));
		System.out.println(calendar.getMaximum(Calendar.MONTH));
	}
}
