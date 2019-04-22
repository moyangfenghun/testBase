package test2.arithmetic;

public class basic {

	public static void main(String[] args) {
		int max=0;
		int num[]=new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i]=(int) (Math.random()*10);
		}
		String yString="abcdefg";

		char by[]=new char[yString.length()];
		for (int i = 0; i < by.length; i++) {
			by[i]=yString.charAt(by.length-i-1);
		}
		System.out.println(new String(by));
	}

}
