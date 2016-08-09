package InternetCode;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Local Host:"+InetAddress.getLocalHost());
			String host="localhost";
			InetAddress ipa=InetAddress.getByName(host);
			InetAddress hostobj=InetAddress.getLocalHost();
			System.out.println("本地地址名："+hostobj.getHostName());
			System.out.println("本地ip地址："+hostobj.getHostAddress());
			System.out.println("主机名称："+ipa.getHostName());
			System.out.println("主机ip地址："+ipa.getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
