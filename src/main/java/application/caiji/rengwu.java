package application.caiji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rengwu {
	public static void main(String[] args) {
		String yuimng="http://datacollect.cnbkw.com:8088";
		ExecutorService service = Executors.newFixedThreadPool(20);
		
		//推广
		service.execute(new myThread("https://cn.bing.com/?FORM=Z9FD1", ""));
		
		service.shutdown();
	}
}
