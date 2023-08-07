package ch01.sec09;

public class arrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문자열 3개의 뱌열값을 저장하는 배열 생성
//		String names[] = {"김자바","홍길동","박길동"};
//		
//		String names2[] = null;
//		names2 = new String[] {"와우","자바","재미있다"};
//		
//		names2[0] = "박자바";
//		names2[1] = "홍길동";
//		names2[2] = "박길동";
		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1+"*"+num2 +" = "+ (num1*num2));
		
		
	}

}
