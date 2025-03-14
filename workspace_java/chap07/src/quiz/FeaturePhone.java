package quiz;

public class FeaturePhone extends Phone {
	
	@Override
	void call(String number) {
		
		System.out.println(number + "로 전화 거는중");
	}
	
	@Override
	void receive() {
		
		System.out.println("전화 받았습니다.");
	}
	
	void sendMessage(String number) {
		System.out.println(number + "로 문자를 보냅니다.");
	}
}
