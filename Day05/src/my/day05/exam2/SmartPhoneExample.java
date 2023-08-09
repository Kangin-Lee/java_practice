package my.day05.exam2;

public class SmartPhoneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		//부모로부터 상속받은 필드 읽기
		System.out.println("모델: "+ myPhone.model); //자식한테 감
		System.out.println("색상: "+ myPhone.color);
		
		//자식의 필드 읽기
		System.out.println("와이파이 상태: "+ myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동입니다.");
		myPhone.sendVoice("아~ 네 반갑습니다.");
		myPhone.hangUp();
		
		
		myPhone.setWifi(true);
		myPhone.internet();
	}
}
