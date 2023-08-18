import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionExample {

	public static void main(String[] args) throws FileNotFoundException{
		//1. DB연결
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/users";
		String id = "root";
		String pwd = "1234";
		PreparedStatement pstmt2 = null;
		
		try {
		//드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,id,pwd);
		
		System.out.println("연결 성공!");
		
		//2. users 테이블에 사용자 저보 저장하기
//		String sql=""+
//				"INSERT INTO users (userid, username, userpassword, userage, useremail)"+"VALUES(?,?,?,?,?)";
		
		String sql2 = ""+
				"INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"+"VALUES(?,?,?,now(),?,?)";
		
		//3. 전송 객체
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt2 = con.prepareStatement(sql2);
		
//		pstmt.setString(1, "spring");
//		pstmt.setString(2, "이봄");
//		pstmt.setString(3, "12345");
//		pstmt.setInt(4, 22);
//		pstmt.setString(5, "spring@company.com");
		
		pstmt2 = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
		pstmt2.setString(1, "눈 오는 날");
		pstmt2.setString(2, "함박눈이 내려요");
		pstmt2.setString(3, "winter");
		pstmt2.setString(4, "a.txt");
		pstmt2.setBlob(5, new FileInputStream("a.txt"));
		
		
		//SQL문 실행, 데이터 전송
//		int rows = pstmt.executeUpdate();
		int rows = pstmt2.executeUpdate();
		
		
		if(rows == 1) {
			System.out.println("저장 성공");
			
			//현재 rows의 bno 값을 확인하기
			ResultSet rs = pstmt2.getGeneratedKeys();
			if(rs.next()) {
				int no = rs.getInt(1);
				System.out.println("저장된 bno: "+ no);
			}
			rs.close();
			
		}else {
			System.out.println("저장 실패");
		}
		
//		pstmt.close();
		pstmt2.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("연결 끊기");
				}catch(SQLException e) {

				}
			}
		}

	}

}
