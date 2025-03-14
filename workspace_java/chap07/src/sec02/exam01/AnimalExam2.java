package sec02.exam01;

public class AnimalExam2 {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.age = 3;
		Animal a1 = (Animal) cat;
		feed(a1);
	}

	static void feed(Animal animal) {
		System.out.println("                feed 실행");
		animal.eat();
		animal.sound();
		
		System.out.println("나이는 " + animal.age);
	}
}
