package javaBase.mySocket.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udpaccpetsocket {
	public static void main(String[] args) throws IOException {
		int port = 233;
		String host = "localhost";
		byte[] bs=new byte[10];
		
		DatagramSocket dSocket = new DatagramSocket(port);
		
		DatagramPacket dPacket=new DatagramPacket(bs, bs.length);
		dSocket.receive(dPacket);
		bs=dPacket.getData();
		System.out.println("bs:"+new String(bs));
		dSocket.close();
		System.out.println("a关闭连接...");
	}
}
