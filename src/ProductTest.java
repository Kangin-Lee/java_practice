
class Tv{
	
}

class Car{
	
}

class Product <K,M>{
		private K kind;
		private M model;
		
		//getter
		public K getKind() {
			return this.kind;
		}
		
		public M getModel() {
			return this.model;
		}
		
		//setter
		public void setKind(K k) {
			this.kind = k;
		}
		
		public void setModel(M m) {
			this.model = m;
		}
	}

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product<Tv, String> product1 = new Product<>();
		product1.setKind(new Tv());
		product1.setModel("스마트 티비");
		
		System.out.println("제품정보: "+ product1.getModel());
	}

}
