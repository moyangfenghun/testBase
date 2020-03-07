package application.caiji.guangdiantong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class request {
	
	public static void main(String[] args) throws Exception {
		request request=new request();
		request.getDingxiang();
	}
	public void getcampaign() throws Exception{
		String url = "https://api.e.qq.com/v1.1/campaigns/get";
		long time=new Date().getTime();
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
		String sendGet =request.sendGet(url, map);
		System.out.println(sendGet);
		JSONObject json=JSONObject.parseObject(sendGet);
		JSONObject date = json.getJSONObject("data");
		JSONArray jsonArray = date.getJSONArray("list");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			System.out.println(obj);
		}
	}
	public void getDingxiang() throws Exception{
		String url = "https://api.e.qq.com/v1.1/targeting_tag_reports/get";
		long time=new Date().getTime();
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
		String sendGet =request.sendGet(url, map);
		System.out.println(sendGet);
		JSONObject json=JSONObject.parseObject(sendGet);
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
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 map 的形式。
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
			name=k;
			value=v;
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
