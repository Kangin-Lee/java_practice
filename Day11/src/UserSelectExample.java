import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelectExample {

	// 필드 선언
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// url, id, pwd
	String url = "jdbc:mysql://localhost:3306/users";
	String id = "root";
	String pwd = "1234";

	String sql = "";

	// 생성자
	public UserSelectExample() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공!");

		} catch (Exception e) {
			e.getMessage();
			System.out.println("연결 실패");
		}

	}

	// 입력 메소드
	public int userInsert(User user) {
		int rows = 0;
		sql = "INSERT INTO users(userid, username, userpassword, userage, usereamil) VALUES (?,?,?,?,?);";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getUserassword());
			pst.setInt(4, user.getUserage());
			pst.setString(5, user.getUseremail());

			rows = pst.executeUpdate();

			pst.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return rows;
	}

	// 수정 메소드

	// 조회 메소드
	public List<User> selectAll() {
		sql = "SELECT *FROM users;";
		List<User> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			User user1;

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				int age = rs.getInt(4);
				String email = rs.getString(5);

				user1 = new User(id, name, password, age, email);
				list.add(user1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		UserSelectExample use = new UserSelectExample();

		List<User> list = use.selectAll();
		for (User u : list) {
			System.out.println("아이디: " + u.getUserid());
			System.out.println("이름: " + u.getUsername());
			System.out.println("비밀번호: " + u.getUserassword());
			System.out.println("나이: " + u.getUserage());
			System.out.println("이메일: " + u.getUseremail());

		}
		
		
		//입력 
		User user = new User("summer","여름","1234",20,"summer@naver.com"); 
		int result = use.userInsert(user);
		
		if(result == 1) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}

	}

}
