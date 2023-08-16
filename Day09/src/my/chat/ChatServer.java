package my.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	// 서버...
	private static ServerSocket serverSocket = null;
	protected static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		System.out.println("================================================");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("================================================");

		startServer();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}

		scanner.close();

		stopServer();
	}

	public static void startServer() {
		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("서버 시작 됨");

					while (true) {
						System.out.println("\n 서버 연결 요청을 기다림 \n");

						Socket socket = serverSocket.accept();
						executorService.execute(() -> {
							try {
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("서버" + isa.getHostName() + "의 연결 요청을 수락함");

								// 데이터 받기
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();
								int data1 = dis.readInt();
								double data2 = dis.readDouble();

								// 데이터 보내기
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.writeInt(data1);
								dos.writeDouble(data2);
								dos.flush();
								System.out.println("서버 받은 데이터를 다시 보냄: " + message);
								System.out.println("서버 받은 데이터를 다시 보냄: " + data1);
								System.out.println("서버 받은 데이터를 다시 보냄: " + data2);

								// 연결 끊기
								socket.close();
								System.out.println("서버" + isa.getHostName() + "의 연결을 끊음");
							}catch(IOException e) {
								e.getMessage();
							}

						});

					}
				} catch (IOException e) {
					System.out.println("서버" + e.getMessage());

				}
			}
		};

		thread.start();
	}

	public static void stopServer() {
		try {
			serverSocket.close();
			executorService.shutdownNow();
			System.out.println("서버 종료됨");
		} catch (IOException e) {
		}
	}

}
