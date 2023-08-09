package my.day05.exam10;

import java.util.Scanner;

public abstract class Person {
	private String name;
	private int id;
	
	//추상 메소드 정의
	public abstract String getId();
	public abstract void setId(String id);
	
	//기본 생성자
	public Person() {}
	
	//인자 생성자
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void inputInfo() {
		System.out.println("이름을 입력하세요 => ");
		Scanner scan =new Scanner(System.in);
		String nm = scan.next();
		name = nm;
	}
	
	public String personInfo() {
		String info="이름: "+name;
		return info;
	}
	
	public void printAll() {
		System.out.println(this.personInfo());
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
