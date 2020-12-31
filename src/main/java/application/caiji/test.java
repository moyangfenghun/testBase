package application.caiji;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import application.caiji.unitls.MysqlDataUtils;
import javaBase.date.DateUtils;
import suanfa.paixu.paixu;

public class test {
	public static void main(String[] args) throws Exception {
		System.out.println("开始" + new Date());
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

//		String str="阻燃性沥青玛𤧛酯和塑料膜最常用于()。";修改数据库 
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

//		InputStream in = test.class.getClassLoader().getResourceAsStream("config.properties");
//        Properties p = new Properties();
//        p.load(in);
//        String property = p.getProperty("migrateDataWr");
//        System.out.println(property);
//		int m=4,n=4;
//		System.out.println( -1 << (n - 1));
//        int ret = m * (1 << (n - 1));
		String str="北京田径";
        System.out.println(str.indexOf("北京"));
		System.out.println("结束" + new Date());
	}

	public static String getImage(String st) {
		String str = "";
		if (st == null) {
			return str;
		}
		if (st.contains("[") & st.contains("]") && (st.indexOf("[") + 1) < st.indexOf("]")) {
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
			// 如果是小写
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = dateFormat.parse("2017-01-16 11:00:43");// beganTime-1
		Date parse2 = dateFormat.parse("2017-01-20 23:00:00");// last-startTime
		int daysBetween = test.daysBetween(parse.getTime(), parse2.getTime());
		// 2017-01-15 00:00:00__2017-01-20 23:00:00 5 |2017-01-16__2017-01-20
		// 23:59:59.999 61
		// 2017-03-18
		// 显示为 1.16---1.19 0+1=1--4
		// 1.20---3.18 4+1=5
		// 再开始的时候加1天没问题，显示的时候最后1个阶段最后1天显示包含了考试的那一天所以就多了1天
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

	@Test
	public void test2() {
		copystrTodivision();
	}

	/**
	 * 数据核对,用于数据量条件数量相等的情况,两组数据要使用相同的排序
	 */
	public void dataCheck() {
		// TODO 数据核对,用于数据量条件数量相等的情况,两组数据要使用相同的排序
		String str1 = "";
		String replaceAll[] = str1.split("\\r\\n");
		String fenge = "";
		String str2 = "";
		String strarray[] = str2.split("\\r\\n");
//		System.out.println(replaceAll[0]);
		int number = 0;
		if (strarray.length > replaceAll.length) {
			number = strarray.length;
		} else {
			number = replaceAll.length;
		}
		for (int i = 0; i < number; i++) {
			if (!strarray[i].equals(replaceAll[i])) {
				System.out.println(i + "|" + replaceAll[i] + "|" + strarray[i]);
			}
		}

	}

	public void dataifCheck() {
		// TODO 条件核对用户条件或数据量不同的情况，找出不同的条件
		String str1 = "";
		String ss = "";
		String str2 = "";
		str1 = str1.replaceAll("(	| )", "_").replaceAll("-", "");
		str2 = str2.replaceAll("(	| )", "_").replaceAll("-", "");
		String[] split = str1.split("\\r\\n");
		String[] split2 = str2.split("\\r\\n");
		for (int i = 0; i < split2.length; i++) {
			if (str1.indexOf(split2[i]) < 0) {
				System.out.println("str1不包含" + i + "|" + split2[i]);
			}
		}
		for (int i = 0; i < split.length; i++) {
			if (str2.indexOf(split[i]) < 0) {
				System.out.println("str2不包含" + i + "|" + split[i]);
			}
		}

	}

//	@Test
	public void addding() {
		String str = "360bidding,sogoubidding,baidubidding,shenmabidding,360info,bzbidding,oppobidding,ucbidding,vivoinfo,wifibidding,wpsinfo,jdlkbidding,jrttbidding,youkubidding,fhbidding,huaweiinfo,xhsbidding,gdtbidding,weilibidding,ksbidding,douyinbidding,pinduoduo,fuyibidding,zlzpbidding,iqybidding,baiduinfo,zhihubidding,infoflow_shenma,fstbidding,wymusic,mybidding,txmpbidding,qttbidding,androidapp,iosapp,h5bidding,jdshop,searchengines,crmadd,other,tgregister,ttapp,xiaoetong,weixinapp,jdkbidding,textbook,baiduapp,directvisit,infosite,referral,crm";
		String[] split = str.split(",");
		String lll = "";
		for (int i = 0; i < split.length; i++) {
			lll += "'" + split[i] + "',";
		}
		System.out.println(lll);
	}

	public void jsondateValidation() {
		// 找出两组json数据中不同的数据
		Map<String, String> map1 = new HashMap<>();
		JSONArray jsonArray1 = JSONArray.parseArray(
				"[{\"Id\":\"913929\"},{\"Id\":\"1283250\"},{\"Id\":\"1283251\"},{\"Id\":\"1283252\"},{\"Id\":\"1283253\"},{\"Id\":\"1351158\"},{\"Id\":\"1351170\"},{\"Id\":\"1351188\"},{\"Id\":\"1351189\"},{\"Id\":\"1351190\"},{\"Id\":\"1351191\"},{\"Id\":\"1351192\"},{\"Id\":\"1351201\"},{\"Id\":\"1351203\"},{\"Id\":\"1504173\"},{\"Id\":\"1609235\"},{\"Id\":\"1609383\"},{\"Id\":\"1609384\"},{\"Id\":\"1609385\"},{\"Id\":\"1609386\"},{\"Id\":\"1609387\"},{\"Id\":\"1609388\"},{\"Id\":\"1609390\"},{\"Id\":\"1609391\"},{\"Id\":\"1609400\"},{\"Id\":\"1609402\"},{\"Id\":\"1609403\"},{\"Id\":\"1609404\"},{\"Id\":\"1609405\"},{\"Id\":\"1609406\"},{\"Id\":\"1610747\"},{\"Id\":\"1610749\"},{\"Id\":\"1610758\"},{\"Id\":\"1610760\"},{\"Id\":\"1614839\"},{\"Id\":\"913954\"},{\"Id\":\"1161806\"},{\"Id\":\"1283222\"},{\"Id\":\"1283245\"},{\"Id\":\"1283248\"},{\"Id\":\"1283249\"},{\"Id\":\"1283257\"},{\"Id\":\"1351193\"},{\"Id\":\"1609229\"},{\"Id\":\"1609249\"},{\"Id\":\"1609250\"},{\"Id\":\"1609382\"},{\"Id\":\"1609389\"},{\"Id\":\"1609392\"},{\"Id\":\"1609393\"},{\"Id\":\"1609394\"},{\"Id\":\"1609395\"},{\"Id\":\"1609396\"},{\"Id\":\"1609397\"},{\"Id\":\"1609398\"},{\"Id\":\"1609399\"},{\"Id\":\"1609401\"},{\"Id\":\"1609407\"},{\"Id\":\"1609408\"},{\"Id\":\"1609409\"},{\"Id\":\"1609410\"},{\"Id\":\"1609411\"},{\"Id\":\"1609412\"},{\"Id\":\"1609413\"},{\"Id\":\"1609414\"},{\"Id\":\"1610821\"},{\"Id\":\"1610823\"},{\"Id\":\"1610825\"},{\"Id\":\"1610828\"},{\"Id\":\"1614844\"},{\"Id\":\"1610275\"},{\"Id\":\"1610276\"},{\"Id\":\"1610277\"},{\"Id\":\"1610278\"},{\"Id\":\"1610279\"},{\"Id\":\"1610280\"},{\"Id\":\"1614449\"},{\"Id\":\"1614450\"},{\"Id\":\"1614451\"},{\"Id\":\"1614452\"},{\"Id\":\"1614453\"},{\"Id\":\"1614454\"},{\"Id\":\"1614455\"},{\"Id\":\"1614456\"},{\"Id\":\"1614457\"},{\"Id\":\"1614458\"},{\"Id\":\"1614459\"},{\"Id\":\"1614840\"},{\"Id\":\"1614841\"},{\"Id\":\"1614842\"},{\"Id\":\"1614843\"},{\"Id\":\"1620905\"},{\"Id\":\"1620906\"},{\"Id\":\"1620907\"},{\"Id\":\"1620908\"},{\"Id\":\"1620909\"}]");
		for (int i = 0; i < jsonArray1.size(); i++) {
			map1.put(jsonArray1.getJSONObject(i).getString("Id"), i + "");
		}
		JSONArray jsonArray2 = JSONArray.parseArray(
				"[{\"qid\":\"913929\"},{\"qid\":\"1283248\"},{\"qid\":\"1609386\"},{\"qid\":\"1609408\"},{\"qid\":\"913954\"},{\"qid\":\"1161806\"},{\"qid\":\"1351170\"},{\"qid\":\"1351191\"},{\"qid\":\"1351192\"},{\"qid\":\"1504173\"},{\"qid\":\"1609387\"},{\"qid\":\"1609393\"},{\"qid\":\"1609397\"},{\"qid\":\"1609388\"},{\"qid\":\"1609414\"},{\"qid\":\"1283257\"},{\"qid\":\"1351188\"},{\"qid\":\"1609412\"},{\"qid\":\"1283250\"},{\"qid\":\"1283253\"},{\"qid\":\"1351158\"},{\"qid\":\"1351189\"},{\"qid\":\"1351190\"},{\"qid\":\"1609383\"},{\"qid\":\"1609384\"},{\"qid\":\"1609385\"},{\"qid\":\"1609390\"},{\"qid\":\"1609394\"},{\"qid\":\"1609395\"},{\"qid\":\"1609396\"},{\"qid\":\"1609398\"},{\"qid\":\"1609405\"},{\"qid\":\"1609409\"},{\"qid\":\"1610747\"},{\"qid\":\"1610749\"},{\"qid\":\"1610758\"},{\"qid\":\"1610760\"},{\"qid\":\"1610821\"},{\"qid\":\"1614839\"},{\"qid\":\"1614844\"},{\"qid\":\"1351193\"},{\"qid\":\"1609382\"},{\"qid\":\"1283252\"},{\"qid\":\"1351201\"},{\"qid\":\"1351203\"},{\"qid\":\"1283245\"},{\"qid\":\"1283222\"},{\"qid\":\"1609250\"},{\"qid\":\"1609410\"},{\"qid\":\"1609389\"},{\"qid\":\"1610828\"},{\"qid\":\"1283249\"},{\"qid\":\"1283251\"},{\"qid\":\"1609229\"},{\"qid\":\"1609235\"},{\"qid\":\"1609249\"},{\"qid\":\"1609391\"},{\"qid\":\"1609392\"},{\"qid\":\"1609399\"},{\"qid\":\"1609400\"},{\"qid\":\"1609401\"},{\"qid\":\"1609402\"},{\"qid\":\"1609403\"},{\"qid\":\"1609404\"},{\"qid\":\"1609407\"},{\"qid\":\"1609411\"},{\"qid\":\"1609413\"},{\"qid\":\"1610823\"},{\"qid\":\"1610825\"}]");
		int n1 = 0;
		for (int i = 0; i < jsonArray2.size(); i++) {
			if (map1.containsKey(jsonArray2.getJSONObject(i).getString("qid"))) {
				n1++;
			}
		}
		System.out.println("组1的数量:" + jsonArray1.size());
		System.out.println("组2的数量:" + jsonArray2.size());
		System.out.println("组2在组1中存在的数量:" + n1);
	}

	public void copystrTodivision() {
		String str1 = "";
		System.out.println(str1.split("\\r\\n").length);
		System.out.println(str1.replaceAll("\\r\\n",","));
	}

}
