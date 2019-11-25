package newVersionOrInstance.java8;

/**
 * 函数式接口
 */
interface StringFunc {
    
    int[] func(int n);
    
}

class MyStringOps {
    
    //静态方法： 反转字符串
    public static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    //显示字符串
    public static String  strShow(String s) {
    	System.out.println(s);
    	return s;
    }

}

public class testyingyong {
	public static int[] stringOp(StringFunc sf, int s) {
        return sf.func(s);
    }
    
    public static void main(String[] args) {
        String inStr = "lambda add power to Java";
        //MyStringOps::strReverse 相当于实现了接口方法func() 
        // 并在接口方法func()中作了MyStringOps.strReverse()操作
        int outStr[] = stringOp(int[]::new,1);
        System.out.println(outStr.length);
        System.out.println("Original string: " + inStr);
        System.out.println("String reserved: " + outStr);
        
    }
}
