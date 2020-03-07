package application.caiji.guangdiantong;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import newcontent.http.HttpClientUtil;

public class douyinrequest {

	/*
	 * 24 时段
	 * 32 城市
	 * 39 天
	 * 59 计划
	 * 新科教育-19 172 883629260277020  bb04ae315fcc94fcf8b57f87ae3d55ee2f69695e
	 */
	public static void main(String[] args) {
		douyinrequest douyin=new douyinrequest();
		douyin.geteveryday();
	}
	
	public void geteveryday(){
		Map<String, String> filtering = new HashMap<String, String>();
		filtering.put("status", "CAMPAIGN_STATUS_ALL");
		
		String[] par= { "STAT_GROUP_BY_FIELD_ID", "STAT_GROUP_BY_FIELD_STAT_TIME","STAT_GROUP_BY_EXTERNAL_ACTION"};
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page_size", "1000");
		data.put("advertiser_id", "883629260277020");
		data.put("start_date", "2020-03-03");
		data.put("end_date", "2020-03-03");
		//STAT_TIME_GRANULARITY_HOURLY,STAT_TIME_GRANULARITY_DAILY
		data.put("time_granularity", "STAT_TIME_GRANULARITY_HOURLY");
		data.put("group_by", par);
		data.put("page", "1");
		data.put("filtering", filtering);
		String token="bb04ae315fcc94fcf8b57f87ae3d55ee2f69695e";
		String url="https://ad.toutiao.com/open_api/2/report/campaign/get/";
		JSONObject campaignStat = HttpClientUtil.getAdvertiserStat(data, token,url);
//		System.out.println("|"+campaignStat);
		if(campaignStat.getString("code").equals("0")){
			JSONObject Jsondata = campaignStat.getJSONObject("data");
			JSONObject jsonObject = Jsondata.getJSONObject("page_info");
			JSONArray jsonArray = Jsondata.getJSONArray("list");
			System.out.println(jsonObject);
//			for (int i = 0; i < jsonArray.size(); i++) {
//				JSONObject object = jsonArray.getJSONObject(i);
//				System.out.println(object);
//			}
		}
	}

}
