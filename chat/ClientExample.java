package my.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExample {
	
	//소갯
	static Socket socket;

	public static void main(String[] args) {

		
		try {
			Socket socket = new Socket("localhost",50001);
			
			System.out.println("클라이언트 연결 성공");
			
			socket.close();
			System.out.println("클라이언트 여결 끊음");
		}catch(UnknownHostException e) {
			
		}catch(IOException e) {
			
		}
		
	}

}
