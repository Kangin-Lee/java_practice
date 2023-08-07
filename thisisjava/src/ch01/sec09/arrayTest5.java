package ch01.sec09;

import java.util.Scanner;

public class arrayTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][] array = {
//				{95,86},
//				{83,92,96},
//				{78,83,93,87,88}
//		};
//		
//		int[][] array1 = new int[3][];
//		array1[0] = new int[2];
//		array1[1] = new int[3];
//		array1[2] = new int[5];
//		
//		
//		array1[0][0] = 95;
//		array1[0][1] = 86;
//		array1[1][0] = 83;
//		array1[1][1] = 92;
//		array1[1][2] = 96;
//		array1[2][0] = 78;
//		array1[2][1] = 83;
//		array1[2][2] = 93;
//		array1[2][3] = 87;
//		array1[2][4] = 88;
//		
//		
//		for(int i = 0; i < array1.length; i++) {
//			for(int j =0; j < array1[i].length; j++) {
//				System.out.print(array1[i][j]+" ");
//			}
//			System.out.println("");
//		}
		
		//================================================================================
//		int array[] = {1, 5, 3, 8, 2, 10};
//		
//		int max=-1;
//		int min = 100;
//	
//		for(int i = 0; i < array.length; i++) {
//			max = Math.max(max, array[i]);
////			if(max < array[i])
////				max = array[i];
////			
////			if(min > array[i])
////				min = array[i];
//			min = Math.min(min, array[i]);
//		}
//		
//		System.out.println("최대값은: "+max);
//		System.out.println("최소값은: "+min);
		//===================================================================================
//		int sum = 0;
//		int cnt = 0;
//		for(int i = 0; i < array1.length; i++) {
//			for(int j = 0; j <array1[i].length; j++) {
//				sum += array1[i][j];
//				cnt++;
//			}
//		}
//		System.out.println("합: "+sum);
//		System.out.println("평균: "+ (double)sum/cnt);
		 boolean run = true;

		 int studentNum = 0;
		 int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		 while(run) {
		 System.out.println("--------------------------------------------------------------");
		 System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		 System.out.println("--------------------------------------------------------------");
		 System.out.print("선택> ");

		 int selectNo = scanner.nextInt();

		 if(selectNo == 1) {
		 System.out.print("학생수> ");
		 studentNum = scanner.nextInt();
		 scores = new int[studentNum];
		 } else if(selectNo == 2) {
			 for(int i=0; i<scores.length; i++) {
			 System.out.print("scores[" + i + "]> ");
			 scores[i] = scanner.nextInt();
			 }
		 } else if(selectNo == 3) {
			 for(int i=0; i<scores.length; i++) {
			 System.out.println("scores[" + i + "]: " + scores[i]);
			 }
		 } else if(selectNo == 4) {
			 int max = 0;
			 int sum = 0;
			 double avg = 0;
			 for(int i= 0; i<scores.length; i++) {
			 max = (max<scores[i])? scores[i] : max;
			 sum += scores[i];
			 }
			 avg = (double) sum / studentNum;
			 System.out.println("최고 점수: " + max);
			 System.out.println("평균 점수: " + avg);
		 } else if(selectNo == 5) {
			 run = false;
		 }
		}

		 System.out.println("프로그램 종료");
		
	}

}
