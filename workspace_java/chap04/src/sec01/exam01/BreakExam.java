package sec01.exam01;

import java.util.Scanner;

public class BreakExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		while (true) {
			int num = (int) (Math.random() * 6) + 1;
			System.out.println(num);

			if (num == 6) {
				break;
			}
			cnt++;
		}

		System.out.println("게임 종료, 총 회수 : " + cnt);
		System.out.println();

		// 주사위 2개로 나올 수 있는 모든 조합 출력 2: 1,1 // 3: 1,2 2,1 // ...
		// 중복을 제거한 경우의 수 2의 경우 1가지, 3의 경우 1가지 ...
//		System.out.println("주사위 2개로 나올 수 있는 모든 조합");
//		for (int e = 1, j = 2; e <= 6; e++) {
//			System.out.print(j + "의 경우 : ");
//			if (j != 13) { // 합이 13이 아닐 경우
//
//				for (int g = 1; g <= 6; g++) {
//
//					if (e + g == 2 && j == 2) { // 2의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 3 && j == 3) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 4 && j == 4) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 5 && j == 5) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 6 && j == 6) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 7 && j == 7) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 8 && j == 8) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 9 && j == 9) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 10 && j == 10) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 11 && j == 11) { // 3의 경우
//						System.out.print(e + " " + g);
//					} else if (e + g == 12 && j == 12) { // 3의 경우
//						System.out.print(e + " " + g);
//					}
//				}
//
//			}
//			System.out.println();
//			j++;
//		}
		
		for(int e=1; e<=6; e++) {
			for(int g=1; g<=6; g++) {
				if(e+g==2) {
					System.out.print("2의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==3) {
					System.out.print("3의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==4) {
					System.out.print("4의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==5) {
					System.out.print("5의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==6) {
					System.out.print("6의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==7) {
					System.out.print("7의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==8) {
					System.out.print("8의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==9) {
					System.out.print("9의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==10) {
					System.out.print("10의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==11) {
					System.out.print("11의 경우 ");
					System.out.println(e + " " + g);
				}
				else if(e+g==12) {
					System.out.print("12의 경우 ");
					System.out.println(e + " " + g);
				}
				
			}
			System.out.println();
			
			
			
			
		}
		// 중복제거 --- e + g == g1 + e1 == 중복  1 2 == 2 1 == 중복 1 3 != 2 2 중복아님
		int e, g, e1, g1;
		cnt=0;
		for(int a=2;a<=12;a++) {
			for(e=1;e<=6;e++) {
					
			}
				
			for(g=1;g<=6;g++) {
					
			}
			
			for(e1=1;e1<=6;e++) {
				
			}
				
			for(g1=1;g1<=6;g++) {
					
			}
			
			if(e == e1 && g == g1) {	// 중복이 아니면 경우의 수 증가
				cnt++;
			}
			System.out.println(a + "의 경우: "+ cnt);
		}
		
		
		for(int i=0; i<5; i++) {
			System.out.println("i : " + i);
			
			for(int j=0; j<30; j++) {
				if(j>=2) {
					break;
				}
				
				System.out.println("j : "+j);
							
			}
			System.out.println();
		}
		System.out.println();
		
		int a = 0;
		boolean b = false;
		for(int i=0; i<5; i++) {
			
			System.out.println("i : " + i);
			
			for(int j=0; j<30; j++) {
				if(j>=2) {
					a =1;
					b = true;
					break;
				}
				
				System.out.println("j : "+j);
			
			}
			
			System.out.println();
			if(a==1) {
				break;
			}
			if(b) {
				break;
			}
		}
		System.out.println();
		
		for(int i = 1; i<=10; i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		System.out.println();
		
		cnt = 0;
		for(int i = 1; i<=10; i++) {
			if(i%2!=0) {
				cnt++;
				continue;
			}
			System.out.println(i);
		}
		System.out.println(cnt);
		System.out.println();
		
		// p183. q7	   예금액 음수 불가, 출금액 음수 불가, 잔고보다 큰 금액 불가
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		int i = 0, j = 0, k = 0;
		while(run) {
			System.out.println();
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println();
			System.out.print("선택> ");
			String input = sc.nextLine();
			
			if(input.equals("1")) {
				System.out.print("예금액> ");
				i = sc.nextInt();
				if(i<0) {
					System.out.print("예금액 음수 불가");
				}
				balance += i;
			}else if(input.equals("2")) {
				System.out.print("출금액> ");
				j = sc.nextInt();
				if(j<0 || balance < j) {
					System.out.print("출금액 음수 불가");
				}else {
					balance -= j;
				}
				
			}else if(input.equals("3")) {
				System.out.print("잔고> ");
				
				if(balance<0) {
					System.out.print("잔고 음수 불가");
				}
				else {
					System.out.print(balance);
				}
			}else if(input.equals("4")) {
				break;
			}
			
		}
		System.out.println("프로그램 종료");
	}

}
