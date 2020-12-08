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
		String str1 = "3791990\r\n" + "3795089\r\n" + "3798786\r\n" + "3787997\r\n" + "3789829\r\n" + "3788922\r\n"
				+ "3798781\r\n" + "3795069\r\n" + "3800604\r\n" + "3800840\r\n" + "3785845\r\n" + "3801197\r\n"
				+ "3800866\r\n" + "3797938\r\n" + "3799588\r\n" + "3800792\r\n" + "3789666\r\n" + "3788898\r\n"
				+ "3799832\r\n" + "3800848\r\n" + "3789679\r\n" + "3800877\r\n" + "3793019\r\n" + "3792800\r\n"
				+ "3799756\r\n" + "3797989\r\n" + "3799777\r\n" + "3791667\r\n" + "3800841\r\n" + "3800833\r\n"
				+ "3791691\r\n" + "3785789\r\n" + "3789850\r\n" + "3789900\r\n" + "3799659\r\n" + "3800845\r\n"
				+ "3791668\r\n" + "3794528\r\n" + "3793003\r\n" + "3790604\r\n" + "3796364\r\n" + "3800838\r\n"
				+ "3788072\r\n" + "3789860\r\n" + "3794470\r\n" + "3801149\r\n" + "3791664\r\n" + "3789839\r\n"
				+ "3801153\r\n" + "3801004\r\n" + "3798722\r\n" + "3789676\r\n" + "3791989\r\n" + "3794719\r\n"
				+ "3795274\r\n" + "3800772\r\n" + "3800657\r\n" + "3795072\r\n" + "3789894\r\n" + "3791864\r\n"
				+ "3794578\r\n" + "3798749\r\n" + "3795030\r\n" + "3798772\r\n" + "3789776\r\n" + "3794322\r\n"
				+ "3789898\r\n" + "3794744\r\n" + "3791666\r\n" + "3785844\r\n" + "3794694\r\n" + "3799828\r\n"
				+ "3791665\r\n" + "3791642\r\n" + "3798605\r\n" + "3789956\r\n" + "3795226\r\n" + "3797988\r\n"
				+ "3800621\r\n" + "3789897\r\n" + "3794689\r\n" + "3790708\r\n" + "3790744\r\n" + "3800864\r\n"
				+ "3797418\r\n" + "3798126\r\n" + "3791933\r\n" + "3791646\r\n" + "3791059\r\n" + "3799768\r\n"
				+ "3794688\r\n" + "3791839\r\n" + "3800849\r\n" + "3791060\r\n" + "3788070\r\n" + "3798611\r\n"
				+ "3795297\r\n" + "3791987\r\n" + "3791866\r\n" + "3788972\r\n" + "3800822\r\n" + "3791838\r\n"
				+ "3791685\r\n" + "3788080\r\n" + "3794748\r\n" + "3791647\r\n" + "3788108\r\n" + "3794386\r\n"
				+ "3798596\r\n" + "3798606\r\n" + "3792997\r\n" + "3800686\r\n" + "3789992\r\n" + "3791934\r\n"
				+ "3794745\r\n" + "3791648\r\n" + "3793002\r\n" + "3788827\r\n" + "3798613\r\n" + "3789826\r\n"
				+ "3793010\r\n" + "3798779\r\n" + "3800874\r\n" + "3789844\r\n" + "3799834\r\n" + "3789838\r\n"
				+ "3791938\r\n" + "3786015\r\n" + "3785519\r\n" + "3791849\r\n" + "3789843\r\n" + "3797433\r\n"
				+ "3798729\r\n" + "3789764\r\n" + "3800734\r\n" + "3800868\r\n" + "3795187\r\n" + "3799528\r\n"
				+ "3791650\r\n" + "3799971\r\n" + "3791837\r\n" + "3789951\r\n" + "3799660\r\n" + "3798725\r\n"
				+ "3789469\r\n" + "3789662\r\n" + "3799794\r\n" + "3796335\r\n" + "3800880\r\n" + "3799780\r\n"
				+ "3800761\r\n" + "3790586\r\n" + "3797909\r\n" + "3791640\r\n" + "3800800\r\n" + "3789955\r\n"
				+ "3799976\r\n" + "3794623\r\n" + "3800835\r\n" + "3794687\r\n" + "3800836\r\n" + "3797984\r\n"
				+ "3799969\r\n" + "3789768\r\n" + "3800791\r\n" + "3789835\r\n" + "3794823\r\n" + "3794341\r\n"
				+ "3797836\r\n" + "3789952\r\n" + "3799841\r\n" + "3791992\r\n" + "3800860\r\n" + "3798020\r\n"
				+ "3792998\r\n" + "3799591\r\n" + "3801052\r\n" + "3791686\r\n" + "3798604\r\n" + "3794746\r\n"
				+ "3796404\r\n" + "3800574\r\n" + "3794743\r\n" + "3801246\r\n" + "3794699\r\n" + "3789831\r\n"
				+ "3795298\r\n" + "3794337\r\n" + "3798595\r\n" + "3798744\r\n" + "3800760\r\n" + "3800824\r\n"
				+ "3795177\r\n" + "3799827\r\n" + "3799778\r\n" + "3794707\r\n" + "3799521\r\n" + "3791669\r\n"
				+ "3797878\r\n" + "3799831\r\n" + "3789111\r\n" + "3798691\r\n" + "3794839\r\n" + "3788841\r\n"
				+ "3789902\r\n" + "3794720\r\n" + "3789833\r\n" + "3791688\r\n" + "3789489\r\n" + "3797833\r\n"
				+ "3794321\r\n" + "3800817\r\n" + "3800804\r\n" + "3791639\r\n" + "3791653\r\n" + "3798784\r\n"
				+ "3793107\r\n" + "3800602\r\n" + "3800852\r\n" + "3800871\r\n" + "3800823\r\n" + "3794905\r\n"
				+ "3800879\r\n" + "3790602\r\n" + "3791995\r\n" + "3798587\r\n" + "3800870\r\n" + "3800614\r\n"
				+ "3785856\r\n" + "3800851\r\n" + "3799621\r\n" + "3800706\r\n" + "3798885\r\n" + "3791994\r\n"
				+ "3789516\r\n" + "3794717\r\n" + "3789832\r\n" + "3789842\r\n" + "3800685\r\n" + "3791687\r\n"
				+ "3794906\r\n" + "3791993\r\n" + "3798609\r\n" + "3791660\r\n" + "3789827\r\n" + "3800881\r\n"
				+ "3800869\r\n" + "3798095\r\n" + "3785869\r\n" + "3794716\r\n" + "3800767\r\n" + "3797831\r\n"
				+ "3789492\r\n" + "3790607\r\n" + "3800863\r\n" + "3798785\r\n" + "3789766\r\n" + "3789953\r\n"
				+ "3789848\r\n" + "3798618\r\n" + "3794544\r\n" + "3788970\r\n" + "3792999\r\n" + "3794213\r\n"
				+ "3800867\r\n" + "3791066\r\n" + "3794212\r\n" + "3797690\r\n" + "3789825\r\n" + "3786078\r\n"
				+ "3800846\r\n" + "3789508\r\n" + "3786053\r\n" + "3785705\r\n" + "3799789\r\n" + "3791936\r\n"
				+ "3795242\r\n" + "3794631\r\n" + "3800795\r\n" + "3798638\r\n" + "3791661\r\n" + "3800785\r\n"
				+ "3794288\r\n" + "3797411\r\n" + "3798726\r\n" + "3794830\r\n" + "3789854\r\n" + "3800805\r\n"
				+ "3794494\r\n" + "3799894\r\n" + "3795029\r\n" + "3789767\r\n" + "3789840\r\n" + "3791061\r\n"
				+ "3800821\r\n" + "3800642\r\n" + "3789828\r\n" + "3794725\r\n" + "3795103\r\n" + "3800762\r\n"
				+ "3801199\r\n" + "3791076\r\n" + "3799793\r\n" + "3794342\r\n" + "3800796\r\n" + "3801229\r\n"
				+ "3800766\r\n" + "3788138\r\n" + "3785494\r\n" + "3798845\r\n" + "3791935\r\n" + "3798633\r\n"
				+ "3786049\r\n" + "3789667\r\n" + "3791651\r\n" + "3800861\r\n" + "3789954\r\n" + "3798724\r\n"
				+ "3799839\r\n" + "3786102\r\n" + "3798608\r\n" + "3794215\r\n" + "3799755\r\n" + "3792842\r\n"
				+ "3798674\r\n" + "3794501\r\n" + "3793025\r\n" + "3794211\r\n" + "3798619\r\n" + "3800825\r\n"
				+ "3785910\r\n" + "3790584\r\n" + "3789893\r\n" + "3789891\r\n" + "3789109\r\n" + "3785898\r\n"
				+ "3795284\r\n" + "3791692\r\n" + "3789859\r\n" + "3800875\r\n" + "3794697\r\n" + "3796319\r\n"
				+ "3794683\r\n" + "3798871\r\n" + "3797443\r\n" + "3795092\r\n" + "3788081\r\n" + "3797820\r\n"
				+ "3789509\r\n" + "3800606\r\n" + "3800676\r\n" + "3794705\r\n" + "3795141\r\n" + "3799589\r\n"
				+ "3794700\r\n" + "3799874\r\n" + "3800764\r\n" + "3789490\r\n" + "3800794\r\n" + "3800827\r\n"
				+ "3794279\r\n" + "3793018\r\n" + "3794639\r\n" + "3797444\r\n" + "3799826\r\n" + "3791065\r\n"
				+ "3791067\r\n" + "3785572\r\n" + "3791932\r\n" + "3795199\r\n" + "3797834\r\n" + "3787995\r\n"
				+ "3799833\r\n" + "3791649\r\n" + "3800847\r\n" + "3800684\r\n" + "3800810\r\n" + "3790585\r\n"
				+ "3791690\r\n" + "3799893\r\n" + "3798597\r\n" + "3795167\r\n" + "3798692\r\n" + "3794692\r\n"
				+ "3792841\r\n" + "3799599\r\n" + "3793133\r\n" + "3790748\r\n" + "3800793\r\n" + "3794724\r\n"
				+ "3799600\r\n" + "3789476\r\n" + "3794718\r\n" + "3799968\r\n" + "3794624\r\n" + "3794316\r\n"
				+ "3791991\r\n" + "3800862\r\n" + "3798757\r\n" + "3800757\r\n" + "3794210\r\n" + "3790603\r\n"
				+ "3800765\r\n" + "3791641\r\n" + "3800850\r\n" + "3789486\r\n" + "3798843\r\n" + "3789896\r\n"
				+ "3801198\r\n" + "3800819\r\n" + "3795049\r\n" + "3800843\r\n" + "3791638\r\n" + "3799791\r\n"
				+ "3789488\r\n" + "3794681\r\n" + "3796394\r\n" + "3791988\r\n" + "3798727\r\n" + "3794838\r\n"
				+ "3791937\r\n" + "3794343\r\n" + "3798620\r\n" + "3794991\r\n" + "3800814\r\n" + "3799665\r\n"
				+ "3793023\r\n" + "3789899\r\n" + "3799835\r\n" + "3798844\r\n" + "3800629\r\n" + "3791652\r\n"
				+ "3798637\r\n" + "3796407\r\n" + "3800873\r\n" + "3796371\r\n" + "3790588\r\n" + "3792840\r\n"
				+ "3798690\r\n" + "3799830\r\n" + "3800865\r\n" + "3794897\r\n" + "3794682\r\n" + "3790589\r\n"
				+ "3794715\r\n" + "3800809\r\n" + "3791645\r\n" + "3800648\r\n" + "3799731\r\n" + "3792839\r\n"
				+ "3800755\r\n" + "3789849\r\n" + "3789834\r\n" + "3788538\r\n" + "3793001\r\n" + "3791865\r\n"
				+ "3794385\r\n" + "3794747\r\n" + "3794691\r\n" + "3799587\r\n" + "3790587\r\n" + "3794726\r\n"
				+ "3794695\r\n" + "3800754\r\n" + "3799878\r\n" + "3789518\r\n" + "3795074\r\n" + "3785503\r\n"
				+ "3791689\r\n" + "3794512\r\n" + "3791643\r\n" + "3789725\r\n" + "3785917\r\n" + "3794727\r\n"
				+ "3799795\r\n" + "3800735\r\n" + "3798735\r\n" + "";
		String replaceAll[] = str1.split("\\r\\n");
		String outstr = "";
		for (int i = 0; i < replaceAll.length; i++) {
			outstr += replaceAll[i] + ",";
		}
		System.out.println(outstr.substring(0, outstr.length() - 1));
	}

}
