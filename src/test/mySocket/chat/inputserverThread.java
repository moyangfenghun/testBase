package test.mySocket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class inputserverThread implements Runnable {
	private String name;
	private Socket serversocket;
	private HashMap<String, String> hashMap;
	public inputserverThread(Socket socket,HashMap<String, String> hashMap,String name) {
		this.serversocket = socket;
		this.hashMap=hashMap;
		this.name=name;
	}
	@Override
	public void run() {
		try {
		while (true) {
			
				//输入流,读取客户端输出
	            DataInputStream in = new DataInputStream(serversocket.getInputStream());
	            String string=in.readUTF();
	            System.out.println("读取成功");
				int index=string.indexOf("@");
				if(index>=0) {
				String sendname=string.substring(0, index);
				String content=name+"对你说:"+string.substring(index+1);
				if(hashMap.containsKey(sendname)) {
					hashMap.put(sendname,content);
				}else {
					DataOutputStream out = new DataOutputStream(serversocket.getOutputStream());
					out.writeUTF("您发送的用户不存在！");
				}
	            System.out.println("sendname:"+sendname);
	            System.out.println("content:"+content);
				}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
