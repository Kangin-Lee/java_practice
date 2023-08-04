package ch01.sec09;

import java.util.Scanner;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		반지름 5인 원의 면적과 둘레
//		int ban = 5;
//		
//		double a = ban * ban * Math.PI;
//		double b = 2*ban*Math.PI;
//		
//		System.out.println("면적은 "+ a + "둘레는 "+ b);
//		int sum = 0;
//		for(int i = 1; i <= 100; i++) {
//			if((i%3)==0)
//				sum += i;
//		}
//		System.out.println("3의 배수의 총 합은: "+sum+"입니다.");
//
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("\n");
		}
		
		
		
		for(int i = 5; i > 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println("\n");
		}
		
		System.out.println("===================================================");
		
		for(int i = 5; i > 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k < i; k++) {
				System.out.print("*");	
			}
			System.out.println();
			
			
			
		}
		

		
		System.out.println("\n===================================================");
		
	}

}
