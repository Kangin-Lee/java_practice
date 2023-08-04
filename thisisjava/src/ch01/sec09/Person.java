package ch01.sec09;

public class Person {

	String name;
	int age;
	
	public void eat(String sr) {
		System.out.println(sr + "을 먹는다.");
	}
	
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person(); //힙에 할당
		System.out.println(person);
		
		person.age = 20;
		person.name = "홍길동";
		
		person.eat("고기");
		person.showInfo();
		
		Person person2 = new Person();
		
		System.out.println(person == person2?"같다":"다르다");
	}

}
