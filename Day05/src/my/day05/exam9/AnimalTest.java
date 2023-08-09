package my.day05.exam9;

public class AnimalTest {
	
	//매개변수의 다형성...
	static void animalsound(Animal animal) {
		animal.sound();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Dog();
		animal.name= "강아지";
		animal.sound();
		
		Cat cat = new Cat();
		cat.name = "야옹이";
		cat.sound();

		/////////////////////////////////
		animalsound(animal);
		animalsound(cat);
		/////////////////////////////////
	}

}
