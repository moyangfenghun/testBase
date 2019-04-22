package test2.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author ybt
 * 通道示例
 */
public class ChannelDemo {
	public static void main(String args[]) throws IOException {
//		获取系统user.dir的信息;user.dir表示项目磁盘目录F:\javaworkspace\cest
		String relativelyPath = System.getProperty("user.dir");
		System.out.println(relativelyPath);
//		创建读取fileChannel
//		System.out.println(ChannelDemo.class.getResource("acc.txt"));
		FileInputStream input =new FileInputStream("src/test2/nio/acc.txt");
		ReadableByteChannel source = input.getChannel();
//		创建输出通道
		FileOutputStream output = new FileOutputStream("src/test2/nio/testout.txt");
		WritableByteChannel destination = output.getChannel();
//		复制数据
		copyData(source, destination);
//		关闭通道
		source.close();
		destination.close();
		System.out.println("Copy Data finished.");
	}

	private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
		while (src.read(buffer) != -1) {
			// The buffer is used to drained
			buffer.flip();
			// keep sure that buffer was fully drained
			while (buffer.hasRemaining()) {
				dest.write(buffer);
			}
			buffer.clear(); // Now the buffer is empty, ready for the filling
		}
	}
}
