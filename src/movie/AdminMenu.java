package movie;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu extends AbstractMenu{
	private static final AdminMenu instance = new AdminMenu(null);
	
	private static final String ADMIN_MENU_TEXT = 
			"1: 영화 등록하기\n"+
			"2: 영화 목록 보기\n"+
			"3: 영화 삭제하기\n"+
			"b: 메인 메뉴로 이동\n\n"+
			"메뉴를 선택하세요 ▼ ";
	
	private AdminMenu(Menu prevMenu) {
		super(ADMIN_MENU_TEXT, prevMenu);
	}
	
	public static AdminMenu getInstance() {
		return instance;
	}
	Scanner scanner = new Scanner(System.in);

	@Override
	public Menu next() {
		switch(scanner.nextLine()) {
		case"1":
			createMovie();
			return this;
		case"2":
			printAllMovies();
			return this;
		case "3":
			deleteMovie();
			return this;
		case "b":
			return prevMenu;
		default:
			return this;
	
		}

	}
	
	private void createMovie() {
		System.out.print("제목: ");
		String title = scanner.nextLine(); // 제목 입력
		System.out.print("장르: ");
		String genre = scanner.nextLine(); // 장르 입력
		Movie movie = new Movie(title, genre); // 영화 객체 생성
		try {
			movie.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 영화 객체를 저장
		System.out.println(">> 등록되었습니다.");
	}
	
	private void printAllMovies() {
		try {
			ArrayList<Movie> movies = Movie.findAll(); // 모든 영화를 가져옴
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.printf("%s\n", movies.get(i).toString()); // 출력
			}
		} catch (IOException e) {
			System.out.println("데이터 접근에 실패하였습니다."); // 예외 처리
		}
	}

	private void deleteMovie() {
		printAllMovies(); // 모든 영화를 출력
		System.out.print("삭제할 영화를 선택하세요: ");
		try {
			Movie.delete(scanner.nextLine()); // 사용자 입력값 기준으로 삭제 요청
			System.out.println(">> 삭제되었습니다.");
		} catch (IOException e) {
			System.out.println(">> 삭제에 실패하였습니다.");
		}
	}
}
