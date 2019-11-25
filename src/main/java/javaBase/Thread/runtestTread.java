package javaBase.Thread;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class runtestTread {
	@Test
	public void testTread2() throws InterruptedException, ExecutionException {
		callable<Object> uis=new callable<Object>();
		FutureTask<Object> futureTask=new FutureTask<Object>(uis);
		Thread thread=new Thread(futureTask);
		System.out.println(thread.currentThread().getName());
		thread.start();
		for(int i=0;i<80;i++) {
			System.out.println("运行"+i);
		}
		System.out.println(new Date()+"++++++++++");
		System.out.println(futureTask.get());
		System.out.println(new Date()+"++++++++++");
		System.out.println("阻塞了吗");

	}
	
	
//	Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
//	Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
//	Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
	
	public void testTread() {
		tedthread tedthread = new tedthread();
		ExecutorService service = Executors.newFixedThreadPool(50);
		for (int i = 1; i <= 10; i++) {
			System.out.println("开启一个线程"+i);
			service.execute(new Runthread(tedthread,i));
		}
		tedthread.notify();//唤醒某个等待中的线程
		Thread.yield();//让步,与其他线程同时竞争执行
		
//		Thread aThread=new Thread(new Runthread(tedthread,2));
//		aThread.join();等待这个线程执行完毕
		
		//service.shutdown();//关闭线程
	}
}
