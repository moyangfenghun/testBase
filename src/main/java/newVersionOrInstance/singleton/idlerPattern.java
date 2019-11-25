package newVersionOrInstance.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

class idler{
	
}

public class idlerPattern {
	public static idler idler;

public static idler getIdler() {
	if(idler==null) {
		idler=new idler();
	}
	return idler;
}

public static void main(String[] args) {
	int threadNumber=100;
	ExecutorService service = Executors.newFixedThreadPool(threadNumber);
	for (int i = 0; i < threadNumber; i++) {
		service.execute(new threadme());
	}
	service.shutdown();
	System.out.println("end");
}

//@Test
//使用@test时线程不能sleep
public void test() {
	int threadNumber=50;
	ExecutorService service = Executors.newFixedThreadPool(threadNumber);
	for (int i = 0; i < threadNumber; i++) {
		service.execute(new threadme());
	}
	
}

}
