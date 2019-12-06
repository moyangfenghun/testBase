package javaBase.date;

import java.util.Date;

public class dateUtils {
	public static final String YEARS="y";
	public static final String MONTH="M";
	public static final String DAY="d";
	public static final String HOUR="H";
	public static final String MINUTE="m";
	public static final String SECONDS="s";
	/**
	 * 
	 * @param date 日期
	 * @param s  需要加减的时间单位数量,正数为加，负数为减
	 * @param i  单位 YEARS,MONTH,DAY,HOUR,MINUTE,SECONDS
	 * @return
	 */
	public static Date calculatorDate(Date date,int s,String m){
		Date redate=null;
		switch (m) {
		case YEARS:
			redate=new Date(date.getTime()+s*1000*60*60*24*365l);
			break;
		case MONTH:
			redate=new Date(date.getTime()+s*1000*60*60*24*30l);
			break;
		case DAY:
			redate=new Date(date.getTime()+s*1000*60*60*24l);
			break;
		case HOUR:
			redate=new Date(date.getTime()+s*1000*60*60l);
			break;
		case MINUTE:
			redate=new Date(date.getTime()+s*1000*60l);
			break;
		case SECONDS:
			redate=new Date(date.getTime()+s*1000l);
			break;
		default:
			break;
		}
		return redate;
	}
}
