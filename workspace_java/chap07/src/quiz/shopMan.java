package quiz;

public class shopMan extends Employee {
	
	@Override
	void Entertain() {
		// TODO Auto-generated method stub
		super.Entertain();
	}
	
	@Override
	void Study(String c) {	// 미래를 위한 공부
		
		System.out.println(c + "를 공부합니다.");
	}
	
	@Override
	void Sal() {
		// TODO Auto-generated method stub
		super.Sal();
	}
	
	void dailySettlement() {
		System.out.println("일일 정산을 합니다.");
	}
	
	void storeManagement() {
		System.out.println("매장을 관리합니다.");
	}
	
	public shopMan(String name) {
		super.name = name;
	}
}
