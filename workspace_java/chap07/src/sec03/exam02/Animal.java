package sec03.exam02;

public abstract class Animal {

	String kind;
	
	void breathe() {
		System.out.println("숨숴");
	}
	
	// 추상 메소드
	// abstract 키워드가 붙은 메소드
	// 실행 블럭 {}이 있으면 안된다.
	// 나는 구현하지않는다.
	// 대신 나를 상속받은 자식이 꼭 구현해야 한다.
	// abstract와 final, private는 같이 사용할 수 없다.
	abstract void sound();
	
	Animal(String name){
		
	}
	
	Animal() {
		
	}
}
