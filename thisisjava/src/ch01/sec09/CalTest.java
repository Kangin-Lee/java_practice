package ch01.sec09;

public class CalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator(200, 300);
		
		
		//메소드 호출
		int cresult = cal1.plus(40, 50);
		System.out.println("더하기: "+cresult);
		
		//빼기
		cal1.minus(40, 50);
		
		//곱하기
		System.out.println(cal2.multi());
		
		//메소드 정보 출력하는 메소드 호출
		cal1.methodInfo();
	}

}
