package ch01.sec09;

public class Car {
	
	int speed;
	String color;
	
	public Car() {
		//1. 생성자 할 일...>> 객체 생성시 호출
		//2. 멤버 변수의 초기화************
		speed = 10;
		color = "red";
	}
	
	public Car(int speed) {
		this(speed, "노랑");
	}
	
	//생성자 중복 정의
	//이름은 같고, 매개변수의 갯수, 종류가 다르다.
	public Car(int speed, String color) { //오버로딩
		this.speed = speed;
		this.color = color;
	}
	
	public void run(int speed) {
		speed += speed;
		
		System.out.println(speed+"속도로 달린다.");
	}
	
	public void stop(int speed) {
			speed -= speed;
		
		if(speed == 0) speed = 10;
		System.out.println(speed +"속도를 멈춘다.");
	}
}
