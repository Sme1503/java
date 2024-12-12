package sec02.exam04;

public class OpExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = false;
		System.out.println("a : " + a);

		a = !a;
		System.out.println("a : " + a);

		double b = 7.0;
		System.out.println(b / 3);
//		System.out.println(b/0);

		int c = 9684321;
		int d = 5;
		System.out.println("몫 : " + (c / d));
		System.out.println("나머지 : " + (c % d));

		// q1. 1만원이 있고 4500원짜리 커피를 최대 몇잔 살 수 있고 남는 돈을 구하시오.
		int money = 10000;
		int coffee = 4500;
		int count = money / coffee;
		int mod = money % coffee;
		System.out.println();
		System.out.println("구매 가능 커피잔 : " + count);
		System.out.println("남는 돈 : " + mod);
		System.out.println();

		// q2. 올리브영 전품목 15%세일
		// q2-1. 꿀홍차(5000) 1개 구매시 가격
		int honeytea = 5000;
		double honeytea_sale = (double) honeytea * 0.85;
		System.out.println("구매 가격 : " + (int) honeytea_sale);

		// q2-2. 꿀홍차(5000)와 립스틱(30000)을 1개씩 구매시 가격
		int lipstick = 30000;
		double lipstick_sale = (double) lipstick * 0.85;
		double price = honeytea_sale + lipstick_sale;
		System.out.println("구매 가격 : " + (int) price);
		System.out.println();

		// q3. 7234원이 있을때, 5000, 1000, 500, 100, 50, 10, 1원으로 각각 최대 몇개까지로 표현하시오.
		int n = 7234;
		int a1 = n / 5000; // 1
		int a2 = n % 5000; // 2234

		int b1 = a2 / 1000; // 2
		int b2 = a2 % 1000; // 234

		int c1 = b2 / 500; // 0
		int c2 = b2 % 500; // 234

		int d1 = c2 / 100; // 2
		int d2 = c2 % 100; // 34

		int e1 = d2 / 50; // 0
		int e2 = d2 % 50; // 34

		int f1 = e2 / 10; // 3
		int f2 = e2 % 10; // 4

		int g1 = f2 / 1; // 4
		int g2 = f2 % 1; // 0
		System.out.printf("5000 = %d, 1000 = %d, 500 = %d, 100 = %d, 50 = %d, 10 = %d, 1 = %d ", a1, b1, c1, d1, e1, f1,
				g1);
		System.out.println();

		// 변수 재활용
		int n1 = 7234;
		int aa1 = n1 / 5000; // 1
		n1 = n1 % 5000; // 2234

		int bb1 = n1 / 1000; // 2
		n1 = n1 % 1000; // 234

		int cc1 = n1 / 500; // 0
		n1 = n1 % 500; // 234

		int dd1 = n1 / 100; // 2
		n1 = n1 % 100; // 34

		int ee1 = n1 / 50; // 0
		n1 = n1 % 50; // 34

		int ff1 = n1 / 10; // 3
		n1 = n1 % 10; // 4

		int gg1 = n1 / 1; // 4
		n1 = n1 % 1; // 0
		System.out.printf("5000 = %d, 1000 = %d, 500 = %d, 100 = %d, 50 = %d, 10 = %d, 1 = %d ", aa1, bb1, cc1, dd1,
				ee1, ff1, gg1);
		System.out.println();

		char ch = 'A';
		ch = (char) (ch + 1);
		System.out.println();
		System.out.println(ch);

		System.out.println("" + 3 + 3.0);

		String ch1 = "100";
		int c3 = Integer.parseInt(ch1);
		System.out.println(c3 + 3);

		boolean bool = 3 > 5;
		System.out.println(bool);

		System.out.println(1 == 1);
		System.out.println(1 == 1.0);
		System.out.println(1f == 1);
		System.out.println(0.1f == 0.1);
		System.out.println(0.1f == (float) 0.1);

		System.out.println('a' < 'b');
		System.out.println("av" == "ac");
		String s1 = "박상엽";
		String s2 = "박상엽";
		System.out.println(s1 == s2); // 문자열 비교는 == 사용금지.
		System.out.println(s1.equals(s2)); // equals함수 사용.

		int i1 = 87;
		System.out.println(i1 + "은 b학점인가? ");
		System.out.println((i1 >= 80) && (i1 < 90));
		System.out.println((i1 >= 80) || (i1 < 90));

		System.out.println(10 | 3);

		int k1 = 7;
		int k2 = 15;
		int k3 = 17;
		System.out.println("k3이 가장 큰 값인가? " + ((k1 < k3) && (k2 < k3)));

		int m1 = 5;
		m1 = m1 + 2;
		m1 += 2;

		int n11 = 10;
		n11 = n11 + 1;
		n11 += 1;
		n11++;

		n11 = n11 - 1;
		n11 -= 1;
		n11--;

		int n22 = 10;
		System.out.println("n22 : " + (++n22));
		System.out.println("n22 : " + (n22++));
		System.out.println(n22);

		int x = 1;
		int y = 1;
		int result1 = ++x + 10;
		int result2 = y++ + 10;
		System.out.println("" + result1 + result2);

		int z = 1;
		System.out.println(z++ + ++z);
		System.out.println(z);

		int score = 95;
		char grade = (score > 90) ? 'A' : 'B';
		
		// p150 확인 문제 q5
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2;
		int var4 = (int) (var3 * var2);
		System.out.println();
		System.out.println(var4);
		
		// p150 확인 문제 q6
		int value = 356;
		System.out.println((value/100)*100);
		System.out.println(value - (value % 100));
		
		// q7 v1/v2의 값을 소수점 3자리까지만 출력
		double v1 = 3200;
		double v2 = 457;
		int v3 = (int) (v1/v2*1000);
		System.out.println((double)v3/1000);
		System.out.println((double)((int)(v1/v2*1000))/1000);

		
	}

}
