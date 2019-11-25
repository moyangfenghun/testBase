package javaBase.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author ybt
 *
 */
public class testProxy {

	public static void main(String[] args) {
		// 创建被代理的对象
		JobSearchImplement jobSearch = new JobSearchImplement();
		// #创建代理对象
		dynamicProxys proxys = new dynamicProxys(jobSearch);//自定义代理对象
		// ##第一个参数是被代理对象的类的加载器，第二个参数是被代理对象的接口类对象，第三个参数是自定义代理对象（继承了InvocationHandler）
		JobSearch search = (JobSearch) Proxy.newProxyInstance(JobSearchImplement.class.getClassLoader(),
				jobSearch.getClass().getInterfaces(), proxys);
		search.setname("李四");
		
		search.getresumeName();
		
		search.displayname();
	}

}
