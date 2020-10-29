package application.caiji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rengwu1 {

	public static void main(String[] args) {
		String local="http://localhost:8080/datacollect_new/";
		String test="http://test.datacollect.cnbkw.com:8083/";
		String yufa="http://yufa.datacollect.cnbkw.com:8083/";
		ExecutorService service = Executors.newCachedThreadPool();
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20190101&endpt=20190301&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20190301&endpt=20190501&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20190501&endpt=20190701&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20190701&endpt=20190901&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20190901&endpt=20191101&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20191101&endpt=20200101&ishistory=1",2,false));
		
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20180101&endpt=20180301&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20180301&endpt=20180501&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20180501&endpt=20180701&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20180701&endpt=20180901&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20180901&endpt=20181101&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20181101&endpt=20190101&ishistory=1",2,false));

//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20170101&endpt=20170301&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20170301&endpt=20170501&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20170501&endpt=20170701&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20170701&endpt=20170901&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20170901&endpt=20171101&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20171101&endpt=20180101&ishistory=1",2,false));

//		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20190701&endpt=20191001&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20191001&endpt=20200101&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20200101&endpt=20200301&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20200301&endpt=20200401&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20200401&endpt=20200501&ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","size=10&startpt=20200501&endpt=20200701&ishistory=1",2,false));

		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20170101&endpt=20180101&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20180101&endpt=20180501&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20180501&endpt=20180901&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20180901&endpt=20190101&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20190101&endpt=20190401&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20190401&endpt=20190801&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20190801&endpt=20191101&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20191101&endpt=20191201&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20191201&endpt=20200101&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20200101&endpt=20200301&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20200301&endpt=20200601&ishistory=1",2,false));
		service.execute(new myThread(yufa+"financial/dailyTask","startpt=20200601&ishistory=1",2,false));

//		service.execute(new myThread(yufa+"financial/dailyTask","ishistory=1",2,false));
//		service.execute(new myThread(yufa+"financial/dailyTask","",2,false));

		service.shutdown();
	}

}
