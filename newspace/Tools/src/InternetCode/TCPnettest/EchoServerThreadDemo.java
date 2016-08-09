package InternetCode.TCPnettest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerThreadDemo {
	// 服务器端的服务接口
	public static final int SERVERPORT = 990;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int number = 1;
			ServerSocket serverSocket = new ServerSocket(SERVERPORT);
			System.out.println("started:" + serverSocket);
			while (true) {
				Socket incomeing = serverSocket.accept();
				System.out.println("connection " + number + "accepted: ");
				System.out.println(incomeing);
				Thread thread = new EchoThread(incomeing, number);
				thread.start();
				number++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

class EchoThread extends Thread {
	private Socket socket;
	int n;

	public EchoThread(Socket incoming, int nn) {
		socket = incoming;
		n = nn;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter outPrintWriter = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			System.out.println("Hello,Enter BYE to exit!");
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				} else {
					if (line.trim().equals("BYE")) {
						System.out.println("The client " + n + "entered BYE!");
						System.out.println("connection " + n
								+ "will be closed!");
						break;
					}
					System.out.println("Echo " + n + ":" + line);
					outPrintWriter.println("Echo" + n + ": " + line);
				}
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
