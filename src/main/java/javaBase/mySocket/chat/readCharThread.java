package javaBase.mySocket.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


public class readCharThread implements Runnable {
	private Socket socket;
	public readCharThread(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		System.out.println("开启客户端接受消息线程");
		DataInputStream in;
		try {
			while (true) {
				in = new DataInputStream(socket.getInputStream());
				System.out.println(in.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
