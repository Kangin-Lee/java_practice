package movie;

import java.io.IOException;
//import java.util.ArrayList;3


public class MainApp {

	static Movie movie;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("프로그램을 시작합니다.");
		Menu menu = MainMenu.getInstance();
		
		while (menu != null) {
			menu.print();
			menu = menu.next();
		}
		//모든 영화 정보 출력하기
//		ArrayList<Movie> list = Movie.findAll();
//		
//		for(Movie m:list) {
//			System.out.println(m.toString());
//		}
		
		System.out.println("프로그램을 종료됩니다.");
	}
	
	
}

interface Menu{
	void print();
//	void setPrevMenu(Menu prevMenu);
	Menu next();
	
	
}