package application.caiji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rengwu2 {

	public static void main(String[] args) {
		String local="http://localhost:8080/datacollect_new/";
		String test="http://test.datacollect.cnbkw.com:8083/";
		String yufa="http://yufa.datacollect.cnbkw.com:8083/";

		ExecutorService service = Executors.newFixedThreadPool(15);
		service.execute(new myThread(yufa+"tuiguangnew/extensionpttimeintervalanalysis","size=50",2,false));
//		service.execute(new myThread(yufa+"tuiguangnew/ordertotuiguang","size=50",2,false));
//		service.execute(new myThread(yufa+"tuiguangnew/promotioncampaigngroupanalysisreg","size=50",2,false));

//		service.execute(new myThread(yufa+"/telsaleinfos/updateChange","size=2000&Initialize=1&index=133",2,false));

		service.shutdown();
	}

}
