package my.day05.exam10;

public class Staff extends Person{

	private String dept;
	private String id;
	
	@Override
	public String getId() {
		return id;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setId(String id) {
		this.id = id;	
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
