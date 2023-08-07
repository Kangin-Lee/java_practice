package ch01.sec09;

public class AICarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person1 hong = new Person1();//생성자 호출
		Car sportCar = new Car();
		Car sedanCar = new Car(1000, "black");
		
		System.out.println(hong.age);
		
//		sportCar.run(50);
//		sedanCar.run(5000);
		
		System.out.println(sedanCar.speed);
		System.out.println(sportCar.speed);
		System.out.println(sedanCar.color);
		System.out.println(sportCar.color);
		
		hong.eat();
		hong.smile();
		
	}

}
