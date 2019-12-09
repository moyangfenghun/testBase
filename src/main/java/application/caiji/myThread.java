package application.caiji;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.util.StringUtils;

import newVersionOrInstance.http.HttpClientUtil;
import newVersionOrInstance.http.httprequestUtil;

public class myThread implements Runnable {

	private String url="";
	private String paramers="";
	private int jiange=2;
	private rengwu rengwu=null;
	public myThread(String url,String paramers,int jiange,rengwu rengwu) {
		this.url=url;
		this.paramers=paramers;
		this.jiange=jiange;
		this.rengwu=rengwu;
	}
	@Override
	public void run() {
		int jishu=1;
		while(jishu!=0){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			System.out.println("|"+url+"?"+paramers);
			String sendGet="";
			try {
				sendGet = HttpClientUtil.sendHttpGet(url+"?"+paramers);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(60*1000);
				} catch (InterruptedException d) {
					d.printStackTrace();
				}
			}
			long s=  new Date().getTime()-date.getTime();
			System.out.println(url.substring(url.length()-8, url.length())+":"+sendGet+"| "+ s*1.0/1000);
			String substring=paramers;
			if(paramers.length()>10){
				substring = paramers.substring(paramers.length()-8,paramers.length());
			}
			if(!StringUtils.isNullOrEmpty(sendGet)){
				try {
					JSONObject parseObject = JSON.parseObject(sendGet);
					if("leiji".equals(url.substring(url.length()-5,url.length()))){
					}else{
						if("0".equals(parseObject.getString("number"))&&!"20191231".equals(substring)){
							System.out.println(paramers+"---停止---");
							String[] getnewpt = rengwu.getnewpt();
							if(Integer.parseInt(getnewpt[0])>=20160101){
								paramers="size=15&startpt="+getnewpt[0]+"&endpt="+getnewpt[1];
								System.out.println(paramers+"---开始---");
							}else{
								jishu=0;
							}
						}
					}
					
				} catch (Exception e) {
					if("0".equals(sendGet)&&!"20191231".equals(substring)){
						System.out.println(paramers+"---停止---");
						jishu=0;
					}
				}
			}
			try {
				Thread.sleep(jiange*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public rengwu getRenwu() {
		return rengwu;
	}
	public void setRenwu(rengwu rengwu) {
		this.rengwu = rengwu;
	}

}
