package sec01.exam02;

public class TypeCastingExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2 + (3 * 4); // ()는 우선순위 연산자
		long b = (long) a; // ()는 형변환 연산자
		long c = a; // 작은 쪽에서 큰 쪽으로 변환할때는 생략가능
		long d = 3000000000L;
		int e = (int) d; // 큰 쪽에서 작은 쪽으로 변환할때는 생략불가능

		System.out.println("e : " + e);

		int g = 3;
		long h = 4L;
		long i = (long) g + h;

		long i2 = g + h;
		double j = 3.3;
		double k = (double) g + j;
		double k2 = g + j;
		System.out.println("(double) g : " + (double) g);

		int g2 = (int) j;
		System.out.println("(int) j : " + (int) j);

		double total = 4.3; // 회식비
		int count = 4; // 참석한 인원
		double aassad = (double) (total % count);
		System.out.println("값 : " + (int) (total / count));
		System.out.println("값 : " + total / count);
		System.out.println("값 : " + ((int) (total / count) +aassad));


		int a1 = 30;
		int b1 = 407;
		int c1 = 0;
		
		c1 = a1;
		a1 = b1;
		b1 = c1;
		
		System.out.println(a1); // 407
		System.out.println(b1); // 30
		System.out.println("");
		
		String a2 = "수박";
		String b2 = "볼링공";
		String c2 = "";

		c2 = a2;
		a2 = b2;
		b2 = c2;
		
		System.out.println(a2); // 볼링공
		System.out.println(b2); // 수박
		System.out.println("");

		

	}

}
