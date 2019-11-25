package javaBase.TreeSet;

import java.util.HashMap;


public class mapss {

	public static void main(String[] args) {
		HashMap<String, Object> map=new HashMap<>();
		System.out.println(map.size());
		String mString=new String("a");
		String string=new String("b");
		map.put("a",mString );
		map.put("b",string);
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
	}

}
