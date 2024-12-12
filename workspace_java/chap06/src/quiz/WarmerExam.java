package quiz;

public class WarmerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Warmer warmer = new Warmer();
		
		System.out.println("전원 상태는 "+warmer.statePower);
		warmer.isOff();
		warmer.isOn();
		//System.out.println(warmer.statePower);
		System.out.println("저온 버튼 상태는 "+warmer.buttonHot1);
		warmer.buttonHot1On();
		System.out.println("저온 버튼 상태는 "+warmer.buttonHot1);
		warmer.stopAction();
		System.out.println("저온 버튼 상태는 "+warmer.buttonHot1);
		
		
		warmer.isOff();

		warmer.print();
		
	}

}
