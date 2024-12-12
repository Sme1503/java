package quiz;

public class Warmer {
	/*
	 * 기능 - 메소드로 만들기 전원 켜기, 끄기
	 * 저온 발열 (전원이 켜져있을 때 작동) 
	 * 고온 발열 (전원이 켜져있을 때 작동) 
	 * 현 상태 표시 - 전원 상태, 발열 상태 출력
	 * 정지
	 */

	boolean statePower = false; // 전원 상태  기본값은 꺼진 상태
	boolean buttonHot1 = false; // 저온 발열 기능 버튼
	boolean buttonHot2 = false; // 고온 발열 기능 버튼
	int stateHot; // 발열 상태

	// 전원 켜기
	boolean isOn() {
		return this.statePower = true;
	}

	// 전원 끄기
	void isOff() {
		this.statePower = false;
	}

	boolean buttonHot1On() {
		return this.buttonHot1 = true;
	}

	boolean buttonHot1Off() {
		return this.buttonHot1 = false;
	}

	boolean buttonHot2On() {
		return this.buttonHot2 = true;
	}

	boolean buttonHot2Off() {
		return this.buttonHot2 = false;
	}

	// 현 상태 표시
	void print() {
		if(lowHot() ) {
			System.out.println("전원이 켜져있습니다.");
			System.out.println("현재 저온기능이 켜져있습니다.");
		}
		else if(highHot() ) {
			System.out.println("전원이 켜져있습니다.");
			System.out.println("현재 고온기능이 켜져있습니다.");
		}
		else if (this.statePower == false) {
			System.out.println("전원이 꺼져있습니다.");
		}
		else {
			System.out.println("알 수 없음.");
		}

	}

	// 저온
	boolean lowHot() {

		if (isOn()) { // 전원이 켜져있으면
			if(buttonHot1On()) {
				this.stateHot = 1;
				
				return true;
			}
		}
		return false;
	}

	// 고온
	boolean highHot() {

		if (isOn()) { // 전원이 켜져있으면
			if(buttonHot2On()) {
				this.stateHot = 2;
				
				return true;
			}
		}
		return false;
	}
	
	void stopAction() {
		buttonHot1Off();
		buttonHot2Off();
	}

}
