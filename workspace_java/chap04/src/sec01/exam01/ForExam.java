package sec01.exam01;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;

		System.out.println(sum);

		sum = 0;
		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		System.out.println(sum);

		int i = 1;
		sum = 0;

		sum += i;
		i++;

		sum += i;
		i++;

		sum += i;
		i++;

		sum += i;
		i++;

		sum += i;
		i++;
		System.out.println(sum);

		int sum2 = 0;
		for (int e = 1; e <= 10; e++) {
			sum2 += e;
		}
		System.out.println(sum2);

		for (int e = 1; e <= 10; e += 1) {
			System.out.println(e);
		}

		sum2 = 0;
		for (int e = 1; e <= 100; e++) {
			sum2 += e;
			// System.out.println(sum2);
		}
		System.out.println(sum2);
		System.out.println();

		// q1. 10~1까지 출력
		for (int e = 10; e > 0; e--) {
			System.out.println(e);
		}
		System.out.println();

		// q2. 1~20까지 짝수만 출력
		for (int e = 1; e <= 20; e++) {
			if (e % 2 == 0) {
				System.out.println("짝수: " + e);
			}
//			else {
//				System.out.println("홀수: "+ e);
//			}
		}
		System.out.println();

		// q3. 1~20까지 3의 배수만 출력
		for (int e = 1; e <= 20; e++) {
			if (e % 3 == 0) {
				System.out.println("3의 배수: " + e);
			}
		}
		System.out.println();

		for (int e = 0; e <= 20; e += 3) {
			if (e > 0) {
				System.out.println("3의 배수: " + e);
			}
		}
		System.out.println();

		// q4. 1~5까지 모두 출력하면서 홀짝표시
		for (int e = 1; e <= 5; e++) {
			if (e % 2 == 0) {
				System.out.println("짝수: " + e);
			} else {
				System.out.println("홀수: " + e);
			}

			String ea = "홀수";
			if (e % 2 == 0) {
				ea = "짝수";
			}
			System.out.println(ea + ": " + e);

			String ae = (e % 2 == 0) ? "짝수" : "홀수";
			System.out.println(ae + ": " + e);

		}
		System.out.println();

		// q5. 1~20까지 홀수의 합
		int n = 0;
		for (int e = 1; e <= 20; e++) {
			if (e % 2 == 1) {
				n += e;
			}
		}
		System.out.println("홀수의 합: " + n);
		System.out.println();

		// q6. 1~20까지 홀수의 개수
		int cnt = 0;
		for (int e = 1; e <= 20; e++) {
			if (e % 2 == 1) {
				cnt += 1;
			}
		}
		System.out.println("홀수의 개수: " + cnt);
		System.out.println();

		// q7. 1~10까지 옆으로 3개씩 출력 ex) 1 2 3 /// 4 5 6 /// 7 8 9 /// 10
		for (int e = 1; e <= 3; e++) {
			System.out.print(e + " ");
		}
		System.out.println();
		for (int e = 4; e <= 6; e++) {
			System.out.print(e + " ");
		}
		System.out.println();
		for (int e = 7; e <= 9; e++) {
			System.out.print(e + " ");
		}
		System.out.println();
		for (int e = 10; e <= 10; e++) {
			System.out.print(e + " ");
		}
		System.out.println();
		System.out.println(); // 방법1

		for (int e = 1; e <= 10; e++) { // 방법2
			if (e <= 3) {
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}

//				if(e==3) { 
//					System.out.println(); 		// 이렇게도 가능
//				}

			} else if (e <= 6) {
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}

//				if(e==6) {
//					System.out.println();
//				}
			} else if (e <= 9) {
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}

//				if(e==9) {
//					System.out.println();
//				}
			} else {
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}
			}

//			System.out.println();
//			if(e>3 && e<=6) {
//				System.out.print(e + " ");
//			}

