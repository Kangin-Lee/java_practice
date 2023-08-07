package ch01.sec09;

import java.util.ArrayList;

public class arrayTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열 사이즈 변경 불가 해결
		//ArrayList 사용
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("자바");
		list.add("재미");
		list.add("있다");
		
		
		//for each문
		
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		for(String str:list) {
			System.out.println(str);
		}
		
		
	 }

}
