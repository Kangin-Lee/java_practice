package my.day05.exam5;

public class AquaMan extends Human{
	int speed;
	
	@Override
	public String getInfo() {
		String str = super.getInfo();
		str += "\n스피드: "+speed;
		return str;
	}
	
	public String getInfo(int speed) {
		return super.getInfo()+"\n스피드: "+speed;
	}
}
