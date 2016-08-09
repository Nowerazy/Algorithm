package InternetCode.UDPnetTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserve {
	
	private DatagramSocket socket;
		private DatagramPacket packet;
		private byte rb[];
		private String rev;
		public UDPserve(){
			Init();
		}
		public void Init(){
			try {
				System.out.println("服务器启动");
				socket=new DatagramSocket(993);
				rb=new byte[1024];
				packet=new DatagramPacket(rb, rb.length);
				rev="";
				int i=0;
				while (true) {
					System.out.println("等待接收数据");
					socket.receive(packet);
					i=packet.getLength();
					if (i>0) {
						rev=new String(rb,0,packet.getLength());
						System.out.println("接收的数据为："+rev);
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPserve();

	}

}
