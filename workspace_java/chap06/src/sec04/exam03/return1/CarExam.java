package sec04.exam03.return1;

public class CarExam {
	
	// main 메소드
	// 자바가 실행된다는 것은 
	// jvm에서 수행한다는 것
	// 자바가 자동 실행해주는 유일한 메소드
	// void main(String [])
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i<args.length; i++) {
			System.out.println("args[" + i +"]: " + args[i]);
		}
		
		Car car = new Car();
		System.out.println( car.speed);
		
		car.setSpeed(200);
		System.out.println(car.speed);
		
		car.setGas(11);
		boolean gasState = car.isLeftGas();
		
		if(gasState) {
			System.out.println("출발합니다.");
			car.run();
		}
		
		if(car.isLeftGas3()) {
			System.out.println("까스를 주입할 필요가 없습니다.");
		} else {
			System.out.println("까스를 주입하세요.");
		}
	}

}
