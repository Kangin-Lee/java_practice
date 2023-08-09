package my.day05.exam3;

public class Computer extends Calculator{
	
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return r * r * Math.PI; 
	}
}
