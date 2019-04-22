package test2.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Date;

public class Server_side {

	public static void main(String[] args) throws IOException {
		// 设置主机名和端口号
		String ipString = "localhost";
		int port = 8080;
		// 创建socket对象
		ServerSocket serverSocket = new ServerSocket(port);

		Socket server = null;
		try {
			// 等待远程链接
			System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
			server = serverSocket.accept();
			System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
			// 输入流,读取客户端输出
			DataInputStream in = new DataInputStream(server.getInputStream());
			System.out.println(in.readUTF());
			// 输出流，输出到客户端
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			out.writeUTF("xx");
			System.out.println("closeservice...");
			server.close();
			serverSocket.close();

		} catch (SocketException se) {
			System.out.println("链接中断....");
		} catch (SocketTimeoutException s) {
			System.out.println("Socket timed out!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
