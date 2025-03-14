package sec02.exam01;

public class Cat extends Animal {
	
	int age;  // 부모의 age와 다르다
//	age = 0;	// 행동은 무조건 메소드에서만 가능, 단, 선언과 동시에 하는 초기화는 필드에서도 가능
	
	@Override
	void sound() {
		System.out.println("미야옹~");
	}
	
	@Override
	void eat() {
		System.out.println("추루루루룹");
	}
	
	void push() {
		System.out.println("꾹꾹이 합니다");
	}
	
//	void sleep() {
//		
//	}
	
	void setAge(int a) {
		super.age = a;
	}
	
	void setAge() {
		this.age = super.age;
	}
}
