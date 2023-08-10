package my.day06.exam1;

public class RemoteControlExample {

	public static void main(String[] args) {

		/////////////////////////////////
		RemoteControl rc = null; // TV
		RemoteControl rc2 = null; // Audio

		rc = new Television();// TV
		rc2 = new Audio(); // Audio
		/////////////////////////////////

		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();

		rc.turnOn();
		rc.setVolume(10);

		System.out.println("=======================================");

		rc2.turnOn();
		rc2.setVolume(5);
		rc2.turnOff();

		rc2.turnOn();
		rc2.setVolume(10);
		
		rc.setMute(true);
		rc.setMute(false);
		
		RemoteControl.changeBattery();
	}

}
