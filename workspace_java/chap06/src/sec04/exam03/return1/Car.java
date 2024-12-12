package sec04.exam03.return1;

public class Car {
	int gas = 5;
	// 필드
	// 같은 말로 멤버 변수
	// 클래스를 생성(new하는 순간)과 함께 생성됨
	// 클래스 소멸(가비지 컬렉터 동작) 시까지 생존
	// 살아있는 동안 메모리를 차지하면서 계속 저장된 값이 유지
	// 가능하면 지역변수로 먼저 해결하는 것이 좋다
	// 클래스 자체에 값을 저장하거나
	// 메소드끼리 공유하는 목적으로 사용하거나 한다
	
	int speed;
	// 값을 선언하지 않은 경우
	// 0, false, null로 초기화된다
	
	void setSpeed(int s) {
		speed = s;
		System.out.println("속도를 "+speed+"로 바꿉니다.");
	}
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("까스가 없습니다.");
			return false;							// 리턴하면 메소드 종료
		}
		System.out.println("까스가 있습니다.");
		return true;
	}
	
	boolean isLeftGas3() {
		return gas!=0;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다. (까스잔량: " +gas+")");
				setSpeed(gas);
				gas -= 1;
			} else {
				System.out.println("멈춥니다. (까스잔량: "+ gas+")");
				return;
			}
		}
	}
}
