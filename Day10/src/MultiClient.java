import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener, Runnable {

	// 필드
	JButton btn1, btn2;
	JTextArea jta; // 여러줄 입력 가능 객체
	JTextField jtf; // 한줄 입력 가능 객체
	// 필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	JPanel jp;

	public MultiClient() {
		btn1 = new JButton("전송");
		btn2 = new JButton("취소");
		jta = new JTextArea();
		jtf = new JTextField(20);
		jp = new JPanel();
		jp.setBackground(Color.LIGHT_GRAY);

		setLayout(new BorderLayout());
		jp.add(jtf);
		jp.add(btn1);
		add(jta, "Center");
		add(jp, "South");
		
		btn1.addActionListener(this);

		setTitle("멀티 채팅 프로그램_GUI 버전");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		/////////////////////////////////////////
		Thread thread = new Thread(this);
		thread.start();
		////////////////////////////////////////

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String str = e.getActionCommand();
//		
//		if(str.equals("전송")) {
//			
//		}else if(str.equals("취소")) {
//			
//		}

		Object obj = e.getSource();
		if (obj == btn1) {
			String result = jtf.getText().toString();
			try {
				dos.writeUTF(result);

				jta.setText("나: " + jtf.getText() + "\n" + jta.getText());
				jtf.setText("");
			} catch (Exception e1) {
				e1.getMessage();
			}

		}
	}

	public static void main(String[] args) {
		new MultiClient();
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 9999);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("클라이언트 연결 성공");
			
			while(true) {
				String msg = dis.readUTF().toString();
				jta.setText("상대방: "+msg+"\n"+jta.getText());
				System.out.println("Message: "+msg);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
