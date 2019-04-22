package test.Thread;

import java.util.concurrent.Callable;

public class callable<Object> implements Callable<Object>{
	@Override
	public Object call() throws Exception {
		System.out.println("aaaaaaa");
		for(int m=0;m<100;m++) {
			System.out.println("线程.....");
			Thread.sleep(10);
		}
		return  (Object) new Integer(6);
	}

}
