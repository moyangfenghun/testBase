package application.caiji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rengwu1 {

	public static void main(String[] args) {
		String yuimng="http://datacollect.cnbkw.com:8088/";
		String yuming1="http://localhost:8080/datacollect/";
		String yufaing="http://test.datacollect.cnbkw.com:8083/";
		ExecutorService service = Executors.newCachedThreadPool();
		//推广花费
//		service.execute(new myThread(yufaing+"tuiguang/extensionptpromotionanalysis","size=100&type=1",2,false));
		//app花费
//		service.execute(new myThread(yufaing+"tuiguang/ptpromotion/orderanalysis/app","size=100&startpt=20200101",2,false));
		//流水业绩
		service.execute(new myThread(yufaing+"tuiguang/ptpromotion/orderanalysis","size=30&startpt=20200301&isleiji=1",2,false));
		//新字段
//		service.execute(new myThread(yufaing+"tuiguang/ptpromotion/orderanalysis/v2","size=100&startpt=20200301",2,false));


		service.shutdown();
	}

}
