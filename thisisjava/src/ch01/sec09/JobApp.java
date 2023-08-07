package ch01.sec09;

import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Scanner;

public class JobApp {
	
	//속성
	public JobApp() {
	
		
	}
	//메소드
	public void showMenu() {
		System.out.println("1. 구직 등록");
		System.out.println("2. 구인 등록");
		System.out.println("3. 구직자 정보 출력");
		System.out.println("4. 구인 회사 정보 출력");
		System.out.println("5. 종료");
	}
	
	public void inputPerson() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 >> ");
		String name = scan.next();
		System.out.print("나이 입력 >> ");
		int age = scan.nextInt();
		System.out.print("성별 입력 >> ");
		System.out.println("1. 남자 , 2. 여자");
		int n = scan.nextInt();
		
		char sex;
		if(n==1) {
			sex = 'M';
		}else 
			sex = 'F';

			
		
		System.out.println("전화번호 입력>>");
		String tel = scan.next();
		
		Person1 person = new Person1(name, age, sex, tel);
		
		ArrayList<Person1> list = new ArrayList<Person1>();
		list.add(person);
		
		
		//메소드 내에서 메소드 호출
		String result = person.showProfile();
		System.out.println(result);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobApp job = new JobApp();
		Scanner scan1 = new Scanner(System.in);
		
		while(true) {
			job.showMenu();
			int num = scan1.nextInt();
			
			if(num == 5) {
				System.out.println("정상종료");
				System.exit(0);
			}else if (num == 1) {
				job.inputPerson();
			}
		}

	}

}