//			System.out.println(); 
//			if(e>6 && e<=9) { 
//				System.out.print(e + " "); 
//			}
//			System.out.println(); 
//			if(e>9) { 
//				System.out.print(e + " ");
//			}

		}

		System.out.println();
		System.out.println();

		for (int e = 1; e <= 10; e++) { // 방법3 switch 안에 switch
			switch (e) {
			case 1:
			case 2:
			case 3:
				System.out.print(e + " ");
				switch (e) {
				case 3:
					System.out.println();
				}
				break;
			case 4:
			case 5:
			case 6:
				System.out.print(e + " ");
				switch (e) {
				case 6:
					System.out.println();
				}
				break;
			case 7:
			case 8:
			case 9:
				System.out.print(e + " ");
				switch (e) {
				case 9:
					System.out.println();
				}
				break;
			case 10:
				System.out.print(e + " ");

				break;
			}
		}
		System.out.println();
		System.out.println();

		for (int e = 1; e <= 10; e++) { // 방법4 switch 안에 if
			switch (e) {
			case 1:
			case 2:
			case 3:
				System.out.print(e + " ");
				if (e == 3) {
					System.out.println();
				}
				break;
			case 4:
			case 5:
			case 6:
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}
				break;
			case 7:
			case 8:
			case 9:
				System.out.print(e + " ");
				switch (e) {
				case 9:
					System.out.println();
				}
				break;
			case 10:
				System.out.print(e + " ");
				if (e % 3 == 0) {
					System.out.println();
				}
				break;
			}
		}
		System.out.println();
		System.out.println();

		// q8. 구구단 2단 출력 ex) 2 x 1 = 2 /// 2 x 2 = 4 ...
		n = 2;
		sum = 0;
		for (int e = 1; e <= 9; e++) {
			sum = n * e;
			System.out.println(n + " x " + e + " = " + sum);
		}
		System.out.println();

		// q9. 1부터 입력받은 숫자까지의 수를 더하시오
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하시오: ");
		int input = sc.nextInt();

		sum = 0;
		for (int e = 1; e <= input; e++) {
			sum += e;
		}
		System.out.println("결과: " + sum);
		System.out.println();

		// q10. 구구단
		for (int e = 2; e <= 9; e++) {
			System.out.println(e + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.println(e + " x " + j + " = " + e * j);
			}
			System.out.println();
		}

		// q11. 구구단 한 줄 출력 후 다음 단 한 줄 출력
		for (int e = 2; e <= 9; e++) {
			System.out.println(e + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.print(e + " x " + j + " = " + e * j + "   ");
			}
			System.out.println();
		}
		System.out.println();

		// q12. 구구단 두 단씩 옆으로 출력
		for (int e = 2; e <= 9; e += 2) {

			System.out.println(e + "단          " + (e + 1) + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.print(e + " x " + j + " = " + e * j + "  ");
				if ((e + 1) != 10) {
//					System.out.print(e + " x " + j + " = "+ e*j + "  ");
					System.out.println((e + 1) + " x " + j + " = " + (e + 1) * j);
				}
			}
			System.out.println();
		}

		// q13. 구구단 세 단씩 옆으로 출력
		for (int e = 2; e <= 9; e += 3) {

			System.out.print(e + "단          ");
			System.out.print((e + 1) + "단        ");
			System.out.println((e + 2) + "단");

			for (int j = 1; j <= 9; j++) {
				System.out.print(e + " x " + j + " = " + e * j + "  ");
				if((e+2)==10) {
					System.out.println((e + 1) + " x " + j + " = " + (e + 1) * j + " ");
				}
				else {
					System.out.print((e + 1) + " x " + j + " = " + (e + 1) * j + " ");
					System.out.println((e + 2) + " x " + j + " = " + (e + 2) * j);
				}
			}
			System.out.println();
		}
		
		
		
		
 		//-------피라미드 자습----
		// *피라미드1 
		int pi = 1;
		for(int e = 1; e<=4; e++) {
			if(pi != 5 ) {
				for(int g= 1; g<=pi; g++) {
				System.out.print("*");
				
				}
			}
			pi++;
			System.out.println();
		}
		System.out.println();
		
		// *피라미드1 변수 사용 적게
		for(int e = 1; e<=4; e++) {
			for(int g= 1; g<=e; g++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// *피라미드2 *피라미드1의 역
		for(int e = 4; e>=1; e--) {
			for(int g= 1; g<=e; g++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// *피라미드2 *피라미드1의 역  다른 방법
		for(int e = 1; e<=4; e++) {
			for(int g= 4; g>=e; g--) {
				System.out.print("*");
				}
			System.out.println();
			}
		System.out.println();
		
		// *피라미드3 오른쪽 정렬
		for(int e = 1; e<=4; e++) {				// 전체 회수
			for(int j = 4; j>e; j--) {  		// 공백
				System.out.print(" ");
			}
			for(int g= 1; g<=e; g++) {			// *
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// *피라미드4 *피리미드3의 역			
		for(int e = 1; e<=4; e++) {				// 전체 회수
			for(int j = 1; j<e; j++) {  		// 공백
				System.out.print(" ");
			}
			for(int g= 4; g>=e; g--) {			// *
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
//		
		// *피라미드5 대칭피라미드 입력한 숫자크키의 피라미드  아직 안 품
//		int npi = sc.nextInt();
//		for(int e = 1; e<=npi; e++) {				// 크기
//			for(int j=(npi/2); j>e; j--) {			// 왼쪽 공백
//				System.out.println(" ");
//			}
//			for(int g=1; g<=e; g++) {				// *
//				System.out.print("*");
//			}
//			for(int k=(npi/2); k>e; k--) {			// 오른쪽 공백
//				System.out.println(" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
		
		
		// 피라미드 실습
		// 0단계
		for(int e = 1; e<=5; e++) {
			System.out.println("+");
		}
		System.out.println();
		
		// 1단계
		for(int e = 1; e<=5; e++) {
			System.out.print("+");
		}
		System.out.println();
		
		// 2단계
		for(int e = 1; e<3; e++) {
			for(int g = 1; g<=5; g++) {
				System.out.print("+");
			}
			System.out.println();
		}
		System.out.println();
		
		// 3단계
		for(int e=1; e<=5; e++) {
			System.out.print("+ ");
		}
		System.out.println();
		System.out.println();
		
		// 3.5단계
		for(int e=1; e<=5; e++) {
			for(int g=1; g<=e; g++) {
				System.out.print(e);
			}
			System.out.println();
		}
		System.out.println();
		
		// 4단계
		for(int e=1; e<=5; e++) {
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}
			System.out.println();
		}
		System.out.println();
		
		// 4.5단계
		for(int e=1; e<=5; e++) {
			for(int g=5; g>=e; g--) {
				System.out.print(e);
			}
			System.out.println();
		}
		System.out.println();
		
		// 5단계
		for(int e=1; e<=5; e++) {
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}
			for(int j=4; j>=e; j--) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		
		// 6단계
		for(int e=1; e<=5; e++) {
			for(int j=4; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}
			System.out.println();
		}
		System.out.println();
		
		// 7단계
		for(int e=1; e<=5; e++) {
			for(int j=4; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}								// 피라미드 왼쪽 반 출력
			for(int g=1; g<=e-1; g++) {		// 피라미드 오른쪽 반 출력
				System.out.print("+");
			}
			for(int k=4; k>=e; k--) {
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 8단계
		for(int e=1; e<=5; e++) {
			for(int j=4; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}								// 피라미드 왼쪽 반 출력
			for(int g=1; g<=e-1; g++) {		// 피라미드 오른쪽 반 출력
				System.out.print("+");
			}
			for(int k=4; k>=e; k--) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		
		// 9단계
		System.out.print("수를 입력하시오: ");
		int nsc = sc.nextInt();
		
		for(int e=1; e<=nsc; e++) {			// 전체 회수
			for(int j=nsc-1; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=e; g++) {
				System.out.print("+");
			}								// 피라미드 왼쪽 반 출력
			for(int g=1; g<=e-1; g++) {		// 피라미드 오른쪽 반 출력
				System.out.print("+");	
			}
			for(int k=nsc-1; k>=e; k--) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		
		// 10단계 9단계에서 for문 줄이기
		System.out.print("수를 입력하시오: ");
		nsc = sc.nextInt();
		
		for(int e=1; e<=nsc; e++) {			// 전체 회수
			for(int j=nsc-1; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=(e+(e-1)); g++) { // 홀수만큼 반복 // (2*e)-1
				System.out.print("+");
			}								// 피라미드 + 출력
			for(int k=nsc-1; k>=e; k--) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		
		// 11단계 10단계 다른 표현 - 외부 변수 사용
		System.out.print("수를 입력하시오: ");
		nsc = sc.nextInt();
		int nn = 0;
		
		for(int e=1; e<=nsc; e++) {			// 전체 회수
			for(int j=nsc-1; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=0; g<=nn; g++) {		// nn은 짝수, 반복회수는 홀수, +는 홀수만큼 출력
				System.out.print("+");
			}								// 피라미드 + 출력
			for(int k=nsc-1; k>=e; k--) {
				System.out.print("-");
			}
			System.out.println();
			nn+=2;							
			
		}
		System.out.println();
		
		// 12단계 11단계 다른 표현 - for문에 변수 2개
		System.out.print("수를 입력하시오: ");
		nsc = sc.nextInt();
		
		for(int e=1, n1=1; e<=nsc; e++) {			// e는 전체 회수, n1은 +반복회수
			for(int j=nsc-1; j>=e; j--) {
				System.out.print("-");
			}
			for(int g=1; g<=n1; g++) {		// n1은 홀수, 반복회수는 홀수, +는 홀수만큼 출력
				System.out.print("+");
			}								// 피라미드 + 출력
			for(int k=nsc-1; k>=e; k--) {
				System.out.print("-");
			}
			System.out.println();
									
			n1+=2;
		}
		System.out.println();
		
		// 주사위 2개로 나올 수 있는 모든 조합 출력 2: 1,1     // 3: 1,2 2,1 // ...
		// 중복을 제거한 경우의 수 ex) 2의 경우 1가지, 3의 경우 1가지 ...
		System.out.println("주사위 2개로 나올 수 있는 모든 조합");
		for(int e=1, j=2; e<=6; e++) {
			System.out.print(j+"의 경우 : ");
			for(int g =1; g<=6;g++) {
				if(j!=13) {								// 합이 13이 아닐 경우
					if(e+g==2 && j==2) {						// 2의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==3&& j==3) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==4&& j==4) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==5&& j==5) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==6&& j==6) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==7&& j==7) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==8&& j==8) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==9&& j==9) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==10&& j==10) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==11&& j==11) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
					else if(e+g==12&& j==12) {							// 3의 경우
						System.out.print(e +" "+ g);
					}
				}
				
				
			}
			System.out.println();
			j++;
		}
		
		
		
		
		
		
		
				
				
				
		
		
		
		
		// *****으로 모양만들기
//		
//		for(int e = 1; e<=4; e++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		for(int e = 1; e<=3; e++) {
//			System.out.print("*");
//		}		
//		System.out.println();
//
//		for(int e = 1; e<=2; e++) {
//			System.out.print("*");
//		}		
//		System.out.println();
//
//		for(int e = 1; e<=1; e++) {
//			System.out.print("*");
//		}		
//		System.out.println();
//		
//		for(int e = 1; e<=4;) {
//			System.out.print("*");
//			for(e =1;e<=3;) {
//				System.out.print("*");
//				for(e=1; e<=2;) {
//					System.out.print("*");
//					for(e=1; e<=1;) {
//						System.out.print("*");
//					}
//				}
//			}
//		}
//		
//		for(int e = 1; e<=1; e++) {
//			
//			for(int a = 1; a<=1; a++) {
//				
//				for(int b=1; b<=1; b++) {
//					
//					for(int c=1; c<=4; c++) {
//						System.out.print("*");
//					}
//					System.out.println();
//					System.out.print("*");
//				}
//				
//			}
//			
//			System.out.println();
//		}

	}

}
