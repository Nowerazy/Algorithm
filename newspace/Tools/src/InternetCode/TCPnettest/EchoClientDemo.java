package InternetCode.TCPnettest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientDemo {
	//未成功，不知原因。。。。。。。。。。。。。。。。。。
		// 服务器端的服务接口
	public static final int SERVERPORT = 990;

	public static void main(String[] args) {
		try {
			//建立套接字localhost
			Socket socket=new Socket("localhost",SERVERPORT);
			System.out.println("socket= "+socket);
			BufferedReader inBufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter outPrintWriter =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string,Enter BYE to exit!");
			while (true) {
				outPrintWriter.println(stdin.readLine());
				String string =inBufferedReader.readLine();
				if (string==null) {
					break;
				}
				System.out.println(string);
			}
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("IOException "+e.getMessage());
		}
	}

}
