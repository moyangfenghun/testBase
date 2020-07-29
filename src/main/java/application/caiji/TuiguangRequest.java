package application.caiji;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import newcontent.http.HttpClientUtil;

public class TuiguangRequest {
	public static void main(String[] args) {
		TuiguangRequest.requestdouyinGroup();
	}
	/*
	 * 请求抖音广告组
	 * 
	 */
	public static void requestdouyinGroup() {
		String str5[] = { "26", "STAT_GROUP_BY_CAMPAIGN_TYPE", "douyin_adgroups_time_id_campaigntype", "campaign_type",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str8[] = { "29", "STAT_GROUP_BY_LANDING_TYPE", "douyin_adgroups_time_id_landingtype", "landing_type",
		"STAT_TIME_GRANULARITY_HOURLY" };
		//STAT_TIME_GRANULARITY_DAILY,STAT_TIME_GRANULARITY_HOURLY
//		String advertiser_id = "1648078019344392";
//		String access_token = "433769ca69779ed64c02c0e7a350bb83426b1529";
		String advertiser_id="107949730604";
		String access_token = "cab6c0effdbbf54ca038b4c55c107514fcf194ef";
//		String url="https://ad.toutiao.com/open_api/2/report/campaign/get/";
//		String url="https://ad.toutiao.com/open_api/2/report/advertiser/get/";
		String url="https://ad.toutiao.com/open_api/2/report/creative/get/";
		String groupby[]={ "STAT_GROUP_BY_FIELD_ID", "STAT_GROUP_BY_FIELD_STAT_TIME",str8[1]};
		// 过滤,包含已删除
		Map<String, String> filtering = new HashMap<String, String>();
//		filtering.put("status", "CAMPAIGN_STATUS_ALL");
		filtering.put("status","CREATIVE_STATUS_ALL");
		// 请求参数
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page_size", "1000");
		data.put("advertiser_id", advertiser_id);
		data.put("start_date", "2020-07-14");
		data.put("end_date", "2020-07-14");
		data.put("time_granularity", str8[4]);
		data.put("group_by", groupby);
		data.put("filtering", filtering);
		data.put("page", "1");
		JSONObject campaignStat = HttpClientUtil.getAdvertiserStat(data, access_token, url);
		if (campaignStat.getInteger("code") == 0) {
			System.out.println(campaignStat.getJSONObject("data").getJSONObject("page_info"));
		}else {
			System.out.println(campaignStat);
		}
	}
}
