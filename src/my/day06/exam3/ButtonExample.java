package my.day06.exam3;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btnOk = new Button();
		
		class OKListener implements Button.ClickListener{

			@Override
			public void onClick() {
				System.out.println("OK 버튼을 클릭했습니다.");
				
			}
			
		}
		btnOk.setClicklistner(new OKListener());
		
		btnOk.click();
		
		Button btncancel = new Button();
		
		class CancelListener implements Button.ClickListener{

			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
				
			}
			
		}
		btncancel.setClicklistner(new CancelListener());
		btncancel.click();
	}

}
