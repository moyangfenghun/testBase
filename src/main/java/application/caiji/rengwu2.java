package application.caiji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rengwu2 {

	public static void main(String[] args) {
		String yuimng="http://datacollect.cnbkw.com:8088/";
		String yuming1="http://localhost:8080/datacollect/";
		String yufaing="http://test.datacollect.cnbkw.com:8083/";

		ExecutorService service = Executors.newFixedThreadPool(15);

		//累计
		service.execute(new myThread(yufaing+"tuiguang/ptanalysis/bianli/leiji","size=200&id=86",2,false));
		
		service.shutdown();
	}

}
