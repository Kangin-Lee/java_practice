package ch01.sec09;

import java.util.Scanner;

public class Watercal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("1. 가정용(liter 당 50원)");
		System.out.println("2. 상업용(liter 당 45원)");
		System.out.println("3. 공업용(liter 당 30원)");
		
		System.out.print("메뉴를 선택하십시오 > ");
		int menu = scan.nextInt();
		System.out.print("사용량을 입력하세요. > ");
		int use = scan2.nextInt();
		
		if(menu == 1) {
			System.out.println("사용요금: "+ use * 50);
			System.out.println("총수도 사용 요금: "+ (use * 50 + (int)(use * 50 * 0.05)));
		}else if(menu == 2) {
			System.out.println("사용요금: "+ use * 45);
			System.out.println("총수도 사용 요금: "+ (use * 45 + (int)(use * 45 * 0.05)));
		}else if(menu == 3) {
			System.out.println("사용요금: "+ use * 30);
			System.out.println("총수도 사용 요금: "+ (use * 30 + (int)(use * 30 * 0.05)));
		}else
			System.out.println("잘못입력하였습니다.");

	}

}

