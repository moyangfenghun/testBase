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
//		String updatesql1="update tuiguang_temporary set pt='20191227', pagesize=0,pagenum=-1 where id=85;";
//		String updatesql2="update tuiguang_temporary set pt='20170101', pagesize=0,pagenum=-1 where id=86;";
//		String updatesql3="update tuiguang_temporary set pt='20170101', pagesize=0,pagenum=-1 where id=87;";
		String updatesql5="update tuiguang_temporary set pt='20191227', pagesize=0,pagenum=-1 where id=88;";
//		String updatesql4="update tuiguang_temporary set pt='0', pagesize=0,pagenum=0,remark='推广来源注册量-历史' where id=83;";
		
//		String update= "INSERT INTO promotion_register_report(pt,timeinterval,extensionsourceid,masterid,keywordCode,clienttype,paymoney,discount_paymoney)VALUES(20191225,'-1',999,999,'fffkkk',2,100,100) ON DUPLICATE KEY UPDATE paymoney=0,discount_paymoney=0,keywordrepotflag=0";
//		String update2=" UPDATE promotion_register_report set paymoney=0,discount_paymoney=0 WHERE pt=20191225 and timeinterval='-1'  and extensionsourceid=999 and masterid=999 and keywordCode='fffkkk' and clienttype=2";
//		String delete="DELETE FROM promotion_register_report WHERE pt=20191225 and timeinterval='-1'  and extensionsourceid=999 and masterid=999 and keywordCode='fffkkk' and clienttype=2";
//		String updateflag=" UPDATE promotion_register_report set keywordrepotflag=0 WHERE pt>=20191223  ";
		
//		String select="select * from tuiguang_temporary where id=85";
//		String insert="insert into tuiguang_temporary(id,pt,pagesize,pagenum,remark) values(92,'4425374',0,0,'采集历史用户数据');";

//		String select1="select COUNT(*) as sum From UserStats with(nolock) where AddTime between '2020-01-03 00:00:00' and '2020-01-03 23:59:59.99' and initialmasterid=1209   and Recommend in "
//				+ "(1,7,12,13,14,15,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,37,38,39,40,41,42,43,44,45,46,47,48,49,51,52,53,54,69,70,71,72,73,74,75,77,78,79,80,83,84,86,87,88,89,90,92,93,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,122,123,124,125,126,127,128,129,130,131,132,134,136,139,140,141,142,144,145,146,147,148,149,150,151,153,154,155,156,157,158,160,161,162,163,164,165,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,183,184,185,186,187,188,189,190,192,193,194,195,196,197,198,199,200,201,203,204,205,206,207,208,209,210,212,213,214,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,235,236,237,238,239,240,241,242,243,245,246,247,248,249,250,251,252,253) -- top ";
//		String udpatetag="update new_askanswer_temp  set tag=747825 where id=2";
		
		String select="select * from new_askanswer_temp";
		
		Map<String,String> map =new HashMap<String, String>();
		map.put("string", "tonxing_:"+select);
		//select,update
		map.put("type", "select");
//		map.put("size", "100");
		//weixinfenxiang,thuiguang,bkw_question_article,examsys,bkw_data,oaandcrm
		map.put("source", "bkw_data");
		String results = HttpClientUtil.doPost(yuming2+"tuiGuangPromotionDataDouyin/stringis/longandlong", map);
		System.out.println(results);
		
//		if("select".equals(type)){
//			JSONArray parseArray = JSONArray.parseArray(results);
//			for (int i = 0; i < parseArray.size(); i++) {
//				JSONObject jsonObject = parseArray.getJSONObject(i);
//				jsonObject.getString("MasterId2");
//			}
//		}
	}
	
	/*
	 * 清除数据接口
	 */
	@Test
	public void test(){
		//extension_pt_timeinterval_analysis
		//extension_pt_promotion_analysis_copy
		//generateArticle/setArticleplan
		String yuming="http://datacollect.cnbkw.com:8088/";
		Map<String,String> map =new HashMap<String, String>();
//		map.put("beginDate", "20191101");
//		map.put("endDate", "20191215");
//		map.put("exId", "144");
		//extension_pt_promotion_analysis_copy,promotion_campaign_group_analysis_copy
//		map.put("tableName", "extension_pt_promotion_analysis_copy");
		//guangdiantonganalysis
		
		//设置生成文章
//		map.put("id", "4");
//		map.put("countdown", "1");
//
//		String results = HttpClientUtil.doPost(yuming+"generateArticle/setArticleplan", map);
//		System.out.println(results);
		
	}
}
