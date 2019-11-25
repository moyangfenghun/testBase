package javaBase.mySocket.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class kehuduan2 {
	public static void main(String[] args) {
		//地址
		String host="localhost";
		//端口
		int port=7063;
		try {
			Socket socket=new Socket(host, port);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			Scanner scanner=new Scanner(System.in);
			System.out.println("请输入你的昵称,回车键结束");
			String myname=scanner.nextLine();
			out.writeUTF(myname.trim());
			readCharThread readCharThread=new readCharThread(socket);
			Thread rThread=new Thread(readCharThread);
			rThread.start();
			while (true) {
				System.out.println("请输入聊天内容，格式：要发送的人的昵称@内容");
				String string=scanner.nextLine();
				string=string.trim();
				DataOutputStream out1 = new DataOutputStream(socket.getOutputStream());
				out1.writeUTF(string);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
