package my.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardTest {

	// 필드
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/users";
	String id = "root";
	String pwd = "1234";
	String loginOk = "";

	PreparedStatement pst = null;
	ResultSet rs = null;

	String sql = "";

	Scanner scanner = new Scanner(System.in);

	public BoardTest() {
		connect();

	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("연결 성공");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// 게시물 전체 조회
//	public void list() {
//		//connect();
//		try {
//			sql="SELECT bno, btitle, bcontent, bwriter, bdate FROM boards ORDER BY bno ASC";
//			pst = con.prepareStatement(sql);
//			rs = pst.executeQuery();
//			
//			while(rs.next()) {
//				int no = rs.getInt(1);
//				String title = rs.getString(2);
//				String content = rs.getString(3);
//				String writer = rs.getString(4);
//				java.sql.Date date = rs.getDate(5);
//
//				Board board = new Board(no, title, content, writer, date);
//				System.out.printf("%-6s%-12s%-16s%-40s \n",no,title,content,writer,date);
//				
//			}
//			rs.close();
//			pst.close();
//			
//		}catch(Exception e) {
//			e.getMessage();
//		}
//	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("===============================================");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("===============================================");

		// boards테이블에서 게시물 정보를 가져와 출력하기
		try {
			sql = "SELECT btitle,bcontent, bwriter, bdate FROM boards ORDER BY bno ASC";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			e.getMessage();
			exit();
		}

		mainMenu();
	}

//	public void userList() {
//	System.out.println();
//	System.out.println("[사용자 목록]");
//	System.out.println("===============================================");
//	System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
//	System.out.println("===============================================");
//
//	try {
//		sql = "SELECT userid,username, userpassword, userage, useremail FROM users";
//		pst = con.prepareStatement(sql);
//		rs = pst.executeQuery();
//	
//		while (rs.next()) {
//			User user = new User();
//			user.setUserid(rs.getString("userid"));
//			user.setUsername(rs.getString("username"));
//			user.setUserpwd(rs.getString("userpassword"));
//			user.setUserage(rs.getInt("userage"));
//			user.setUseremail(rs.getString("useremail"));
//			System.out.printf("%-6s%-12s%-16s%-40s\n", user.getUserid(), user.getUsername(), user.getUserpassword(),
//					user.getUserage(), user.getUseremail());
//		}
//		rs.close();
//		pst.close();
//	
//	} catch (Exception e) {
//		e.getMessage();
//		exit();
//	}
//
//	mainMenu();
//	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		if (loginOk == "") {
			System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
			System.out.print("메뉴선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();

			switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> join();
			case "5" -> login();
			case "6" -> exit();
			}
		} else {
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.LogOut | 6.Exit");
			System.out.print("메뉴 선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();

			switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> join();
			case "5" -> logout();
			case "6" -> exit();
			}

		}

	}

	private void login() {
		User user = new User();
		System.out.println("[로그인]");
		System.out.print("아이디: ");
		user.setUserid(scanner.nextLine());
		System.out.print("비밀번호: ");
		user.setUserpassword(scanner.nextLine());

		// 보조 메뉴 출력
		System.out.println("===============================================");
		System.out.println("보조 메뉴: 1.OK, 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			try {

				sql = "SELECT userpassword FROM users WHERE userid = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, user.getUserid());
				rs = pst.executeQuery();

				if (rs.next()) {
					String dbpassword = rs.getString("userpassword");
					if (dbpassword.equals(user.getUserpassword())) {
						loginOk = user.getUserid();

					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}

				} else {
					System.out.println("아이디가 존재하지 않습니다.");
				}
				rs.close();
				pst.close();
			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}
		mainMenu();
	}

	public void logout() {
		loginOk = "";
		
		list();
	}

	private void join() {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.print("아이디: ");
		user.setUserid(scanner.nextLine());
		System.out.print("이름: ");
		user.setUsername(scanner.nextLine());
		System.out.print("비밀번호: ");
		user.setUserpassword(scanner.nextLine());
		System.out.print("나이: ");
		user.setUserage(Integer.parseInt(scanner.nextLine()));
		System.out.print("이메일: ");
		user.setUseremail(scanner.nextLine());

		// 보조 메뉴 출력
		System.out.println("===============================================");
		System.out.println("보조 메뉴: 1.OK, 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			// user 테이블에 게시물 정보 저장
			try {
				sql = "INSERT INTO users(userid, username, userpassword, userage, useremail) VALUES (?,?,?,?,?)";

				pst = con.prepareStatement(sql);

				pst.setString(1, user.getUserid());
				pst.setString(2, user.getUsername());
				pst.setString(3, user.getUserpassword());
				pst.setInt(4, user.getUserage());
				pst.setString(5, user.getUseremail());

				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}
		list();
	}

	private void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scanner.nextLine());

		// 보조 메뉴 출력
		System.out.println("===============================================");
		System.out.println("보조 메뉴: 1.OK, 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			// boards 테이블에 게시물 정보 저장
			try {
				sql = "INSERT INTO boards(btitle,bcontent, bwriter, bdate) VALUES (?,?,?,now())  ";

				pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle());
				pst.setString(2, board.getBcontent());
				pst.setString(3, board.getBwriter());
				pst.executeUpdate();
				pst.close();
			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}
		list();
	}

	private void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());

		try {
			sql = "SELECT bno, btitle, bcontent, bwriter, bdate FROM boards WHERE bno = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();

			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));

				System.out.println("#################");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("#################");

				System.out.println("--------------------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
				String menuNo = scanner.nextLine();
				System.out.println();

				if (menuNo.equals("1")) {
					update(board);
				} else if (menuNo.equals("2")) {
					delete(board);
				} else if (menuNo.equals("3")) {
					list();
				}
			}

		} catch (Exception e) {
			e.getMessage();
			exit();
		}
		list();
	}

	// 글 수정
	private void update(Board board) {
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scanner.nextLine());

		System.out.println("--------------------------------");
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			try {
				sql = "UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno = ?";
				pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle());
				pst.setString(2, board.getBcontent());
				pst.setString(3, board.getBwriter());
				pst.setInt(4, board.getBno());
				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}
		list();
	}

	// 글 수정
	private void delete(Board board) {
		System.out.println("정말 삭제하시겠습니까?: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			try {
				sql = "DELETE FROM boards WHERE bno = ?";
				pst = con.prepareStatement(sql);

				pst.setInt(1, board.getBno());
				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}

		list();
	}

	// 테이블 전체 삭제
	private void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("--------------------------------");
		System.out.println("게시물을 전체 삭제하시겠습니까? : 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if (menuNo.equals("1")) {
			try {
				sql = "TRUNCATE TABLE boards";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
				pst.close();
			} catch (Exception e) {
				e.getMessage();
				exit();
			}
		}
	}

	private void exit() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {

			}
		}
		System.out.println("**게시판 종료**");
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardTest bt = new BoardTest();
		bt.list();

	}

}
