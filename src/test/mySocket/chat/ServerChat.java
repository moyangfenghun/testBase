package test.mySocket.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;

public class ServerChat{

	public static void main(String[] args) throws IOException {
		int port = 7063;
		//存储聊天的信息
		HashMap<String, String> StringMap=new HashMap<>();
		//服务对象
		ServerSocket serverSocket=new ServerSocket(7063);
		//持续监听，开启链接线程
		//开启一个管理线程
		System.out.println("服务器开始运行....");
		while (true) {
			try {
				//监听
				Socket socket=serverSocket.accept();
				System.out.println("和用户"+socket.getRemoteSocketAddress()+"建立了链接");
				DataInputStream in = new DataInputStream(socket.getInputStream());
	            String string=in.readUTF();
				//创建用户的服务端对话线程;
				//读取用户输入
				inputserverThread serverinput=new inputserverThread(socket,StringMap,string);
				Thread rThread=new Thread(serverinput);
				rThread.start();
				//向用户输出(别人的消息等)
				outserverThread serverOut=new outserverThread(socket,StringMap,string);
				Thread rThread2=new Thread(serverOut);
				rThread2.start();
			}catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	         } catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
