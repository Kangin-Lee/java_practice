
public class User {
	
	//필드
	private String userid;
	private String username;
	private String userassword;
	private int userage;
	private String useremail;
	
	//생성자
	public User(String userid, String username, String userassword, int userage, String useremail) {
		super();
		this.userid = userid;
		this.username = username;
		this.userassword = userassword;
		this.userage = userage;
		this.useremail = useremail;
	}
	
	//getter/setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserassword() {
		return userassword;
	}
	public void setUserassword(String userassword) {
		this.userassword = userassword;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	
}
