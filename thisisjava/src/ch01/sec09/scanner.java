package ch01.sec09;

import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		int money = 0;
		while(true) {
			
			System.out.println("----------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------------");
			System.out.print("선택> ");
			int str = Integer.parseInt(scan.nextLine());
			if(str == 1) {
				System.out.print("예금액>");
				money += scan2.nextInt();
		
			}else if(str == 2) {
				System.out.print("출금액>");
				money -= scan2.nextInt();
				
			}else if(str == 3) {
				System.out.println("잔고> "+money);
			}else if(str == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못입력하였습니다.");
			}
			
		}
	}

}
