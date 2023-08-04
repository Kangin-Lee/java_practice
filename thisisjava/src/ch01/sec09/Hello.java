package ch01.sec09;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		int i = 1;
//		
//		
//		while(i <= 9) {
//			int j = 1;
//			while(j <= 9) {
//				System.out.print(i + " * " + j + " = " + i*j);
//				System.out.println("\t");
//				
//				j++;
//			}
//			++i;
//			System.out.println("\n");
//		}
//		String str = "";
//		Scanner scan = new Scanner(System.in);
//		while(true) {
//			str = scan.next();
//			if(str.equals("x") || str.equals("X")) {
//				System.out.println("종료됩니다.");
//				break;
//			}
//		
//		}
		int sum = 0;
		int random = 0;
		while(true) {
			random = (int) Math.floor(Math.random()*10);
			sum += random;
			System.out.println("랜덤한 값 " +random);
			Thread.sleep(2000);
			
			if(sum > 20) {
				System.out.println("합계가 20이 넘었습니다. "+ sum);
				break;
			}
		}
		
//		반지름 5인 원의 면적과 둘레
		int ban = 5;
		
		double a = ban * ban * Math.PI;
		double b = 2*ban*Math.PI;
		
		System.out.println("면적은 "+ a + " 둘레는 "+ b);
	}

}
