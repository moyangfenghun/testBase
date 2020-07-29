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
//		String updatesql1="update tuiguang_temporary set pt='20200101', pagesize=0,pagenum=-1 where id=85;";
		String updatesql2="update tuiguang_temporary set pt='20170101', pagesize=0,pagenum=-1 where id=86;";
		String updatesql3="update tuiguang_temporary set pt='20200310', pagesize=0,pagenum=-1 where id=87;";
		String updatesql4="update tuiguang_temporary set pt='20200320', pagesize=0,pagenum=-1 where id=88;";
		//100000,|app 8:13800.00,app 9:234455.70
		String select="SELECT COUNt(*) FROM bkw_Node -- top";
		String select2="select * from node where nodeid=33345";
		
		Map<String,String> map =new HashMap<String, String>();
		map.put("string", "tonxing_:"+select2);
		//select,update
		String type="select";
		map.put("type", type);
//		map.put("size", "100");
		//bkw_question_article,bkw_data
		//thuiguang,orderanalysis,bkw_studypaper,appthuiguang
		//oaandcrm,examsys
		//yitiku,weixinfenxiang,mysql,bkw_tiku
		map.put("source", "examsys");
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
