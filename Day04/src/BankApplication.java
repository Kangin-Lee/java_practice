import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	static ArrayList<Account> arrayAccount = new ArrayList<Account>();
	
	private static Scanner scan = new Scanner(System.in);
	
	public void newAccount(int balance, String ano, String owner) {
//		this.balance=balance;
//		this.ano = ano;
//		this.owner = owner;
	}
	
	public static void createAccount(){
		System.out.println("=============");
		System.out.println("계좌 생성");
		System.out.println("=============");
		
		System.out.print("계좌 번호: ");
		String ano = scan.next();
		
		System.out.print("계좌주: ");
		String owner = scan.next();
		
		System.out.print("초기 입금액: ");
		int balance = scan.nextInt();
		
		Account newAccount = new Account(balance, ano, owner);
		

		arrayAccount.add(newAccount);
		
		
		System.out.println("결과: 계좌가 생성되었습니다.");
		
	}
	
	
//	계좌목록======================================
	public static void accountList() {
		System.out.println("=============");
		System.out.println("계좌 목록");
		System.out.println("=============");
		
		for(Account account: arrayAccount) {
			System.out.print(account.getAno());
			System.out.print(" ");
			System.out.print(account.getOwner());
			System.out.print(" ");
			System.out.print(account.getBalance());
			System.out.println(" ");
		}
	}
	
	public static void deposit() {
		System.out.println("=============");
		System.out.println("예금");
		System.out.println("=============");
		
		System.out.print("계좌번호: ");
		String ano = scan.next();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.err.println("결과: 계좌가 없습니다."); 
			return;
		}
		
		System.out.print("예금액: ");
		int money = scan.nextInt();
		
		

		
		account.setBalance(account.getBalance()+money);
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	
	private static Account findAccount(String ano) {
		
//		Account account = null;
		
		for(Account ac : arrayAccount) {
			String dbAno = ac.getAno();
			if(dbAno.equals(ano)) {
				return ac;
			}
			
		}
		return null;
		
	}

	public static void withdraw() {
		System.out.println("=============");
		System.out.println("출금");
		System.out.println("=============");
		
		System.out.print("계좌번호: ");
		String ano = scan.next();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.err.println("결과: 계좌가 없습니다."); 
			return;
		}
		
		System.out.print("출금액: ");
		int money = scan.nextInt();
		
		account.setBalance(account.getBalance()-money);
		System.out.println("결과: 출금이 성공되었습니다.");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();

		
		
		while(true) {
			System.out.println("================================================");
			System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("================================================");
			System.out.print("선택 > " );
			
			int selectNo = scan.nextInt();
			
			if(selectNo==1) {
				createAccount();
			}else if (selectNo ==2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if (selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				System.out.println("종료되었습니다.");
				break;
			}
			
		}

	}

}

//class Account{
//
//}