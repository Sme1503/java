package sec01.exam02;

public class VariableUseExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;
		int minute = 5;

		System.out.println(hour + "시간 " + minute + "분");

		int totalMinute = (hour * 60) + minute;
		System.out.println("총 " + totalMinute + "분");

		int totalSecond = (hour * 60 * 60) + (minute * 60);
		System.out.println("총 " + totalSecond + "초");

		int x = 10;
		int y = 20;
		System.out.println("x의 값 : " + x);
		System.out.println("x+y의 값 : " + (x + y));

		x = y;
		System.out.println("x의 값 : " + x);

//		System.out.println("j의 값 : " + j);
		int j = 1;
		System.out.println("j의 값 : " + j);
		{
			System.out.println("j의 값 : " + j);
		}
		
		{
			int i = 0;
			System.out.println("i의 값 : " + i);
//			int i = 10; 같은 (지역) 변수명으로 또 선언불가
		}
		int i = 0;
		System.out.println("i의 값 : " + i);
	}

}
