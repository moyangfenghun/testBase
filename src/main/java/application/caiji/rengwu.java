package application.caiji;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.RowSet;

import org.junit.Test;

import application.caiji.unitls.mySqlHelper_pool;
import javaBase.date.dateUtils;

public class rengwu {
	//18年7,10
	private static String enwpt="20190101";
	public static void main(String[] args) throws ParseException {
		String yuimng="http://datacollect.cnbkw.com:8088/";
		String yuming1="http://localhost:8080/datacollect/";

		ExecutorService service = Executors.newFixedThreadPool(15);
		//推广
//		service.execute(new myThread(yuimng+"tuiGuangPromotionDataDouyin/ADgroups","",2,true));
		service.execute(new myThread(yuimng+"tuiguang/ptanalysis/bianli/leiji","id=88&size=100",2,false));

		service.shutdown();
	}
	
	
	
//	@Test
	public void test() throws Exception{
		String keywords="'yjzcxf_84bfaec34bce45c2ac643b21060a40','yjzcxf_4ce2c41755ba426fb084369edb8b0f','yjzcxf_d33fe91d665347ee893c1646400799','yjzcxf_7d590331b5cb4c31ae5b2202a59a1e','yjzcxf_bd4a0cdb113b4dcf900b2abc8c32b4','yjzcxf_a211fb5a0d504ba78dc1026c2508ba','yjzcxf_a30ad8e7da6a48a09b1cf4cfa93374','yjzcxf_6a16c674ae06406b9cd00b2f3ae2b1','yjzcxf_80e91ad79a3f4889a26f44ef00691c','yjzcxf_cba2a61fdc6f493e9145abba9de7e0','yjzcxf_53726497a3db44109f1d85a99e6b8c','yjzcxf_bb8caa0c99714ab99f6b15806004fe','yjzcxf_45f412138b8b4f25a8749b169cb938','yjzcxf_07d242dcf76c409d84dc03ee2de08f','yjzcxf_7081eaa9411c409a9ab2966a8225ac','yjzcxf_2b69661c44974ff4848d455701f176','yjzcxf_39ad741e90ba47b5811098b94fb5fb','yjzcxf_49b797a2068a47c2876b01fdd1b34b','yjzcxf_1d46df961091443d8a99fe37415148','yjzcxf_67c343ec801b45cfa3582bd9839c48','yjzcxf_af4b1ff68aa54c869e8142396f7de0','yjzcxf_9ea7864d4a7140a5850b145fd173e5','yjzcxf_ef0e0efc16bb498bb2c0ae79c38382','yjzcxf_74b4eaf73f45411faeead4fc937e43','yjzcxf_661bca9e1bc2484c9a8e332df9503b','yjzcxf_70bd0600222c44d9b5206c26eb2730','yjzcxf_5c739be1e11749cfa10959a37652c1','yjzcxf_1a49ddb0f75140b2b5903957142e82','yjzcxf_6ac046771667436b9afb98e3c135f2','yjzcxf_d0074d4aad14455d9cc5ec2576bd85','yjzcxf_16c908a684b54f76b63fdc426b244c','yjzcxf_c49b2344689c4a1497bbf6e59af37c','yjzcxf_0b0159c15baa46aa95d600f2bda1cc','yjzcxf_77dd7cf85a9040ebbea704cd4c8bbb','yjzcxf_486ede09e79c4744ba7832690ad77e','yjzcxf_49f7ecd8c8d54bd49cab9f996641b5','yjzcxf_89b468d54cd449a49f5959d2a2c22f','yjzcxf_0a0bee11329c4b39a05007db675a91','yjzcxf_6c768770538042b9a8fa7d4e5f0873','yjzcxf_73525e2ad79346bb9d0aad9885d2a3','yjzcxf_b23f8da7d995490c99056aedf0efb4','yjzcxf_d9e13f58bf41427bb8774aebefb30a','yjzcxf_6b63ddf176534295931f294629829e','yjzcxf_c535c4ab787e4f8a90b9fb411e99eb','yjzcxf_5c80dcda886c4c62a871a998f577d5','yjzcxf_d4b58455c94148da93c931c2543370','yjzcxf_b2c899545b894a4abb8a2439f3f57c','yjzcxf_6930da6411134fc0a1c77a77a73507','yjzcxf_055889579ff74c2f94d397333589e1','yjzcxf_61dedba29e784083a813bf88acef73','yjzcxf_c341ca6690614ec0bd6fbf8f59176c','yjzcxf_522ceb0b9ce740bebac07b572a1e92','yjzcxf_35eb967879df4dce91e1b97700a3fd','yjzcxf_422cf911f06c4b84ab34bddb38ee57','yjzcxf_79f6e7dcae004d37823e483b919bd6','yjzcxf_3f88efb3a36a4f37bf941483801c7c','yjzcxf_63f25e08048b45aa80e85e0f2cba34','yjzcxf_a7028ddb09874c668aa5ae79b4b36a','yjzcxf_3ca8373f6fab4d4b8f004dd050ac43','yjzcxf_89fa6f49d9e84febb2c81902902186','yjzcxf_ef6aa7ccc2ce4189ba045e43a359cf','yjzcxf_2797440aa1f0405cbeb97c79bd357b','yjzcxf_c829bf20ebb6400e96d95d91fc757f','yjzcxf_1f2950df7bc4438589a0d27fcf53b1','yjzcxf_1786ff788e9d485e898abd6fec8e71','yjzcxf_65299f0bc56b4e5094a81fdaf9a5f3'";
		String sp1[]=keywords.replaceAll("'","").split(",");
		
		String sql="SELECT * FROM keyword_detail WHERE keywordCode in ("+keywords+")";
		System.out.println(sql);
		RowSet executeQuery = mySqlHelper_pool.executeQuery(mySqlHelper_pool.Conn_thuiguang,sql , null);
		String keys="";
		int s=0;
		while(executeQuery.next()){
			s++;
			keys+= executeQuery.getString("keywordCode")+",";
		}
		System.out.println("已有的"+s+"|"+keys);
		String sp2[]=keys.split(",");
		Map<String,String> map=new HashMap<String, String>();
		
		for (int i = 0; i < sp2.length; i++) {
			map.put(sp2[i],i+"");
		}
		for (int i = 0; i < sp1.length; i++) {
			if(!map.containsKey(sp1[i])){
				System.out.println("不存在"+i+"|"+sp1[i]);
			}
		}
		System.out.println("前后关键词总数"+sp1.length+"||"+sp2.length);
	}
	
//	@Test
	public void test2() throws Exception{
		String sql="SELECT * FROM extension_source WHERE ispaytype=1 ";
		System.out.println(sql);
		RowSet executeQuery = mySqlHelper_pool.executeQuery(mySqlHelper_pool.Conn_thuiguang,sql , null);
		String keys="";
		int s=0;
		while(executeQuery.next()){
			s++;
			keys+= executeQuery.getString("id")+",";
		}
		System.out.println("已有的"+s+"|"+keys);
	}
}
