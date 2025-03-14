package quiz;

public class Barista extends Employee {
	
	@Override
	void Entertain() {
		// TODO Auto-generated method stub
		super.Entertain();
	}
	
	@Override
	void Study(String c) {	// 커피 공부
		System.out.println(c + "를 공부합니다.");
	}
	
	@Override
	void Sal() {
		// TODO Auto-generated method stub
		super.Sal();
	}
	
	void makeCoffee(String c) {	// 커피 만들기
		System.out.println(c + "를 만듭니다.");
	}
	
	void dishWashing() {
		System.out.println("설거지를 합니다.");
	}
	
	void bookKeeping() {
		System.out.println("장부를 작성합니다.");
	}
	
	public Barista(String name) {
		this.name = name;
	}
}
