package application.caiji;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import application.caiji.dao.dal_sql;
import newcontent.http.HttpClientUtil;

public class maintest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始...");
		String yuming1="http://localhost:8080/datacollect/";
		String yuming2="http://datacollect.cnbkw.com:8088/";
		String yufaing="http://test.datacollect.cnbkw.com:8083/";
		String yufa="http://yufa.datacollect.cnbkw.com:8083/";
		dal_sql dal_sql=new dal_sql();
		//推广
		//88,20190128
		//87,20180225
		//86,20170101
//		String updatesql1="update tuiguang_temporary set pt='20200101', pagesize=0,pagenum=-1 where id=85;";
		String updatesql2="update tuiguang_temporary set pt='20170101', pagesize=0,pagenum=-1 where id=86;";
		String updatesql3="update tuiguang_temporary set pt='20200310', pagesize=0,pagenum=-1 where id=87;";
		String updatesql4="update tuiguang_temporary set pt='20200320', pagesize=0,pagenum=-1 where id=88;";
		String sql_old="SELECT pt,masterid,extensionsourceid,clienttype,SUM(register_number),SUM(discount_promotion_money),SUM(new_sittingwater),SUM(new_yeji_month) FROM extension_pt_promotion_analysis t1 LEFT JOIN"
				+ " extension_source t2  on t1.extensionsourceid=t2.id"
				+ " WHERE t1.extensionsourceid <100000 and t1.pt>=20200301 and t1.pt<=20200331 -- GROUP BY masterid ORDER BY masterid -- and t1.masterid=1209  --  and t2.ispaytype=1 ";
		String sql2_new="SELECT pt,masterid,extensionsourceid,clienttype,SUM(register_number_cache),SUM(discount_promotion_money_cache),SUM(new_sittingwater_cache),SUM(new_yeji_cache) FROM extension_pt_promotion_analysis t1 LEFT JOIN"
				+ " extension_source t2  on t1.extensionsourceid=t2.id"
				+ " WHERE t1.extensionsourceid <100000 and t1.pt>=20200331 and t1.pt<=20200331  --  and  t1.masterid=1209 --  and t2.ispaytype=1 ";
		String order="select ifnull(sum(realprice),0) as 流水,count(distinct orderid) as 流水订单数 From `user_orderinfo` where realprice>0 and state=1  and ordertype not in ('buymembers','signgoods') and addtime between '2020-03-01 00:00:00' and '2020-03-31 23:59:59.99' and masterid=1209 ";
		String appsql="SELECT masterid,extensionsourceid,SUM(reg_user_number) as 注册量,SUM(vip_sittingwater) as 流水,SUM(paymoney) as 花费 FROM app_promotion WHERE pt>=20200301 and pt<=20200331 and ptflag=1   and masterid<>0 -- and extensionsourceid=9  GROUP BY masterid";
		//100000,|app 8:13800.00,app 9:234455.70
		String updateflagapp="UPDATE app_promotion set ptflag=0 WHERE  pt<20200301";
		String updateflaghuafei="UPDATE temp_pt_extension_project_clienttype set flag=0 WHERE reg_pt<20200301;";
		String updateflagorder="UPDATE user_orderinfo set ptflagfree=1 WHERE addtime<'2020-03-01';";

		String countappflag="select count(*) from app_promotion  WHERE pt>=20200301 and pt<=20200331 and ptflag=0";
		String countorderflag="select count(*) from user_orderinfo  WHERE addtime>='2020-03-01' and addtime<'2020-04-01' and ptflagfree=1";

		String clearData="update extension_pt_promotion_analysis  set discount_promotion_money=0,new_sittingwater=0, new_yeji_month=0"
				+ ",discount_promotion_money_cache=0, new_sittingwater_cache=0, new_yeji_cache=0 where pt>=20200301";
//		String select="select * from new_askanswer_temp ";
		Map<String,String> map =new HashMap<String, String>();
		map.put("string", "tonxing_:"+updateflagapp);
		//select,update
		String type="select";
		map.put("type", type);
//		map.put("size", "100");
		//bkw_question_article,bkw_data
		//thuiguang,orderanalysis,bkw_studypaper,appthuiguang
		//oaandcrm,examsys
		//yitiku,weixinfenxiang,mysql
		map.put("source", "appthuiguang");
		String results = HttpClientUtil.doPost(yufa+"tuiGuangPromotionDataDouyin/stringis/longandlong", map);
		System.out.println(results);
		String ids="";
		if("select".equals(type)){
			JSONArray parseArray = JSONArray.parseArray(results);
			System.out.println("数量:"+parseArray.size());
			for (int i = 0; i < parseArray.size(); i++) {
				JSONObject jsonObject = parseArray.getJSONObject(i);
				System.out.println(jsonObject);
//				ids+="\""+jsonObject.getString("id")+"\",";
			}
//			System.out.println(ids.substring(0, ids.length()-1));
		}else{
			System.out.println(results);
		}
	}
	
	/*
	 * 清除数据接口
	 */
//	@Test
	public void test(){
		//guangdiantonganalysis,promotionExptdouyin
		//ptpromotionanalysis/clearyesterday
		String yuming="http://datacollect.cnbkw.com:8088/";
		String yuming2="http://localhost:8080/datacollect/";
		Map<String,String> map =new HashMap<String, String>();
		map.put("beginDate", "20200227");
		map.put("endDate", "20200304");
//		map.put("exId", "144");
		//extension_pt_promotion_analysis_copy,
		//promotion_campaign_group_analysis_copy,
		//extension_pt_timeinterval_analysis
		map.put("tableName", "extension_pt_promotion_analysis_copy");
		
//		设置生成文章
//		map.put("id", "1");
//		map.put("nextdate", "2020-01-09");
		//generateArticle/setArticleplan
//		String results = HttpClientUtil.doPost(yuming+"guangdiantonganalysis/ptpromotionanalysis/clearyesterday", map);
//		System.out.println(results);
		
	}
	
//	@Test
	public void test2(){
		String yuming="http://datacollect.cnbkw.com:8088/";
		String yuming2="http://localhost:8080/datacollect/";
		Map<String,String> map =new HashMap<String, String>();
		//注册量
//		map.put("restExid", "39");
//		map.put("clienttype", "2");
//		map.put("resetMasterid", "1209");
//		map.put("useridstr", "");
		String results = HttpClientUtil.doPost(yuming+"tuiguangnew/promotioncampaigngroupanalysisreg", map);
		System.out.println(results);
//		int datetime=20190830;
//		int s=datetime;
//		for (int i = 0; i <(20190832-s); i++) {
//			System.out.println(datetime);
//			if(datetime<=20190831){
//				map.put("pt",datetime+"");
//				
//				datetime++;
//			}
//		}
		
		
	}
}
