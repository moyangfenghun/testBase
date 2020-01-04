package newcontent.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.FileChannel;

/**
 * @author ybt
 * 通道间传输数据
 */
public class TransferDemo {
	public static void main(String[] argv) throws Exception {
		String relativelyPath = System.getProperty("user.dir");
		// Path of Input files
		String[] iF = new String[] { relativelyPath + "/src/test2/nio/acc.txt", relativelyPath + "/src/test2/nio/gatherIOout.txt",
				relativelyPath + "/src/test2/nio/testout.txt"};
		// Path of Output file and contents will be written in this file
		String oF = relativelyPath + "/src/test2/nio/combine_output.txt";
		// Acquired the channel for output file
		FileOutputStream output = new FileOutputStream(new File(oF));
		WritableByteChannel targetChannel = output.getChannel();
		for (int j = 0; j < iF.length; j++) {
			// Get the channel for input files
			FileInputStream input = new FileInputStream(iF[j]);
			FileChannel inputChannel = input.getChannel();

			// The data is tranfer from input channel to output channel
			inputChannel.transferTo(0, inputChannel.size(), targetChannel);

			// close an input channel
			inputChannel.close();
			input.close();
		}
		// close the target channel
		targetChannel.close();
		output.close();
		System.out.println("All jobs done...");
	}
}
