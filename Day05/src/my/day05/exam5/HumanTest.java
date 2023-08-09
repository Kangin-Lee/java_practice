package my.day05.exam5;

public class HumanTest {

	public static void main(String[] args) {
		
		Human superman = new SuperMan(); //자동 형변환(업캐스팅) 휴먼이 슈퍼맨보다 크다.
		superman.name = "슈퍼맨";
		superman.height = 170;
		((SuperMan)superman).power = 50; //강제 형변환(다운캐스팅)
		
		String result = superman.getInfo();
		
		System.out.println("=========슈퍼맨 정보===========");
		System.out.println(result);
		
		//=================아쿠아맨============================
		
		Human aquaman = new AquaMan();
		aquaman.name = "아쿠아맨";
		aquaman.height= 180;
		((AquaMan)aquaman).speed = 100;
		
		String result1 = aquaman.getInfo();
		System.out.println("=========아쿠아맨 정보===========");
		System.out.println(result1);
		
	}

}
