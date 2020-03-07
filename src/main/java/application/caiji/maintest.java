package application.caiji;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import newcontent.http.HttpClientUtil;
import newcontent.http.httprequestUtil;

public class maintest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始...");
		String yuming1="http://localhost:8080/datacollect/";
		String yuming2="http://datacollect.cnbkw.com:8088/";
		//推广
//		String updatesql1="update tuiguang_temporary set pt='20200101', pagesize=0,pagenum=-1 where id=85;";
//		String updatesql2="update tuiguang_temporary set pt='20170101', pagesize=0,pagenum=-1 where id=86;";
//		String updatesql3="update tuiguang_temporary set pt='20180101', pagesize=0,pagenum=-1 where id=87;";
		String updatesql5="update tuiguang_temporary set pt='20200101', pagesize=0,pagenum=-1 where id=88;";
		//462137
//		String updatesql1="update tuiguang_temporary set pt='0', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=80;";
//		String updatesql2="update tuiguang_temporary set pt='1577037', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=82;";
//		String updatesql3="update tuiguang_temporary set pt='462137', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=83;";
//		String updatesql4="update tuiguang_temporary set pt='1577037', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=84;";
//		String updatesql5="update tuiguang_temporary set pt='5519619', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=92;";
//		String updatesql6="update tuiguang_temporary set pt='7885185', pagesize=0,pagenum=0,remark='时段表注册量-历史' where id=93;";

//		String update="update tuiguang_temporary set pt='9367786' where id=11";
		
//		String insert="insert into tuiguang_temporary(id,pt,pagesize,pagenum,remark) values(92,'4425374',0,0,'采集历史用户数据');";

		//关键词报表
//		String update= "INSERT INTO promotion_register_report(pt,timeinterval,extensionsourceid,masterid,keywordCode,clienttype,paymoney,discount_paymoney)VALUES(20191225,'-1',999,999,'fffkkk',2,100,100) ON DUPLICATE KEY UPDATE paymoney=0,discount_paymoney=0,keywordrepotflag=0";
//		String update2=" UPDATE promotion_register_report set paymoney=0,discount_paymoney=0 WHERE pt=20191225 and timeinterval='-1'  and extensionsourceid=999 and masterid=999 and keywordCode='fffkkk' and clienttype=2";
//		String delete="DELETE FROM promotion_register_report WHERE pt=20191225 and timeinterval='-1'  and extensionsourceid=999 and masterid=999 and keywordCode='fffkkk' and clienttype=2";
//		String updateflag=" UPDATE promotion_register_report set keywordrepotflag=0 WHERE pt>=20191223  ";
		
//		String select1="select COUNT(*) as sum From UserStats with(nolock) where AddTime between '2020-01-03 00:00:00' and '2020-01-03 23:59:59.99' and initialmasterid=1209   and Recommend in "
//				+ "(1,7,12,13,14,15,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,37,38,39,40,41,42,43,44,45,46,47,48,49,51,52,53,54,69,70,71,72,73,74,75,77,78,79,80,83,84,86,87,88,89,90,92,93,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,122,123,124,125,126,127,128,129,130,131,132,134,136,139,140,141,142,144,145,146,147,148,149,150,151,153,154,155,156,157,158,160,161,162,163,164,165,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,183,184,185,186,187,188,189,190,192,193,194,195,196,197,198,199,200,201,203,204,205,206,207,208,209,210,212,213,214,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,235,236,237,238,239,240,241,242,243,245,246,247,248,249,250,251,252,253) -- top ";
		//资讯站
		String udpatetag="update new_askanswer_temp  set tag=390400 where id in (1,2)";
		//865476
//		String select="select count(*) from bkw_Question -- top";
//		
//		String select2="select * from new_askanswer_temp ";
//		String select3="select Extension From UserStats with(nolock) where usr_id=9255945 -- top";
//		String selectarticletemp= "select * from bkw_article_temp";
//		String updatetemp="update bkw_article_temp set nextDate='2020-01-09',courseId=0 where id in (1,2,3,4)";

		//涨粉
