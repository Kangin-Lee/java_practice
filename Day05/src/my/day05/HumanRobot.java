package my.day05;

public class HumanRobot {

	public static void main(String[] args) {
		Human human = new Human();
		human.setAddr("대전 동구 용운동");
		human.setAge(20);
		human.setName("로봇1");
		
		System.out.println(human.toString()); 
		

	}

}
