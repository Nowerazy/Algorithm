package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Picturewrite {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("C:\\Users\\ZhaoYan\\Pictures\\1034.jpg");
		OutputStream out = new FileOutputStream("abc.jpg");//默认为：工程根目录
		byte[] buffer = new byte[1024];
		int len=0;
		while ((len=in.read(buffer))!=-1) {
			System.out.println(len);
			out.write(buffer, 0, len);			
		}
		in.close();
		out.close();
	}
}
