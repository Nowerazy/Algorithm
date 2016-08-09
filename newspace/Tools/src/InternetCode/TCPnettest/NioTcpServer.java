package InternetCode.TCPnettest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTcpServer extends Thread {
	static ByteBuffer byteBuffer=ByteBuffer.allocate(512);//通过调用allocate()方法创建指定容量的Buffer实例
	/**
	 * 或者通过包装一个已有的数组来创建：
	 * ByteBuffer buffer = ByteBuffer.wrap(byteArray);//wrap:包装。
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",900));
			serverSocketChannel.configureBlocking(false);//设置为非阻塞信道
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				int nkey=selector.select();
				if (nkey>0) {
					Set<SelectionKey> selectionKeys = selector.selectedKeys();
					Iterator<SelectionKey> iterator =selectionKeys.iterator();
					while (iterator.hasNext()) {
						SelectionKey key =(SelectionKey) iterator.next();
						iterator.remove();
						if (key.isAcceptable()) {
							SocketChannel client=serverSocketChannel.accept();
							System.out.println("Accepted connection from "+client);
							client.configureBlocking(false);
							SelectionKey key2 =client.register(selector, SelectionKey.OP_WRITE);
							key2.attach(byteBuffer);
						}else if (key.isWritable()) {
							System.out.println("Server:SelectionKey is writable.");
							SocketChannel client=(SocketChannel)key.channel();
							ByteBuffer output=(ByteBuffer)key.attachment();
							if (!output.hasRemaining()) {
								output.rewind();
							}
							client.write(output);
						}
						key.channel().close();
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		NioTcpServer server=new NioTcpServer();
		server.start();
	}
}
