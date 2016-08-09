package InternetCode;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

public class URLDecoderTest {

	public static void URLConnection(){
		try {
			URL url= new URL("http://www.baidu.com");
			URLConnection con=url.openConnection();
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			System.out.println("内容类型:"+con.getContentType());
			System.out.println("内容编码类型:"+con.getContentEncoding());
			System.out.println("内容长度:"+con.getContentLength());
			System.out.println("内容:"+con.getDate());
			Scanner in =new Scanner(con.getInputStream());
			while (in.hasNext()) {
				System.out.println("输入流"+in.nextLine());				
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLConnection();
//		try {
//			String encodersString=URLEncoder.encode("中文 % #","utf-8");
//			System.out.println("编码后的字符："+encodersString);
//			String decoderString=URLDecoder.decode(encodersString,"utf-8");
//			System.out.println("解码后的字符集:"+decoderString);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}

}
