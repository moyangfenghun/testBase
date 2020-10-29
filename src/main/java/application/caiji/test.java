package application.caiji;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import javaBase.date.DateUtils;

public class test {
	public static void main(String[] args) throws Exception {
		System.out.println("开始"+new Date());
//		String insertsql="";
//		String values[]={"null"};
//		String sql_query="SELECT TABLE_NAME,COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE Table_schema='testdate'  and DATA_TYPE='timestamp' ";
//		RowSet executeQuery = mySqlHelper_local_pool.executeQuery(mySqlHelper_local_pool.Conn_local_mysql__testdate,sql_query,null);
//		while(executeQuery.next()){
//			String TABLE_NAME = executeQuery.getString("TABLE_NAME");
//			String COLUMN_NAME =executeQuery.getString("COLUMN_NAME");
//			String updatesql=" update `"+TABLE_NAME+"` set `"+COLUMN_NAME+"`=null where  `"+COLUMN_NAME+"`='0000-00-00' ";
//			System.out.println(updatesql);
//			mySqlHelper_local_pool.executeUpdate(mySqlHelper_local_pool.Conn_local_mysql__testdate, updatesql, null);
//		}
		
//		System.out.println(JsonConversionUtils.ResultToJson(executeQuery));
		
//		int parseInt = Integer.parseInt("8880820");
//		int parseInt2 = Integer.parseInt("4425575");
//		int parseInt3 = Integer.parseInt("4425575");
		
//		String str="阻燃性沥青玛𤧛酯和塑料膜最常用于()。";
//		System.out.println(new String(str.getBytes(), "GBK"));
//		String image = test.getImage("aslk]][[df[sadfasdf.jpg]asdf");
//		System.out.println("什么鬼"+image);
//		System.out.println("1234,1234,1234".matches("123"));
//		System.out.println("121,234".matches("^\\d+(,\\d+)*$"));
		
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd 00:00:01");
//		dateFormat.setLenient(false);
//		System.out.println(dateFormat.parse("2019121"));
//		System.out.println(dateFormat.format(new Date()));
//		long c=new Date().getTime();
//		List<String> list=new ArrayList<String>();
//		for (int i = 0; i < 1000000; i++) {
//			list.add("1"+i);
//			int f=9*9;
//			int a=9,n=10;
//			if(a>n) {
//				a--;
//			}else {
//				a++;
//			}
//			Date calculatorDate = DateUtils.calculatorDate(new Date(),10,DateUtils.DAY);
//		}
//		long a=new Date().getTime();
//		System.out.println("y"+(a-c));
//		String[] array = list.toArray(new String[list.size()]);
//		System.out.println("x"+(new Date().getTime()-a)+"|"+array.length);
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		simpleDateFormat.setLenient(false);
//		String strpt="2017-01-1";
//		simpleDateFormat.parse(strpt);
//		String replaceAll = strpt.substring(0,10).replaceAll("-", "");
//		System.out.println(replaceAll.length());
//		System.out.println(Integer.parseInt(replaceAll));
//		StringBuilder str=new StringBuilder();
//		str.append("asdfasdf");
//		System.out.println(str+"|"+new Date() );
		
//		InputStream in = test.class.getClassLoader().getResourceAsStream("config.properties");
//        Properties p = new Properties();
//        p.load(in);
//        String property = p.getProperty("migrateDataWr");
//        System.out.println(property);
		System.out.println("结束"+new Date());
	}


	public static String getImage(String st) {
        String str = "";
        if (st == null) {
            return str;
        }
        if (st.contains("[") & st.contains("]")&&(st.indexOf("[") + 1)<st.indexOf("]")) {
            String changestr = change(st.substring(st.indexOf("[") + 1, st.indexOf("]")));
            str = st.replace(st.substring(st.indexOf("[") + 1, st.indexOf("]")), changestr);
        } else {
            str = st;
        }
        String result = "";
        if (str.length() > 0) {
            str = str.replace("点gif", ".gif").replace("［", "[").replace("］", "]");
            result = str;
            result = result.replace("&quot;", "\"").replace("＇", "'").replace("&#39;", "'");
            String pattern = "\\<img src=\\u0022(.+?)\\u0022 onload=\\u0022resizeImgSize\\(this\\);\\u0022>";
            result = result.replaceAll(pattern, "<img src='http://image.bgycyks.com/$1'>");
            String pattern1 = "\\[([^\\]\\[]+\\.gif)\\]";
            result = result.replaceAll(pattern1, "<img src='http://attachment.cnbkw.com/bkwimg/$1'>");
            String pattern2 = "\\[([^\\]\\[]+\\.jpg)\\]";
            result = result.replaceAll(pattern2, "<img src='http://attachment.cnbkw.com/bkwimg/$1'>");
            String pattern3 = "\\[([^\\]\\[]+\\.png)\\]";
            result = result.replaceAll(pattern3, "<img src='http://attachment.cnbkw.com/bkwimg/$1'>");
            String pattern4 = "\\[([^\\]\\[]+\\.bmp)\\]";
            result = result.replaceAll(pattern4, "<img src='http://attachment.cnbkw.com/bkwimg/$1'>");
        }
        String imresult = result.replace("\r", "").replace("\n", "").replace("\t", "").replace("\\", "/");
        return imresult;
    }
	
