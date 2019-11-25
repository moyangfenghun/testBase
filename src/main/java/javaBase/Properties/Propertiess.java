package javaBase.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class Propertiess {

	@Test
	public void test() throws IOException {
		Properties por=new Properties();
		File file=new File("./src/test/Properties/dbconfig.properties");
		if(file.exists()) {
    	FileInputStream fileInputStream=new FileInputStream(file);
    	por.load(fileInputStream);
    	System.out.println(por.getProperty("jdbc.jdbcUrl"));
		}else {
			System.out.println("不存在");
		}
	}
}
