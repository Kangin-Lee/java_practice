import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Myfileresource {
	
	private String name;
	

	
	public Myfileresource(String name) {
		this.name = name;
		System.out.println("Myfileresource("+ name +") 열기");
	}
	
	public String read1() {
		System.out.println("Myfileresource("+ name +") 열기");
		return "100";
	}
	
	public String read2() {
		System.out.println("Myfileresource("+ name +") 읽기");
		return "abc";
	}
	
	public void close() {
		System.out.println("Myfileresource("+ name +") 닫기");
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("test.txt");
		FileInputStream fis=null;
		
		try {
			fis = new FileInputStream(file);
			
			int n;
			while((n=fis.read()) != 1) {
				System.out.println((char)n);
			}

		}catch(IOException io) {
			io.printStackTrace();
			
		}finally {
			fis.close();
		}
		
		Myfileresource myresource = new Myfileresource("test");
//		System.out.println(myresource.read1()); 
//		System.out.println(myresource.read2());
//		myresource.close();

	}

}
