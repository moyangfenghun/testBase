package application.caiji;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import newVersionOrInstance.http.HttpClientUtil;
import newVersionOrInstance.http.httprequestUtil;

public class maintest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始...");
		String yuming1="http://localhost:8080/datacollect/";
		String yuming2="http://datacollect.cnbkw.com:8088/";
		
		String updatesql1="update tuiguang_temporary set  pagesize=0,pagenum=0 where id=85;";
		String updatesql2="update tuiguang_temporary set  pagesize=0,pagenum=0 where id=86;";
		String updatesql3="update tuiguang_temporary set  pagesize=0,pagenum=0 where id=87;";
		String updatesql4="update tuiguang_temporary set  pagesize=0,pagenum=0 where id=88;";
		String update=updatesql1+updatesql2+updatesql3+updatesql4;
		String select="select * from tuiguang_temporary where id=85";
		String insert="insert into tuiguang_temporary(id,pt,pagesize,pagenum,remark) values(90,20190701,0,0,'extension_pt_promotion_analysis')";

		String type="update";
		Map<String,String> map =new HashMap<String, String>();
		map.put("string", "tonxing_:"+update);
		map.put("type", type);
		map.put("source", "thuiguang");
		String results = HttpClientUtil.doPost(yuming1+"tuiGuangPromotionDataDouyin/stringis/longandlong", map);
		System.out.println(results);
		if("select".equals(type)){
			JSONArray parseArray = JSONArray.parseArray(results);
			for (int i = 0; i < parseArray.size(); i++) {
				JSONObject jsonObject = parseArray.getJSONObject(i);
				System.out.println(jsonObject);
			}
		}
	}
}
