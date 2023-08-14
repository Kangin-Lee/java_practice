package my.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	
	//서버...
	static ServerSocket server =null;
	
	//port 번호
	static final int PORT = 50001;
	
	//소갯
	static Socket socket;

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("================================================");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("================================================");
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("서버 대기 중...");
			
			socket = server.accept();
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println(inet.getHostAddress()+"클라이언트와의 접속 성공");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
