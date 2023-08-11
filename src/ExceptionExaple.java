
public class ExceptionExaple {

	static void printLength(String data) throws Exception{
		
			int result = data.length();
			System.out.println("문자 수: " + result);
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String 클래스가 존재합니다.");
			
		

			//e.printStackTrace();
			System.out.println("널문자가 전달되었다.");
		

		
			System.out.println("[마무리 실행]");
		

	}

	public static void main(String[] args)  throws Exception {
		printLength("ThisIsJava !!");
		printLength(null);
		System.out.println("프로그램 종료");
	}

}
