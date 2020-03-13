package javaBase.Thread;

public class tedthread {
	int m=100;
	public  void show(String name,int is) {
		System.out.println("开始");
		for(int i=0;i<10;i++) {
			m--;
			System.out.println(name+m+"|"+i);
		}
		System.out.println("账户余额: " + m+"|线程数"+is);
	}
}
