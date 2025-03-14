package sec05.exam01;

public class Car {
	String model;
	int speed;
	
	
	Car(String model) {
		this.model = model;
	}
	
	
	// 필드의 model출력
	void printModel() {
		System.out.println(this.model);
	}
	
	
}
