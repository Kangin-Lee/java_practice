import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BoardUpdateExample {

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
		
		//2. Board 테이블에 bno = 1인 게시물 정보 수정하기

		
//		String sql2 = ""+
//				"UPDATE boards SET btitle =? , bcontent=?, bfilename=?, bfiledata=? WHERE bno=?";
		
		String sql3 = ""+
				"DELETE FROM boards WHERE btitle =?";
		
		//3. 전송 객체
		pstmt2 = con.prepareStatement(sql3);
		pstmt2.setString(1, "눈사람");
//		pstmt2.setString(2, "눈으로 만든 사람");
//		pstmt2.setString(3, "b.txt");
//		pstmt2.setBlob(4, new FileInputStream("b.txt"));
//		pstmt2.setInt(5, 1);
		
		
		
		//SQL문 실행, 데이터 전송
		int rows = pstmt2.executeUpdate();
		
		
		if(rows == 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
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
