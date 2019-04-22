package cest;

import test.test;

public class myString {

	public String fanzhuan(String str) {
		String ssr="";
		for(int i=str.length()-1;i>=0;i--){
			ssr=ssr+str.charAt(i);
		}
		System.out.println(ssr);
		return ssr;
	}
	public static String reverse(String originStr) {
	      if(originStr == null || originStr.length() <= 1) 
	          return originStr;
	      return reverse(originStr.substring(1)) + originStr.charAt(0);
	  }
	
	
	public void test() {
		StringBuilder stringB=new StringBuilder("DL");
	}
}
