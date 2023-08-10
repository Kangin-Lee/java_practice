package my.day06.exam1;

public class Audio implements RemoteControl{

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오 전원을 킵니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 전원을 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else {
			this.volume = volume;
		}
		
		System.out.println("현재 오디오 볼륨: "+ this.volume);
		
	}
	
}
