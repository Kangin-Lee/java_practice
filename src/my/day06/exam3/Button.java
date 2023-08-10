package my.day06.exam3;

public class Button {
	
	// 중첩 인터페이스
	static interface ClickListener{
		
		//추상 메소드
		void onClick();
	}
	
	//필드
	ClickListener clicklistner;
	
	//필드 초기화
	void setClicklistner(ClickListener clickListener) {
		this.clicklistner = clickListener;
	}
	
	void click() {
		this.clicklistner.onClick();
	}
}
