package test.zhujie;

import java.lang.reflect.Method;

import org.junit.Test;

import test.user.user;

public class Implementzhujie {
	@Test
	public void myzidiyi() throws Exception {
		Class<?> class1=user.class;
		Object obj =class1.newInstance();
		Method method=class1.getDeclaredMethod("eat", new Class[] {});
		if(method.isAnnotationPresent(zidingyi.class)) {
			zidingyi zi=method.getAnnotation(zidingyi.class);
			System.out.println(zi.value());
			method.invoke(obj, new Object[]{});
		}
	}
}