	public static String change(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            //如果是小写
            if (str.substring(i, i + 1).equals(str.substring(i, i + 1).toLowerCase())) {
                sb.append(str, i, i + 1);
            } else {
                sb.append(str.substring(i, i + 1).toLowerCase());
            }
        }
        return sb.toString();
    }
	
//	@Test
	public void test() throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = dateFormat.parse("2017-01-16 11:00:43");//beganTime-1
		Date parse2 = dateFormat.parse("2017-01-20 23:00:00");//last-startTime
		int daysBetween = test.daysBetween(parse.getTime(),parse2.getTime());
		//2017-01-15 00:00:00__2017-01-20 23:00:00 5  |2017-01-16__2017-01-20 23:59:59.999 61
		//                     2017-03-18
		//显示为 1.16---1.19  0+1=1--4
		//     1.20---3.18  4+1=5
		//再开始的时候加1天没问题，显示的时候最后1个阶段最后1天显示包含了考试的那一天所以就多了1天
		System.out.println(daysBetween);
	}
	
	private static int daysBetween(long smdate, long bdate) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(smdate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long time1 = cal.getTimeInMillis();
		cal.setTimeInMillis(bdate);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.MILLISECOND, 0);
		long time2 = cal.getTimeInMillis();
		long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}
	/**
	 * 给定时间累加天数
	 */
	private static Timestamp addDay(Timestamp time, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time.getTime());
		cal.add(Calendar.DAY_OF_YEAR, day);
		return new Timestamp(cal.getTimeInMillis());
	}
//	@Test
	public void test2() {
//		dataCheck();
	}
	/**
	 * 数据核对,用于数据量条件数量相等的情况,两组数据要使用相同的排序
	 */
	public void dataCheck() {
		// TODO 数据核对,用于数据量条件数量相等的情况,两组数据要使用相同的排序
		String str1="";
		String replaceAll[]= str1.split("\\r\\n");
		String fenge="";
		String str2="";
		String strarray[]= str2.split("\\r\\n");
//		System.out.println(replaceAll[0]);
		int number=0;
		if(strarray.length>replaceAll.length) {
			number=strarray.length;
		}else {
			number=replaceAll.length;
		}
		for (int i = 0; i < number; i++) {
			if(!strarray[i].equals(replaceAll[i])){
				System.out.println(i+"|"+replaceAll[i]+"|"+strarray[i]);
			}
		}
	
	}
	
	public void dataifCheck() {
		// TODO 条件核对用户条件或数据量不同的情况，找出不同的条件
		String str1="";
		String ss="";
		String str2="";
		str1 = str1.replaceAll("(	| )","_").replaceAll("-", "");
		str2 = str2.replaceAll("(	| )","_").replaceAll("-", "");
		String[] split = str1.split("\\r\\n");
		String[] split2 = str2.split("\\r\\n");
		for (int i = 0; i < split2.length; i++) {
			if(str1.indexOf(split2[i])<0) {
				System.out.println("str1不包含"+i+"|"+split2[i]);
			}
		}
		for (int i = 0; i < split.length; i++) {
			if(str2.indexOf(split[i])<0) {
				System.out.println("str2不包含"+i+"|"+split[i]);
			}
		}
		
	}
	
//	@Test
	public void addding() {
		String str="360bidding,sogoubidding,baidubidding,shenmabidding,360info,bzbidding,oppobidding,ucbidding,vivoinfo,wifibidding,wpsinfo,jdlkbidding,jrttbidding,youkubidding,fhbidding,huaweiinfo,xhsbidding,gdtbidding,weilibidding,ksbidding,douyinbidding,pinduoduo,fuyibidding,zlzpbidding,iqybidding,baiduinfo,zhihubidding,infoflow_shenma,fstbidding,wymusic,mybidding,txmpbidding,qttbidding,androidapp,iosapp,h5bidding,jdshop,searchengines,crmadd,other,tgregister,ttapp,xiaoetong,weixinapp,jdkbidding,textbook,baiduapp,directvisit,infosite,referral,crm";
		String[] split = str.split(",");
		String lll="";
		for (int i = 0; i < split.length; i++) {
			lll+="'"+split[i]+"',";
		}
		System.out.println(lll);
	}
	
}
