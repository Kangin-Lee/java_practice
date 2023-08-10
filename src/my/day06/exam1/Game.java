package my.day06.exam1;

public class Game {

	public static void main(String[] args) {
		
		
		무기 a무기 = null;
		부엌도구 b부엌도구 = null;
		
		a무기 = new 총();
		a무기.동작();
		
		a무기 = new 활();
		a무기.동작();

		a무기 = new 칼();
		a무기.동작();
		
		b부엌도구= new 칼();
		b부엌도구.동작();
		
	}

}
