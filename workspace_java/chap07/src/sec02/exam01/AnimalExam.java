package sec02.exam01;

public class AnimalExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Animal의 eat()와 sound()만 알고 있는 상태
		Animal a1 = new Animal();
		a1.eat();
		a1.sound();
		
		Cat cat = new Cat();
		cat.eat();
		cat.push();
		
		Animal a2 = (Animal) cat;		// 자식이 부모가 될 때
		Animal a3 = cat;				// 형변환 연산자 생략 가능
										// 사실은 자식에서 부모만 빼온다
		a3.eat();
		a3.sound();
//		a3.push();
		
		Animal a4 = new Dog();
		a4.eat();
		a4.sound();
		
		catMom(cat);		// cat.age = 0
		cat.age = 7;		
		catMom(cat);		// cat.age = 7;
		Dog dog = new Dog();
//		catMom(dog);
		Animal a6 = (Animal) cat;
		System.out.println("a6 == cat : "+ (a6 == cat));
		
		feed(a6);
		feed(dog);
		feed(cat);
		
		a6.age = 3;
		feed(a6);
		
		Cat cat2 = new Cat();
		cat2.age = 5;			// super.age, cat.age
		feed(cat2);
		cat2.setAge(50);
		feed(cat2);
		
	}
	
	static void catMom(Cat cat) {
		cat.eat();
		cat.sound();
		cat.push();
		cat.sleep();
		System.out.println(cat.age);
	}
	
	static void feed(Animal animal) {
		System.out.println("                feed 실행");
		animal.eat();
		animal.sound();
		animal.sleep();
		
		System.out.println("나이는 " + animal.age);
	}

}


