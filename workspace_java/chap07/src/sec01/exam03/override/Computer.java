package sec01.exam03.override;

public class Computer extends Calc {
	
	@Override		// 부모에 해당 메소드가 똑같이 있는지 검사
	int plus(int x, int y) {
		System.out.println("문의하신 정답은 ");
		System.out.println(x + y + "입니다");
		return super.plus(x, y);
//		return x + y;
	}
	
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer의 areaCircle 실행");
		
		return Math.PI * r * r;
	}
	
	// 어노테이션: 클래스, 필드, 생성자, 메소드, 전달인자 등에 붙여서 사용가능
	// Retention(유지 기간): 소스(컴파일 되기 전까지), 런타임(실행하는 내내)
	// Reflection(반사): 어노테이션이 붙어있는 것 포함 안쪽의 모든 변수 타입이나 변수명, 메소드명 등등을 알 수 있는 기능
	// 그래서 어노테이션은 리플렉션을 통해 조작
	
	// final 
	// 변수에 붙는 경우: 변수의 내용변경 금지
	// 메소드에 붙는 경우: 오버라이드 금지
	// 클래스에 붙는 경우: 상속 금지
	
	// 접근 제한자: protected
	// 기본적으로 default처럼 같은 패키지에서만 사용 가능하지만, 나를 상속받은 클래스에서는 사용할 수 있게 제한
}
