package sec01.exam02;

public class VarTypeExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 127;
//		b = 128;
//		
//		byte b1 = 100;
//		byte b2 = 80;
//		b = b1 + b2;

		long l1 = 10;
		long l2 = 20L;
//		long l3 = 100000000000;
		long l4 = 100000000000L;

		char c1 = 'A';
		System.out.println("cl : " + c1);

		char c2 = 67;

		char c3 = 'a';
		System.out.println("c3-c1 : " + (c3 - c1));

		String s1 = "박상엽";
		System.out.println("s1 : " + s1);

		String s2 = "\"박상엽\"";
		System.out.println("s2 : " + s2);

		String s3 = "번호\t이름";
		String s4 = "번호2\t이름";
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);

		String s5 = "홍길동\n김자바";
		System.out.println("s5 : " + s5);

		System.out.print("1");
		System.out.print("2");
		System.out.println("3");
		System.out.print("1\r");
		System.out.print("1\n");
		System.out.print("1");

		double d = 0.1234567890123456789;
		System.out.println("\nd : " + d);
		// 더블은 소수점 16번째자리까지 정확함. 표시는 17번째자리까지

		float f = 0.1234567890123456789f;
		System.out.println("f : " + f);
		// 플로트는 소수점 7번째자리까지 정확함. 표시는 8번째자리까지
		
		boolean b1 = true;
		boolean b2 = false;
		
	}

}
