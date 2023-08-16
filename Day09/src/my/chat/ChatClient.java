package my.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	
	//소갯
	static Socket socket;

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost",50001);
			
			System.out.println("클라이언트 연결 성공");
			
			String message ="안녕 자바";
			int data1 = 20;
			double data2 = 15.25;
			
			//데이터 보내기
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
			dos.writeInt(data1);
			dos.writeDouble(data2);
			dos.flush();
			System.out.println("클라이언트 데이터 보냄: "+message+", "+data1+", "+data2);
			
			//데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			int receiveData1 = dis.readInt();
			double receiveData2 = dis.readDouble();
			
			System.out.println("클라이언트 데이터 받음: "+ receiveMessage);
			System.out.println("클라이언트 데이터 받음: "+ receiveData1);
			System.out.println("클라이언트 데이터 받음: "+ receiveData2);
			
			
			socket.close();
			System.out.println("클라이언트 연결 끊음");
		}catch(UnknownHostException e) {
			
		}catch(IOException e) {
			
		}
		
	}

}
