package my.day05.exam8;

public class DriverExample {

	public static void main(String[] args) {
		// Driver  객체 생성
		Driver driver = new Driver();
		
		//매개값으로 Bus객체를 제공하고 driver()메소드 호출
		Bus bus = new Bus();
		driver.drive(bus);
		
		//매개값으로 Taxi 객체를 젝ㅇ하고 driver()메소드 호출ㄴ
		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}

}
