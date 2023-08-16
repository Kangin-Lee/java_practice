package my.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	// 필드 선언
	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	String clientIp;
	String chatName;

	// 생성자..
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			
			this.clientIp = isa.getHostName();
			
			receive();

		} catch (Exception e) {
			
		}

	}//SocketClient()------------------------------------------------------------

	//클라이언트가 보낸 JSON 메시지 읽기 메소드
	private void receive() {
		chatServer.executorService.execute(()->{
			try {
				while(true) {
					String receiveJson = dis.readUTF();
					
					JSONObject jsonobject = new JSONObject(receiveJson);
					String command = jsonobject.getString("command");
					
					switch(command) {
					case"Incoming":
						this.chatName = jsonobject.getString("data");
//						chatServer.sendToAll(this, "들어오셨습니다.");
//						chatServer.addSocketClient(this);
						break;
						
					case"message":
						String message = jsonobject.getString("data");
//						chatServer.sendToAll(this, message);
						break;
					}
				}
			}catch(Exception e) {
//				chatServer.sendToAll(this, "나가셨습니다.");
//				chatServer.removeSocketClient(this);
			}
		});
		
	}//receive()-------------------------------------------------------
	
	public static void main(String[] args) {
		

	}

}
