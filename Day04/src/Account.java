
public class Account {
	
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	private int balance;
	
	private String ano;
	private String owner;
	
	public Account() {}
	
	public Account(int balance, String ano, String owner) {
		super();
		this.balance = balance;
		this.ano = ano;
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance<Account.MIN_BALANCE || balance>Account.MAX_BALANCE) {
			return;
		}
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
