package javaBase.mySocket.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class outserverThread implements Runnable {
	private Socket serversocket;
	private HashMap<String, String> hashMap;
	private String name;

	public outserverThread(Socket socket, HashMap<String, String> hashMap, String name) {
		this.serversocket = socket;
		this.hashMap = hashMap;
		this.name = name;
	}

	@Override
	public void run() {
		// 注册留言板
		System.out.println("注册留言板");
		hashMap.put(name, "");
		String string="";
		try {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 输出流，输出到客户端
				DataOutputStream out = new DataOutputStream(serversocket.getOutputStream());
				string = hashMap.get(name).toString();
				if (string != "") {
					out.writeUTF(string);
					hashMap.put(name, "");
					System.out.println("发送至客户端"); 
				}
			}
		} catch (IOException e) {
			int i=string.indexOf("对你说:");
			String sender=string.substring(0, i);
			hashMap.put(sender,"对方已下线");
			e.printStackTrace();
		}
	}

}
