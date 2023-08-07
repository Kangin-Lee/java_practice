package ch01.sec09;

public class Calculator {
	
	int num1, num2;
	
	
	public Calculator() {
		
	}
	
	public Calculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	public int plus(int n1, int n2) {
		int sum = n1+n2;
		return sum;
	}
	
	public void minus(int n1, int n2) {
		System.out.println(n1-n2);
	}
	
	public int multi() {
		return num1 * num2;
	}
	
	
	public void methodInfo() {
		System.out.println("반환타입과 매개변수가 없는 메소드 입니다.");
	}
}
