package cn.com.yves.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

	public static void copy() throws Exception {

		String source = "files/nio1.png";
		String dest = "files/nio2.png";

		FileInputStream inputStream = new FileInputStream(source);
		FileOutputStream outputStream = new FileOutputStream(dest);

		FileChannel iChannel = inputStream.getChannel();
		FileChannel oChannel = outputStream.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long curentTime = System.currentTimeMillis();

		System.out.println("开始复制!");
		while (true) {
			buffer.clear();// 清除此缓冲区。将位置设置为 0，将限制设置为容量，并丢弃标记。
							// 将pos=0,limit=capcity，作用是让ichannel从pos开始放数据

			int r = iChannel.read(buffer);
			if (r == -1) {// 到达文件末尾
				break;
			}

			// buffer.position() 返回此缓冲区的位置

			buffer.limit(buffer.position());// 参数newLimit
											// 设置此缓冲区的限制。如果位置大于新的限制，则将它设置为新限制。
											// 如果标记已定义且大于新限制，则丢弃该标记。

			buffer.position(0);// 设置此缓冲区的位置
			oChannel.write(buffer);// 它们的作用是让ochanel写入pos - limit之间的数据
		}

		outputStream.close();
		inputStream.close();

		System.out.println("完成所花的时间:"
				+ (System.currentTimeMillis() - curentTime));
	}

	public static void main(String[] args) {
		try {
			copy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
