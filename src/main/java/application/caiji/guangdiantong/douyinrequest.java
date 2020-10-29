package application.caiji.guangdiantong;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import newcontent.http.HttpClientUtil;

public class douyinrequest {
	// 参数和对应的表名
	public final List<String[]> tablemap2 = new ArrayList<>();
	{
		String str1[] = { "40", "STAT_GROUP_BY_PRICING", "douyin_adplan_time_id_pricing", "pricing",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str2[] = { "41", "STAT_GROUP_BY_IMAGE_MODE", "douyin_adplan_time_id_imagemodel", "image_mode",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str3[] = { "42", "STAT_GROUP_BY_INVENTORY", "douyin_adplan_time_id_inventory", "inventory",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str4[] = { "43", "STAT_GROUP_BY_APP_CODE", "douyin_adplan_time_id_appcode", "app_code",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str5[] = { "44", "STAT_GROUP_BY_CAMPAIGN_TYPE", "douyin_adplan_time_id_campaigntype", "campaign_type",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str6[] = { "45", "STAT_GROUP_BY_CREATIVE_MATERIAL_MODE", "douyin_adplan_time_id_materialmode",
				"material_mode", "STAT_TIME_GRANULARITY_HOURLY" };
		String str7[] = { "46", "STAT_GROUP_BY_EXTERNAL_ACTION", "douyin_adplan_time_id_externalaction",
				"external_action", "STAT_TIME_GRANULARITY_HOURLY" };
		String str8[] = { "47", "STAT_GROUP_BY_LANDING_TYPE", "douyin_adplan_time_id_landingtype", "landing_type",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str9[] = { "48", "STAT_GROUP_BY_PRICING_CATEGORY", "douyin_adplan_time_id_pricingcategory",
				"pricing_category", "STAT_TIME_GRANULARITY_HOURLY" };
		String str10[] = { "49", "STAT_GROUP_BY_PROVINCE_NAME", "douyin_adplan_time_id_provincename", "province_name",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str11[] = { "50", "STAT_GROUP_BY_CITY_NAME", "douyin_adplan_time_id_cityname", "city_name",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str12[] = { "51", "STAT_GROUP_BY_GENDER", "douyin_adplan_time_id_gender", "gender",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str13[] = { "52", "STAT_GROUP_BY_AGE", "douyin_adplan_time_id_age", "age",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str14[] = { "53", "STAT_GROUP_BY_PLATFORM", "douyin_adplan_time_id_platform", "platform",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str15[] = { "54", "STAT_GROUP_BY_AC", "douyin_adplan_time_id_ac", "ac", "STAT_TIME_GRANULARITY_DAILY" };
		String str16[] = { "55", "STAT_GROUP_BY_AD_TAG", "douyin_adplan_time_id_adtag", "ad_tag",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str17[] = { "56", "STAT_GROUP_BY_INTEREST_TAG", "douyin_adplan_time_id_interesttag", "interest_tag",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str18[] = { "57", "", "douyin_adplan_time_id_daily", "", "STAT_TIME_GRANULARITY_DAILY" };
		String str19[] = { "58", "", "douyin_adplan_time_id_hourly", "", "STAT_TIME_GRANULARITY_HOURLY" };
		String str20[] = { "59", "STAT_GROUP_BY_INVENTORY", "douyin_adplan_time_id_inventory_daily", "inventory",
				"STAT_TIME_GRANULARITY_DAILY" };

		tablemap2.add(str20);
		tablemap2.add(str1);
		tablemap2.add(str2);
		tablemap2.add(str3);
//			tablemap2.add(str4);
//			tablemap2.add(str5);
		tablemap2.add(str6);
//			tablemap2.add(str7);
		tablemap2.add(str8);
//			tablemap2.add(str9);
		tablemap2.add(str10);
		tablemap2.add(str11);
		tablemap2.add(str12);
		tablemap2.add(str13);
		tablemap2.add(str14);
		tablemap2.add(str15);
		tablemap2.add(str16);
//			tablemap2.add(str17);
		tablemap2.add(str18);
		tablemap2.add(str19);
	}
	/* 参数和对应的表名
	 * 目前一共3种错误情况
	 * 1.该参数无效了
	 * 2.该参数系统错误
	 * 3.该参数针对某些账号超时
	*/
	public final List<String[]> tablemap1 = new ArrayList<>();
	{
		String str1[] = { "22", "STAT_GROUP_BY_PRICING", "douyin_adgroups_time_id_pricing", "pricing",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str2[] = { "23", "STAT_GROUP_BY_IMAGE_MODE", "douyin_adgroups_time_id_imagemodel", "image_mode",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str3[] = { "24", "STAT_GROUP_BY_INVENTORY", "douyin_adgroups_time_id_inventory", "inventory",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str4[] = { "25", "STAT_GROUP_BY_APP_CODE", "douyin_adgroups_time_id_appcode", "app_code",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str5[] = { "26", "STAT_GROUP_BY_CAMPAIGN_TYPE", "douyin_adgroups_time_id_campaigntype", "campaign_type",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str6[] = { "27", "STAT_GROUP_BY_CREATIVE_MATERIAL_MODE", "douyin_adgroups_time_id_materialmode",
				"material_mode", "STAT_TIME_GRANULARITY_HOURLY" };
		String str7[] = { "28", "STAT_GROUP_BY_EXTERNAL_ACTION", "douyin_adgroups_time_id_externalaction",
				"external_action", "STAT_TIME_GRANULARITY_HOURLY" };
		String str8[] = { "29", "STAT_GROUP_BY_LANDING_TYPE", "douyin_adgroups_time_id_landingtype", "landing_type",
				"STAT_TIME_GRANULARITY_HOURLY" };
		String str9[] = { "30", "STAT_GROUP_BY_PRICING_CATEGORY", "douyin_adgroups_time_id_pricingcategory",
				"pricing_category", "STAT_TIME_GRANULARITY_HOURLY" };
		String str10[] = { "31", "STAT_GROUP_BY_PROVINCE_NAME", "douyin_adgroups_time_id_provincename", "province_name",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str11[] = { "32", "STAT_GROUP_BY_CITY_NAME", "douyin_adgroups_time_id_cityname", "city_name",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str12[] = { "33", "STAT_GROUP_BY_GENDER", "douyin_adgroups_time_id_gender", "gender",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str13[] = { "34", "STAT_GROUP_BY_AGE", "douyin_adgroups_time_id_age", "age",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str14[] = { "35", "STAT_GROUP_BY_PLATFORM", "douyin_adgroups_time_id_platform", "platform",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str15[] = { "36", "STAT_GROUP_BY_AC", "douyin_adgroups_time_id_ac", "ac",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str16[] = { "37", "STAT_GROUP_BY_AD_TAG", "douyin_adgroups_time_id_adtag", "ad_tag",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str17[] = { "38", "STAT_GROUP_BY_INTEREST_TAG", "douyin_adgroups_time_id_interesttag", "interest_tag",
				"STAT_TIME_GRANULARITY_DAILY" };
		String str18[] = { "20", "", "douyin_adgroup_time_id_daily", "", "STAT_TIME_GRANULARITY_DAILY" };
		String str19[] = { "21", "", "douyin_adgroup_time_id_hourly", "", "STAT_TIME_GRANULARITY_HOURLY" };
		String str20[] = { "39", "STAT_GROUP_BY_INVENTORY", "douyin_adgroups_time_id_inventory_daily", "inventory",
				"STAT_TIME_GRANULARITY_DAILY" };
		tablemap1.add(str20);
		tablemap1.add(str1);
		tablemap1.add(str2);
		tablemap1.add(str3);
		//平台不支持这个维度了
//		tablemap1.add(str4);
		//系统错误
//		tablemap1.add(str5);
		tablemap1.add(str6);
		//系统错误
//		tablemap1.add(str7);
		tablemap1.add(str8);
		//系统错误
//		tablemap1.add(str9);
		tablemap1.add(str10);
		tablemap1.add(str11);
		tablemap1.add(str12);
		tablemap1.add(str13);
		tablemap1.add(str14);
		tablemap1.add(str15);
		tablemap1.add(str16);
		//平台不支持这个维度了
//		tablemap1.add(str17);
		tablemap1.add(str18);
		tablemap1.add(str19);
	}
	public static void main(String[] args) throws InterruptedException {
		douyinrequest douyin = new douyinrequest();
		douyin.geteveryday();
	}
	/*
	 * * 24 时段,32 城市, 39 天, 59 计划
	 * 172-883629260277020-bb04ae315fcc94fcf8b57f87ae3d55ee2f69695e
	 * 51-108950679456-119dd8fecc52c7696f8048f80fe7393f4dbbbd5c
	 * https://ad.oceanengine.com/open_api/2/report/campaign/get/ 广告组
	 * https://ad.oceanengine.com/open_api/2/report/ad/get/ 广告计划
	 */
	public void geteveryday() throws InterruptedException {
		Map<String, String> filtering = new HashMap<String, String>();
		//AD_STATUS_ALL,CAMPAIGN_STATUS_ALL
		filtering.put("status", "AD_STATUS_ALL");
		
		String[] par = { "STAT_GROUP_BY_FIELD_ID", "STAT_GROUP_BY_FIELD_STAT_TIME"};
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page_size", "1000");
		data.put("advertiser_id", "105354762775");
		data.put("start_date", "2020-08-01");
		data.put("end_date", "2020-08-31");
		// STAT_TIME_GRANULARITY_HOURLY,STAT_TIME_GRANULARITY_DAILY
		data.put("time_granularity", "STAT_TIME_GRANULARITY_DAILY");
		data.put("group_by", par);
		data.put("page", "1");
		data.put("filtering", filtering);
		String token = "ea7f4d4236534b6f5208bea27f148570c9260556";
		String url = "https://ad.oceanengine.com/open_api/2/report/ad/get/";
		int pageNumber=1,page=1;
		BigDecimal all=new BigDecimal("0");
		for (int i = 0; i < pageNumber; i++) {
			data.put("page", page+i);
			JSONObject campaignStat = HttpClientUtil.getAdvertiserStat(data, token, url);
			if (campaignStat!=null&&campaignStat.getString("code")!=null&&campaignStat.getString("code").equals("0")) {
				JSONObject Jsondata = campaignStat.getJSONObject("data");
				JSONObject page_info = Jsondata.getJSONObject("page_info");
				JSONArray jsonArray = Jsondata.getJSONArray("list");
				System.out.println("page_info:"+page_info);
				pageNumber=page_info.getInteger("total_page");
				for (int i2 = 0; i2 < jsonArray.size(); i2++) {
					JSONObject object = jsonArray.getJSONObject(i2);
//					System.out.println(object);
					all=all.add(object.getBigDecimal("cost"));
				}
			}else {
				System.out.println("|"+campaignStat);
				Thread.sleep(29000);
				i--;
			}
			Thread.sleep(3000);
			System.out.println("当前页数"+(page+i));
		}
		System.out.println("all:"+all);
	}
	
}
