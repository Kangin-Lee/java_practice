package my.day06.exam2;

public class ShopLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShop shop = new MyShop();
		
		shop.setTitle("My Shop");
		shop.genUser();
		shop.genProduct();
		shop.start();
	}

}
