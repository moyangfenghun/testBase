package javaBase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author ybt
 * 对文件和文件夹操作的工具类
 */
public class fileutil {
	public void copyfile(String startlocation,String tolocation) {
		File strfile=new File(startlocation);
		
		try {
			BufferedInputStream bufferInput=new BufferedInputStream(new FileInputStream(strfile));
			BufferedOutputStream outInput=new BufferedOutputStream(new FileOutputStream(tolocation));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
