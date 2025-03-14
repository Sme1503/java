package quiz;

public class CafeExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Barista barista = new Barista();
//		shopMan shopman = new shopMan();
		
		Employee e1 = new Barista("바리스타");
		Employee e2 = new shopMan("점원");
		Employee e3 = new Baker("제빵사");
		
		Welfare welfare = new Welfare();
		
		welfare.paySal(e1);
		welfare.paySal(e2);
		welfare.paySal(e3);
		System.out.println();
		
		welfare.makeStudy(e1);
		welfare.makeStudy(e2);
		welfare.makeStudy(e3);
		System.out.println();
		
		
	}

}
