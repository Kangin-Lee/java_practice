package my.day06.exam1;

public interface RemoteControl {
	// 구성요소
	// *상수필드*, *추상메소드*만 가질 수 있다.

	// 상수필드
	static final int MAX_VOLUME = 10;
	static final int MIN_VOLUME = 0;

	// 추상메소드 {}가 없는거, abstract 생략 가능
	void turnOn();

	abstract void turnOff();

	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		}else
			System.out.println("무음 해제합니다.");
	}
	
	//static 메소드
	
	static void changeBattery() {
		System.out.println("리모컨 건전지를 교환합니다.");
	}
}
