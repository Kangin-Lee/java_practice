package my.day05.exam2;

public class Phone {
	public String model;
	public String color;
	
//	public Phone() {
//		System.out.println("이거 먼저 실행");
//	}
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("기본 말고 이거 실행"+ model+color);
	}
	
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기: "+message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: "+message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
