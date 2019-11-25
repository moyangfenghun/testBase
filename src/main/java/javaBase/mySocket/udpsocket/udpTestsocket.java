package javaBase.mySocket.udpsocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpTestsocket {
	public static void main(String[] args) throws IOException {
		int port = 233;
		String host = "localhost";
		String str = "i love you";
		byte[] bs=str.getBytes();
		DatagramSocket dSocket = new DatagramSocket();
//		dSocket.setReceiveBufferSize(size);//接受大小
//		dSocket.setBroadcast(on);//广播
//		dSocket.disconnect();//断开连接
//		dSocket.receive(p);//接收
		DatagramPacket dPacket=new DatagramPacket(bs,bs.length);
		
		dSocket.connect(InetAddress.getByName(host),port);
		dSocket.send(dPacket);
		dSocket.close();
		System.out.println("b关闭连接...");
	}
}
