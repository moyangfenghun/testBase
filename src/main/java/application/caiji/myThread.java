package application.caiji;

import java.util.Date;

import com.mysql.cj.util.StringUtils;

import newcontent.http.HttpClientUtil;

public class myThread implements Runnable {

	private String url="";
	private String paramers="";
	private int jiange=1;
	private boolean isissingle=false;
	public myThread(String url,String paramers,int jiange,boolean isissingle) {
		this.url=url;
		this.paramers=paramers;
		this.jiange=jiange;
		this.isissingle=isissingle;
	}
	public myThread(String url,String paramers,int jiange) {
		this.url=url;
		this.paramers=paramers;
		this.jiange=jiange;
	}
	@Override
	public void run() {
		int jishu=1, xishu=1;
		while(jishu!=0){
			Date date=new Date();
			System.out.println("|"+url+"?"+paramers);
			String sendGet="";
			try {
				sendGet = HttpClientUtil.sendHttpGet(url+"?"+paramers);
			} catch (Exception e) {
				xishu=30;
			}
			long s=  new Date().getTime()-date.getTime();
			System.out.println(url.substring(url.length()-8, url.length())+":"+sendGet+"| "+ s*1.0/1000);
			if(!StringUtils.isNullOrEmpty(sendGet)){
				String urlsuffix5 = url.substring(url.length()-5, url.length());
				if("leiji".equals(urlsuffix5) ) {
				}
			}
			if(isissingle) {
				isissingle=false;
				jishu=0;
			}
			try {
				Thread.sleep(xishu*jiange*1000);
				xishu=1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
