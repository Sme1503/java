package sec04.exam01.method;

public class CalcExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calc calc = new Calc();
		calc.powerOn();
		System.out.println("calc.isOn : "+calc.isOn);
		calc.powerOff();
		System.out.println("calc.isOn : "+calc.isOn);
		
		int b = 7;
		int a = calc.plus(b, 10);
		double c = calc.div(40, 0);
		
		System.out.println("plus : "+ a);
		System.out.println("div : "+ c);
		
		Calc[] d = new Calc[10];
		d[0] = new Calc();
		
		Calc[] e = new Calc[] {
			new Calc(), new Calc()
		};
		
		boolean d0 = d[0].isOn;
		
		int[] f = {1,2,3,4,5};
		int f1 = calc.sum1(f);
		System.out.println("f1 : "+f1);
		int f2 = calc.sum2(1,2,3,4,5);
		int f3 = calc.sum2(f);
		System.out.println("f2 : "+f2);
		System.out.println("f3 : "+f3);
		
		
	}

}
