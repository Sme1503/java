package quiz;

public class Baker extends Employee {

	@Override
	void Entertain() {
		// TODO Auto-generated method stub
		super.Entertain();
	}
	
	@Override
	void Study(String c) {	// 빵 공부 
		
		System.out.println(c + "를 공부합니다.");
	}
	
	@Override
	void Sal() {
		// TODO Auto-generated method stub
		super.Sal();
	}
	
	void makeBread(String b) {	// 빵 만들기
		System.out.println(b + "을 만듭니다.");
	}
	
	public Baker(String name) {
		super.name = name;
	}
}
