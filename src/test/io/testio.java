package test.io;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.junit.Test;

public class testio {
	/**
	 * @throws IOException
	 * File（url）中填写的路径可以是任何路径-相对绝对，
	 * 但文件会在编译后改变位置，所以编译后File()只能定位包下的路径。
	 * this.getClass().getResource("/")方法只用于定位编译后的文件位置，
	 * 但此方法对路径进行了编码，因此含有空格和中文路径需要解码
	 * 
	 */
	@Test
	public void showURL() throws IOException {

		// 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
		File f = new File(this.getClass().getResource("/").getPath());
		System.out.println("1"+f);

		//第二种种 获取当前类的所在包路径; 如果不加“/” 获取当前类的加载目录 D:\git\daotie\daotie\target\classes\my
		File f2 = new File(this.getClass().getResource("").getPath());
		System.out.println("2"+f2);

		// 第三种：获取项目路径 D:\git\daotie\daotie
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println("3"+courseFile);

		// 第四种： file:/D:/git/daotie/daotie/target/classes/
		URL xmlpath = this.getClass().getClassLoader().getResource("");
		System.out.println("4"+xmlpath);

		// 第五种： D:\git\daotie\daotie
		System.out.println("5"+System.getProperty("user.dir"));
		/*
		 * 结果： C:\Documents and Settings\Administrator\workspace\projectName 获取当前工程路径
		 */

		// 第六种： 获取所有的类路径 包括jar包的路径
		System.out.println("6"+System.getProperty("java.class.path"));

	}
	
	public void testfile() throws IOException {

		String string = "额王";
		byte b[] = string.getBytes(), sb[] = new byte[20];

		int f = 0;
		File file = new File("src/test/io/acc.txt");// ./ 代表项目路径下,所有类中定位位于应用目录下
		System.out.println(file.toString());
		if (file.exists()) {
			System.out.println("文件存在");
			// FileOutputStream fiss=new FileOutputStream(file,true);
			// fiss.write(b);
			FileInputStream fileInputStream = new FileInputStream(file);
			// BufferedReader bufferedReader =new BufferedReader(new FileReader(""));
			f = fileInputStream.read(sb);
			string = new String(sb);
			System.out.println(string);
		} else {
			System.out.println("文件不存在!");
			// FileOutputStream fiss=new FileOutputStream(file,true);
			// fiss.write(b);
			// if(file.createNewFile()) {
			// System.out.println("创建文件成功");
			// FileInputStream fileInp=new FileInputStream(file);
			// while((as=fileInp.read())!=-1){
			// System.out.print(as);
			//
			// }
			// }else {
			// System.out.println("重名失败");
			// }

		}
	}
}
