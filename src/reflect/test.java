package yers.test.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class test {
//	@Test
	public void test2() {
		controller c = new controller();
		c.s = 3;
		z z = (z) c;
		System.out.println(z.s);
	}
	@Test
	public void test1() {

		Integer number = 11;

		String classname = "yers.test.reflect.controller";
		Class<?> forName = null;
		try {
			forName = Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 获取类信息
		try {
			Object newInstance = forName.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 获取到对象
		// Method[] methods = forName.getMethods();//获取所有公开的方法，包括继承的类
		// for (Method method : methods) {
		// System.out.println("lll:"+method.getName());
		// }
		Method[] declaredMethods = forName.getDeclaredMethods();// 获取所有自己类的方法
		for (Method method : declaredMethods) {
			System.out.println("-----------:" + method.getName());
			// 判断访问权限
			if ((Modifier.isPublic(method.getModifiers()))) {
				//获取参数类型
				Class<?>[] parameterTypes = method.getParameterTypes();
				for (Class<?> class1 : parameterTypes) {
					System.out.println(class1.getName());
				}
				System.out.println(method.getParameterCount());
				Parameter[] parameters = method.getParameters();
				//反射获取参数名，该方法只有jdk1.8后能获取到，需要配置参数javac -parameters
				for (Parameter parameter : parameters) {
					System.out.println(parameter.getName());
					System.out.println(parameter.getType().getName());
				}
				// method.invoke(newInstance,number);
			}
		}
	}
}
