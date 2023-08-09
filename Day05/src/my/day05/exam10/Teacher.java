package my.day05.exam10;

import java.util.Scanner;

public class Teacher extends Person{

	private String tId;
	private String subject;
	
	
	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	//======================================================
	public void inputInfo() {
		super.inputInfo();
		
		System.out.println("교번을 입력하세요=> ");
		Scanner sc = new Scanner(System.in);
		String tid = sc.next();
		setId(tid);
		
		System.out.println("담당과목을 입력하세요=> ");
		String cn = sc.next();
		setSubject(cn);
	}
	
	public String setClassName() {
		return subject;
	}
	public void setClassName(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String personInfo() {
		String info = super.personInfo();
		info += "\n교번: "+tId+"\n담당과목: "+subject;
		return info;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return tId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		tId= id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
