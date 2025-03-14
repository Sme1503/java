package sec01.exam03.override;

public class ComputerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calc calc = new Calc();
		int a = calc.plus(1, 5);
		System.out.println("calc.plus 결과 " + a);
		System.out.println();
		
		Computer computer = new Computer();
		int b = computer.plus(10, 50);
		System.out.println("computer.plus 결과: " + b);
		System.out.println();
		
		System.out.println("computer.areaCircle 결과: " + b);
		System.out.println();
		
		System.out.println(computer.areaCircle(10));
		System.out.println();
	}

}
