package application.caiji.guangdiantong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class request {
	// 参数和对应的表名
	public final List<String[]> tablemap = new ArrayList<>();
	{
		// index0是表在临时表中的id,index1是请求级别，index2是表名,index3是请求的分组条件
		String str1[] = { "1", "REPORT_LEVEL_AD", "guangdiantong_date_id_ad", "ad_id" };
		String str2[] = { "2", "REPORT_LEVEL_PROMOTED_OBJECT", "guangdiantong_date_id_promoted",
				"promoted_object_id,promoted_object_type" };
		String str3[] = { "3", "REPORT_LEVEL_UNION_POSITION", "guangdiantong_date_id_union_position",
				"union_position_id" };
		String str4[] = { "4", "REPORT_LEVEL_CREATIVE_TEMPLATE", "guangdiantong_date_id_creative", "template_id" };
		String str5[] = { "5", "REPORT_LEVEL_EXPAND_TARGETING_ADGROUP", "guangdiantong_date_expand_targeting_adgroup",
				"adgroup_id" };
		String str6[] = { "6", "REPORT_LEVEL_ADGROUP", "guangdiantong_date_id_group", "adgroup_id" };
		tablemap.add(str6);
		tablemap.add(str1);
		tablemap.add(str2);
		tablemap.add(str4);
		tablemap.add(str5);
		// 改级别目前仅灰度开放
//			tablemap.add(str3);

	}
	// 参数和对应的表名
	public final List<String[]> tablemap2 = new ArrayList<>();
	{
		// index0是表在临时表中的id,index1是请求级别，index2是表名,index3是请求的分组条件
		String str1[] = { "11", "REPORT_LEVEL_AD", "guangdiantong_time_id_ad", "ad_id" };
		String str2[] = { "12", "REPORT_LEVEL_PROMOTED_OBJECT", "guangdiantong_time_id_promoted",
				"promoted_object_id,promoted_object_type" };
		String str3[] = { "13", "REPORT_LEVEL_ADGROUP", "guangdiantong_time_id_group", "adgroup_id" };
		tablemap2.add(str3);
		tablemap2.add(str1);
		tablemap2.add(str2);
	}
	// 参数和对应的表名
	public final List<String[]> tablemap3 = new ArrayList<>();
	{
		// index0是表在临时表中的id,index1是请求级别，index2是表名,index3是请求的分组条件
		String str1[] = { "20", "CAMPAIGN", "guangdiantong_date_id_campaign_gender", "gender", "GENDER",
				"campaign_timeflag_gender" };
		String str2[] = { "21", "CAMPAIGN", "guangdiantong_date_id_campaign_age", "age", "AGE",
				"campaign_timeflag_age" };
		String str3[] = { "22", "CAMPAIGN", "guangdiantong_date_id_campaign_region", "region_id", "REGION",
				"campaign_timeflag_region" };
		String str4[] = { "23", "CAMPAIGN", "guangdiantong_date_id_campaign_city", "city_id", "CITY",
				"campaign_timeflag_city" };
		String str5[] = { "24", "ADGROUP", "guangdiantong_date_id_group_age", "age", "AGE", "group_timeflag_age" };
		String str6[] = { "25", "ADGROUP", "guangdiantong_date_id_group_city", "city_id", "CITY",
				"group_timeflag_city" };
		String str7[] = { "26", "ADGROUP", "guangdiantong_date_id_group_gender", "gender", "GENDER",
				"group_timeflag_gender" };
		String str8[] = { "27", "ADGROUP", "guangdiantong_date_id_group_region", "region_id", "REGION",
				"group_timeflag_region" };

		tablemap3.add(str4);
		tablemap3.add(str1);
		tablemap3.add(str2);
		tablemap3.add(str3);
//			tablemap3.add(str5);
//			tablemap3.add(str6);
//			tablemap3.add(str7);
//			tablemap3.add(str8);
	}

	public static void main(String[] args) throws Exception {
		request request = new request();
		request.getadday();
	}

	/*
	 * 6是天报-组表; 13是时间段-组报表;23是城市-组报表
	 */
	public void getadday() throws Exception {
		//https://api.e.qq.com/v1.1/hourly_reports/get
		//https://api.e.qq.com/v1.1/daily_reports/get
		//https://api.e.qq.com/v1.1/targeting_tag_reports/get
		String url = "https://api.e.qq.com/v1.1/targeting_tag_reports/get";
		long time = new Date().getTime();
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		Map<String, String> map = new HashMap<>();
		map.put("access_token", "2cf341b7addb94623bd6571a7306f833");
		map.put("timestamp", time / 1000 + "");
		map.put("nonce", uuid);
		map.put("account_id", "9729388");
		//[\"date\",\"campaign_id\",\"adgroup_id\",\"cost\"],//city_id
		map.put("fields", "[\"date\",\"city_id\",\"view_count\",\"valid_click_count\",\"ctr\",\"cpc\",\"cost\",\"activated_count\",\"activated_cost\",\"activated_rate\",\"app_add_to_car_count\",\"app_add_to_car_cost\",\"app_key_page_view_count\",\"app_checkout_count\",\"app_checkout_cost\",\"app_checkout_amount\",\"app_register_count\",\"app_register_cost\",\"app_order_count\",\"app_order_cost\",\"comment_cost\",\"comment_count\",\"click_activated_rate\",\"download_count\",\"download_rate\",\"download_cost\",\"follow_count\",\"follow_cost\",\"forward_count\",\"forward_cost\",\"install_count\",\"install_cost\",\"own_page_navigation_count\",\"praise_count\",\"praise_cost\",\"web_key_page_view_count\",\"web_key_page_view_cost\",\"web_checkout_count\",\"web_phone_call_back_count\",\"web_phone_call_direct_cost\",\"web_phone_call_back_cost\",\"web_page_reservation_count\",\"web_page_reservation_cost\",\"web_page_reservation_rate\",\"game_create_role_count\",\"game_authorize_count\",\"game_tutorial_finish_count\",\"intelligent_phone_call_direct_count\",\"external_form_reservation_count\",\"total_reservation_count\",\"page_phone_call_direct_count\"]");
		map.put("page", "1");
		map.put("page_size", "1000");
		//REPORT_LEVEL_ADGROUP,ADVERTISER,CAMPAIGN
		map.put("level", "CAMPAIGN");
		map.put("date_range", "{\"start_date\":\"" + "2020-07-21" + "\",\"end_date\":\"" + "2020-07-21" + "\"}");
		//,\"city_id\",hour,date,
		map.put("group_by", "[\"date\",\"city_id\"]");
		map.put("type", "CITY");
		map.put("filtering",
		//46845989,46407147
		"[{\"field\":\""+"campaign_id"+"\",\"operator\":\"EQUALS\",\"values\":[" + "46845989" + "]}]");
		BigDecimal all=new BigDecimal("0");
		int page=1,number=1;
		for (int i = 0; i < number; i++) {
			map.put("page", (page+i)+"");
			System.out.println(JSONObject.toJSONString(map));
			String sendGet = request.sendGet(url, map);
			if(sendGet!=null) {
				JSONObject json = JSONObject.parseObject(sendGet);
				if("0".equals(json.getString("code"))) {
					JSONObject date = json.getJSONObject("data");
					JSONArray jsonArray = date.getJSONArray("list");
					JSONObject page_info = date.getJSONObject("page_info");
					number=page_info.getInteger("total_page");
					System.out.println(page_info);
					for (int i2 = 0; i2 < jsonArray.size(); i2++) {
						JSONObject obj = jsonArray.getJSONObject(i2);
//						System.out.println(obj);
						all=all.add(obj.getBigDecimal("cost").divide(new BigDecimal("100")));
					}
				}else {
					System.out.println(sendGet);
					i--;
					Thread.sleep(30000);
				}
				System.out.println("当前结果页数:"+(page+i));
			}
		}
		System.out.println("all:"+all);//147.62;147.60
		
	}
	@Test
	public void test() {
		HashMap<String, String> map=new HashMap<>();
		map.put("ss", "s\"ss\"s");
		System.out.println(JSONObject.toJSONString(map));
	}

	/*
	 * 计划
	 */
	public void getcampaign() throws Exception {
		String url = "https://api.e.qq.com/v1.1/campaigns/get";
		long time = new Date().getTime();
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		Map<String, String> map = new HashMap<>();
		map.put("access_token", "837ab4b2a64699f0b0b0bbee2eeb645a");
		map.put("timestamp", time / 1000 + "");
		map.put("nonce", uuid);
		map.put("account_id", "10905654");
		map.put("fields", "[\"campaign_id\",\"campaign_name\",\"created_time\"]");
		map.put("page", "1");
		map.put("page_size", "100");
		String sendGet = request.sendGet(url, map);
		System.out.println(sendGet);
		JSONObject json = JSONObject.parseObject(sendGet);
		JSONObject date = json.getJSONObject("data");
		JSONArray jsonArray = date.getJSONArray("list");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			System.out.println(obj);
		}
	}

	public void getDingxiang() throws Exception {
		String url = "https://api.e.qq.com/v1.1/targeting_tag_reports/get";
		long time = new Date().getTime();
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		Map<String, String> map = new HashMap<>();
		map.put("access_token", "837ab4b2a64699f0b0b0bbee2eeb645a");
		map.put("timestamp", time / 1000 + "");
		map.put("nonce", uuid);
		map.put("account_id", "10905654");
		map.put("type", "CITY");
		map.put("level", "CAMPAIGN");
		map.put("fields", "[\"date\",\"city_id\",\"cost\",\"campaign_id\"]");
		map.put("filtering",
				"[{\"field\":\"campaign_id\",\"operator\":\"IN\",\"values\":[54707977,54708566,55163361,56139598]}]");
//		map.put("filtering",
//					"[{\"field\":\""+columnid+"\",\"operator\":\"EQUALS\",\"values\":[" + columnidvalue + "]}]");
		map.put("date_range", "{\"start_date\":\"2019-03-01\",\"end_date\":\"2019-03-01\"}");
		map.put("group_by", "[\"date\", \"city_id\"]");
		map.put("page", "1");
		map.put("page_size", "10");
		String sendGet = request.sendGet(url, map);
		System.out.println(sendGet);
		JSONObject json = JSONObject.parseObject(sendGet);
		JSONObject date = json.getJSONObject("data");
		JSONArray jsonArray = date.getJSONArray("list");
		System.out.println(date.getString("page_info"));
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			System.out.println(obj);
		}
	}

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url   发送请求的URL
	 * @param param 请求参数，请求参数应该是 map 的形式。
	 * @return URL 所代表远程资源的响应结果
	 * @throws Exception
	 */
	public static String sendGet(String url, Map<String, String> map) throws Exception {
		Set<String> keySet = map.keySet();
		String name = "";
		String value = "";
		String result = "";
		String param = "";
		for (String k : keySet) {
			String v = map.get(k);
			name = k;
			value = v;
			if ("".equals(param)) {
				param = name + "=" + value;
			} else {
				param = param + "&" + name + "=" + value;
			}
		}
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 遍历所有的响应头字段
			// for (String key : maps.keySet()) {
			// System.out.println(key + "--->" + maps.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
			throw e;
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
