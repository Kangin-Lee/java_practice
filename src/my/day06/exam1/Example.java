package my.day06.exam1;

public class Example {
	
	public static void action(A a) {
//		a.method1();
		
		if(a instanceof C) {
			((C)a).method2();
		}else {
			a.method1();
		}
	}
	
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
	}

}

class A{
	public void method1() {
		System.out.println("A-method1()");
	}
}

class B extends A{
	
	@Override
	public void method1() {
		System.out.println("B-method1()");
	}
}

class C extends A{
	
	@Override
	public void method1() {
		System.out.println("C-method1()");
	}
	
	public void method2() {
		System.out.println("C-method2()");
	}
}