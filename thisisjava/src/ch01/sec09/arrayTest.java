package ch01.sec09;

public class arrayTest {

	public static void main(String[] args) {
		// 배열을 이용해서 30개의 정수를 저장하고, 평균값을 구하는 프로그램 작성
		
		// 1. 배열 선언
		int scores[];
		
		//2. 배열 초기화
		scores = new int[10];
		
		
		// 3. 명시적 초기화
		scores[0] = 83;
		scores[1] = 90;
		
		// 4. 배열 선언과 초기화 동시
		int scores1[] = {83, 90, 70, 60, 50, 70, 90, 100, 99, 70};
		int sum = 0;
		
		for(int i = 0; i < scores1.length; i++) {
			sum += scores1[i];
			System.out.print(scores1[i]+" ");
			
		}
		
		System.out.println();
		
		System.out.println("평균: "+sum / scores1.length);
		
		
		scores1[4] = 90;
		sum = 0;
		for(int i = 0; i < scores1.length; i++) {
			sum += scores1[i];
			System.out.print(scores1[i]+" ");
			
		}
		
		
		System.out.println();
		
		System.out.println("평균: "+ sum / scores1.length);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
