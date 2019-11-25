package javaBase.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class dynamicProxys implements InvocationHandler {
	Object obj;
	
	public dynamicProxys(Object obj) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用方法前...");
		Object objs=method.invoke(obj, args);
		System.out.println("调用方法后...");
		return objs;
	}
	
}
