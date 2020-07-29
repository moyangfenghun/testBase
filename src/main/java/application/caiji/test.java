package application.caiji;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.sql.RowSet;

import com.alibaba.fastjson.JSONObject;

import application.caiji.unitls.JsonConversionUtils;
import application.caiji.unitls.mySqlHelper_local_pool;
import javaBase.date.dateUtils;

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
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setLenient(false);
		String strpt="2017-01-1";
		simpleDateFormat.parse(strpt);
		String replaceAll = strpt.substring(0,10).replaceAll("-", "");
		System.out.println(replaceAll.length());
		System.out.println(Integer.parseInt(replaceAll));
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
}