//		String select6="select count(*) from activity_join where join_date>='2020-01-01'";
//		String select3="SELECT * FROM activity_join WHERE user_id='oc-5QwqyIfEErjAL8pHuxLmIgI2k' and activity_id=414  ";
//		String updateflag="update activity_join set needCollection1=1 where  join_date>='2020-01-01'";
//		String select4="select * form addfans_activity_user_analysis where openid='oc-5QwqyIfEErjAL8pHuxLmIgI2k' and activity=414";
		//订单  -18-01
		String updateset="update user_orderinfo set ptflagfree=1 "
				+ " where addtime<'2018-01-01' -- and addtime<'2018-07-01'";
		String updatetuiguang="UPDATE extension_pt_promotion_analysis "
		+" set  sittingwater=0,sittingorder=0,`new_sittingwater`=0,`new_sittingorder`=0,normal_sittingwater=0,normal_sittingorder=0,tj_normal_sittingwater=0,tj_normal_sittingorder=0,tj_sittingwater=0,tj_sittingorder=0,tj_new_sittingwater=0,tj_new_sittingorder=0,bj_normal_sittingwater=0,bj_normal_sittingorder=0,bj_sittingwater=0,bj_sittingorder=0,bj_new_sittingwater=0,bj_new_sittingorder=0,cq_normal_sittingwater=0,cq_normal_sittingorder=0,cq_sittingwater=0,cq_sittingorder=0,cq_new_sittingwater=0,cq_new_sittingorder=0,new_sittingorder_nodingjin=0,new_sittingwater_nodingjin=0,new_sittingwater_cache=0,new_sittingorder_cache=0,new_customer_number=0"
		+ " WHERE pt<20180101 -- and pt<20180701";
//		String updateset2="update user_orderinfo set flag=1 "
//				+ " where addtime>='2019-09-01' and addtime<'2019-11-01'";
//		String updateset3="UPDATE temp_pt_extension_project_clienttype set flag=0 WHERE reg_pt=20200101 ";
		
//		String update4="update promotion_register_report set keywordrepotflag=0 where keywordrepotflag=1 and pt>=20200101 and pt <=20200131";
		
//		String delete="DELETE FROM promotion_campaign_group_analysis WHERE pt=20190819 and masterid=1161 and clienttype=2 and extensionsourceid=190 and extensionsourcetype=''";

//		String update="UPDATE extension_pt_promotion_analysis SET flag=0 WHERE flag=2";
		
		//用户
		String select="select * from UserStats where usr_id=9455282 -- top";
		
//		String select1="SELECT MAX(id) FROM bkw_LearningDetail_0  -- top";//21410006
//		String select2="select * from bkw_migrate_temp where tablename like 'bkw_LearningDetail%' or tablename='bkw_Learning'   -- top";
//		String selecttemp="SELECT MAX(NodeId) FROM examsys_v3_duinei.dbo.bkw_Node  -- top";

		String selectsql="select * from bkw_migrate_temp where tablename='bkw_Learning-x' -- top ";
		String selectCount="select count(*) from bkw_Learning -- top ";
//		String selectsql2="select max(id) from bkw_migrate_temp  -- top ";
		//196
//		String selectsql3="select max(id) from bkw_Learning  -- top ";
		//32788224
		
		String updatesql2="update bkw_migrate_temp set target='26230639' where id in(9);"
				+ "update bkw_migrate_temp set target='6557704' where id in(197);"
		+ "update bkw_migrate_temp set target='13115349' where id in(198);"
		+ "update bkw_migrate_temp set target='19672994' where id in(199);"
		+ "update bkw_migrate_temp set target='0' where id in(200);"
		+ "update bkw_migrate_temp set target='0' where id not in(9,197,198,199,200);";
		//      0,6557704
		//6557704,13115349,19672994,26230639
		
		//475112|280556,280656
		Map<String,String> map =new HashMap<String, String>();
		//select2
		map.put("string", "tonxing_:"+updatesql5);
		//select,update
		String type="update";
		map.put("type", type);
//		map.put("size", "100");
		//bkw_question_article,bkw_data
		//thuiguang,orderanalysis,bkw_studypaper
		//oaandcrm,examsys
		//yitiku,weixinfenxiang
		map.put("source", "thuiguang");
		String results = HttpClientUtil.doPost(yuming2+"tuiGuangPromotionDataDouyin/stringis/longandlong", map);
		System.out.println(results);
		if("select".equals(type)){
			JSONArray parseArray = JSONArray.parseArray(results);
			for (int i = 0; i < parseArray.size(); i++) {
				JSONObject jsonObject = parseArray.getJSONObject(i);
				System.out.println(jsonObject);
			}
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
