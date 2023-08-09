package my.day05.exam9;

public abstract class Animal { 
	//추상클래스: 객체를 생성하지 못함 >> new 생성하지 못한다는 뜻
	// 적어도 1개 이상의 추상 메소드를 포함해야한다.
	
	String name;
	
	abstract void sound();
	
	public String getName() {
		return name;
	}

}
