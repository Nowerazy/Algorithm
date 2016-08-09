package InternetCode.TCPnettest;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioTcpClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SocketAddress address=new InetSocketAddress("localhost", 900);
		SocketChannel clientChannel=SocketChannel.open(address);
		ByteBuffer buffer =ByteBuffer.allocate(255);
		clientChannel.read(buffer);
		while (true) {
			buffer.clear();
			int readBytes=clientChannel.read(buffer);
			if (readBytes>0) {
				buffer.flip();
				System.out.println("Client:readBytes="+readBytes);
				System.out.println("Client:data="+new String(buffer.array(),0,readBytes));
				clientChannel.close();
				break;
			}
			buffer.clear();
		}
	}

}
