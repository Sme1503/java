package sec03.exam01;

public class Car {
	
	
	
	String brand = "아반떼";
	String color;
	int cc;
	
	
	// 생성자
	public Car() {
		this("아반떼","흰색",1300);
		
	}
	
	Car(String b){
		brand = b;
		System.out.println("Car(String b) 실행");
	}
	
	Car(int a){
		cc = a;
		System.out.println("Car(int cc2) 실행");
	}
	
	Car(String b, String c, int cc2){
		
		brand = b;
		color = c;
		cc = cc2;
		System.out.println("Car(String b, String c, int cc2) 실행");
		
	}
	
	Car(String brand, int cc){
		this.brand = brand;
	}
	
	
	void test() {
		System.out.println("test() 실행");
	}
	
	void init() {
		color = "흰색";
		System.out.println("Car()" );
		
	}	
		
	void setBrand(String brand) {
		this.brand=brand;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
