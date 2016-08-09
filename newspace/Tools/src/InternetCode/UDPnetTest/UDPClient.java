package InternetCode.UDPnetTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	private DatagramSocket cli;
	private DatagramPacket pac;
	private byte sb[];
	private String sen;
	public UDPClient(){
		Init();
	}
	public void Init(){
		try {
			cli=new DatagramSocket();
			sb=new byte[1024];
			sen="UDP方式发送数据演示程序";
			sb=sen.getBytes();
			System.out.println("打包开始发送数据");
			pac=new DatagramPacket(sb, sb.length, InetAddress.getByName("localhost"), 993);
			cli.send(pac);
			sen="发送数据结束";
			sb=sen.getBytes();
			System.out.println("打包开始发送数据");
			pac=new DatagramPacket(sb, sb.length, InetAddress.getByName("localhost"), 993);
			cli.send(pac);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPClient();
	}

}
