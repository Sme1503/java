package quiz;

public class Human {

	void login(Function f) {
		
		if(f instanceof Naver) {
			Naver naver = (Naver) f;
		}
		
		
		
		if(f instanceof Daum) {
			Daum daum = (Daum) f;
		}
	}
}
