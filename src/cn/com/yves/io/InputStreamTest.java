package cn.com.yves.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {
		int readlimit = 1;
		byte[] b = new byte[1024];

		InputStream is = System.in;// 系统内建的InputStream

		is.available();

		is.mark(readlimit);

		is.markSupported(); // 测试此输入流是否支持 mark 和 reset 方法。

		is.read();

		is.read(b);

		is.reset();

		is.skip(1000);

		is.close();// 关闭流
	}
}
