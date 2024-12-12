package sec04.exam04.overload;

public class CalcExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc calc = new Calc();
		calc.execute();
		
		calc.plus(1, 5);
		calc.plus(1.0, 5);
		
		int a = 10;
		double b = 20.3;
		calc.plus(a, b);
		
		System.out.println("문자");
		System.out.println(1);
	}

}
