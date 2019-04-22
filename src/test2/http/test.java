package test2.http;

public class test {
	public static void main(String[] args) {
		String sendGet = httprequestUtil.sendGet("http://localhost:8080");
		System.out.println("返回字符"+sendGet);
	}
}
