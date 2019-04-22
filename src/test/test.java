package test;

import java.io.UnsupportedEncodingException;

import test.user.user;


public class test {

	public long feibonaqie(long num) {
		System.out.println("运行" + num);

		return num > 1 ? (feibonaqie(num - 1) + feibonaqie(num - 2)) : num;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		// System.out.println(new test().feibonaqie(5));
		
		
		String myString="abc";
		byte[] bys2=myString.getBytes("utf-8");
		for (byte b : bys2) {
			System.out.println("utf-8二进制码(10进制):"+b);
		}
		
		byte[] bys= {(byte) 97,(byte)98,99,100};
		char car[]= {'f',19971,1133,1738};
		
		String aString =new String(bys,"utf-8");
		
		String bsString=new String(car);
		
		System.out.println(bsString+"----"+String.valueOf(car));
		System.out.println(aString);
		
		

	}

}
