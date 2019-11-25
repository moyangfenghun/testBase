package application.caiji;

import newVersionOrInstance.http.httprequestUtil;

public class myThread implements Runnable {

	private String url="";
	private String paramers="";
	public myThread(String url,String paramers) {
		this.url=url;
		this.paramers=paramers;
	}
	@Override
	public void run() {
		int jishu=1;
		while(jishu!=0){
			String sendGet = httprequestUtil.sendGet(url+"?"+paramers);
			System.out.println(sendGet);
		}
	}

}
