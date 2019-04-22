package test.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class liudingwei {
	@Test
	public void liupath() throws IOException {
//		1. Class.getResourceAsStream(String path) ：
//		path 不以'/'开头时默认是从此类所在的包下取资源，以'/'开头则是从ClassPath(Src根目录)根下获取。
//		其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
//		 
//		2. Class.getClassLoader.getResourceAsStream(String path) ：
//		默认则是从ClassPath根下获取，path不能以'/'开头，最终是由ClassLoader获取资源。
//		 
//		3. ServletContext.getResourceAsStream(String path)：
//		默认从WebAPP根目录下取资源，Tomcat下path是否以’/'开头无所谓，当然这和具体的容器实现有关。
		
		byte[] bs=null;
		File file=new File("src/test/io/acc.text");
		if(file.exists()) {
			System.out.println("文件存在");
		}
		InputStream inputStream=liudingwei.class.getResourceAsStream("/test/io/acc.text");
		bs=new byte[inputStream.available()];
		inputStream.read(bs);
		System.out.println(new String(bs));
	}
}
