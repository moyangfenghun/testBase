package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class myreflect {
	
	@Test
	public void newinstance() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 获取类的类对象
		Class<?> class1 = Class.forName("test.user.user");
		//Class<?> sClass = user.class;
		//sClass.newInstance();

		// 获取类的构造器
		Constructor<?> constructor = class1.getDeclaredConstructor(new Class[] {});
		class1.getDeclaredMethods();
		
		// 通过构造器获取类对象
		Object object2 = constructor.newInstance(new Object[] {});
		System.out.println(object2);
		//属性赋值
		Field field = class1.getField("name");
		// 通过类的类对象获取类的方法
		Method method = class1.getDeclaredMethod("setName", new Class[] { String.class });
		
		// 反射获取赋值
		method.invoke(object2, "李四");

	}
}
