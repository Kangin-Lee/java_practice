package ch01.sec09;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class EnumWeekTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Week today = null; //열거 타입 선언
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK); //일(1)~토(7)까지의 숫자 리턴
		
		switch(week){
			case 1:
				today = Week.SUNDAY;
				break;
			case 2:
				today = Week.MONDAY;
				break;
			case 3:
				today = Week.TUESDAY;
				break;
			case 4:
				today = Week.WEDNESDAY;
				break;
			case 5:
				today = Week.THURSDAY;
				break;
			case 6:
				today = Week.FRIDAY;
				break;
			case 7:
				today = Week.SATURDAY;
				break;
		}
		
		System.out.println("오늘 요일"+ today );
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.DAY_OF_MONTH);
		Date date = new Date();
//		int day = date.getDay();
		int day = cal.get(Calendar.DATE);
		System.out.println(year+"년 "+ (month+1)+"월 "+day+"일");
		
		
		if(today == Week.MONDAY) {
			System.out.println("맞음");
		}else
			System.out.println("아님");
		
		
		Week weeday = Week.valueOf("SUNDAY");
		Week weekday[] = Week.values();
		
		for(Week days : weekday) {
			System.out.println("zzz"+days);
		}
		
		
	}	
	
}
