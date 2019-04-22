package test.mySocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class kehuduan {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 设置主机名和端口号
		String ipString = "localhost";
		int port = 6066;
		// 创建socket对象
		Socket client = new Socket(ipString, port);
		// 读取输出流，输出到服务端
		// out.writeUTF("客户端的问候：" + client.getLocalSocketAddress());
		// 读取输入流，读取服务端的输出流

		// System.out.println("服务器响应： " + in.readUTF());
		while (true) {
			String string = "";
			Scanner scanner = new Scanner(System.in);
			string = scanner.nextLine();
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("客户端：" + string);
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("收到了"+in.readUTF());
		}
	}
}
