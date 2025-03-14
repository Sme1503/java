package quiz;

public class SmartPhone extends FeaturePhone {
	
	@Override
	void call(String number) {
		
		System.out.println(number + "로 전화 거는중");
	}
	
	@Override
	void receive() {
		
		System.out.println("전화 받았습니다.");
	}
	
	@Override
	void sendMessage(String number) {
		System.out.println(number + "로 문자를 보냅니다.");
	}
	
	void searchInternet() {
		System.out.println("검색합니다.");
	}
}
