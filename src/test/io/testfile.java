package test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.junit.Test;

public class testfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 文件只能以流的形式或者字节数组的方式传递。。。。
		File file = new File("src/test/io/acc.txt");
		byte[] rad = new byte[365 * 1025];
		System.out.println(file);
		if (file.exists()) {
			FileInputStream fileinput = new FileInputStream(file);
			FileOutputStream fOutputStream = new FileOutputStream("y-2.txt");
			fileinput.read(rad);
			fOutputStream.write(rad);
			fileinput.close();
			fOutputStream.close();
			// 文件类的重命名和创建文件需要文件名不存在，删除文件需要文件名存在且对应的数据流关闭
			// File file2=new File("y-1.txt");
			// System.out.println(file2.createNewFile());
		} else {
			System.out.println("文件不存在");
		}
	}
	//向指定位置加入字符
	//@Test
	public void test() {
		File file = new File("src/test/io/acc.txt");
		FileInputStream fs;
		StringBuffer sb = new StringBuffer();
		try {
			fs = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fs);
			BufferedReader br = new BufferedReader(in);
			//输出
			FileOutputStream ot=new FileOutputStream(file);
			OutputStreamWriter ow=new OutputStreamWriter(ot);
			BufferedWriter bWriter=new BufferedWriter(ow);
			
			
			fs.close();
			in.close();
			br.close();
			ot.close();
			ow.close();
			bWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
