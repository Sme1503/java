package sec04.exam04.overload;

public class Calc {

	int plus(int x, int y) {
		System.out.println(x+y);
		return x + y;
	}
	//위의 plus 메소드와 매개변수 타입이 같아서 오류
//	int plus(int y, int x) {
//		System.out.println(x+y);
//		return x + y;
//	}
	// 오버로딩
	// 1. 매개변수를 신경쓰지않고 비슷한 수행을 할 수 있게 해주는 기능
	// 2. 매개변수의 우선순위
	// 2-1. 정확히 동일한 타입
	// 2-2. 없으면 자동 형 변환으로 실행될 수 있는 타입 찾기
	// 3. 매개변수가 너무 많고 대부분이 기본값이 있는 경우 매개변수를 줄이는 목적으로도 사용함
	double plus(double x, double y) {
		System.out.println(x+y);
		return x + y;
	}
	
	double plus(int x, double y) {
		System.out.println(x+y);
		return x + y;
	}
	
	int plus(int x) {
		return x+x;
	}
	
	double avg(int x, int y) {
		double sum = plus(x,y);
		return sum / 2;
	
	}
	
	void execute() {
		double result = avg(7,10);
		println("실행결과: "+result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	void println(String message, int x) {
		System.out.println(message);
	}
	
	void println(int x, String message) {
		System.out.println(message);
	}
	
	void method1(String classdept, int classnum) {
		System.out.println(classdept + ", "+classnum);
	}
	
	void method2() {
		method1("천안", 1);
	}
}
