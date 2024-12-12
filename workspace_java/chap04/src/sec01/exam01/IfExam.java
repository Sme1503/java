package sec01.exam01;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 63;
		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();

//		if (score >= 90) {
//			System.out.println("점수가 90보다 큽니다.");
//			System.out.println("등급은 A입니다.");
//		}
//
//		if (score < 90) {
//			System.out.println("점수가 90보다 작습니다.");
//			System.out.println("등급은 B입니다.");
//		}
//
//		if (score >= 90) {
//			System.out.println("점수가 90보다 큽니다.");
//			System.out.println("등급은 A입니다.");
//		} else {
//			System.out.println("점수가 90보다 작습니다.");
//			System.out.println("등급은 B입니다.");
//		}
//
//		if (score >= 90) {
//			System.out.println("점수가 90보다 큽니다.");
//			System.out.println("등급은 A입니다.");
//		} else if (score < 90 && score >= 80) {
//			System.out.println("점수가 90보다 작습니다.");
//			System.out.println("등급은 B입니다.");
//		} else if (score < 80 && score >= 70) {
//			System.out.println("점수가 80보다 작습니다.");
//			System.out.println("등급은 C입니다.");
//		} else {
//			System.out.println("점수가 70보다 작습니다.");
//			System.out.println("등급은 D입니다.");
//		}
//
////		if(1 == if(score == 93) { //if 조건문 안에 if 써보기.
////			return 0;
////		}) {
////			System.out.println("등급은 D입니다.");
////		}
//
//		// q1. z1이 x1과 y1사이에 있는지 확인
//		int x1 = 15;
//		int y1 = 20;
//		int z1 = 11;
//
//		if (x1 <= z1) {
//			if (y1 <= z1) {
//				System.out.println("z1이 가장 큼.");
//			} else {
//				System.out.println("z1이 x1과 y1 사이에 있음.");
//			}
//		} else {
//			System.out.println("z1이 가장 작음.");
//		}
//
//		int x2 = 4;
//
//		if ((x2 % 2) == 0) {
//			System.out.println(x2 + ": 짝수");
//		} else {
//			System.out.println(x2 + ": 홀수");
//		}
//
//		// q2. 어제 온도가 -3도였을 때, 오늘 온도(입력)가 영하인지 영상인지 확인
//		// 영상이 x도 입니다. 어제보다 온도가 낮습니다. 높습니다. 어제보다 x도 높습니다.
//		int ytemp = -3;
//		System.out.println();
//		System.out.print("온도를 입력하시오: ");
//		int temp = sc.nextInt();
//
//		if (temp >= 0) {
//			System.out.println("영상입니다.");
//			System.out.println("영상" + temp + "도 입니다.");
//		} else {
//			System.out.println("영하입니다.");
//			System.out.println("영하" + temp + "도 입니다.");
//		}
//		if (temp > ytemp) {
//			System.out.println("어제보다 온도가 높습니다.");
//			System.out.println("어제보다 " + (temp - ytemp) + "도 높습니다.");
//		} else {
//			System.out.println("어제보다 온도가 낮습니다.");
//			System.out.println("어제보다 " + (ytemp - temp) + "도 낮습니다.");
//		}
//
//		// q3. 어떤 수가 있을 때, 입력한 수는 100보다 큰/같은/작은 수이며 양수이고 홀수/짝수입니다. 출력
//		System.out.println();
//		System.out.print("수를 입력하시오: ");
//		int n = sc.nextInt();
//
//		if (n >= 0) { // 양수인지 확인
//			if (n > 100) { // 100보다 크다.
//				if ((n % 2) == 0) {
//					System.out.println("입력한 수는 100보다 큰 수이며 양수이고 짝수입니다.");
//				} else {
//					System.out.println("입력한 수는 100보다 큰 수이며 양수이고 홀수입니다.");
//				}
//			} else if (n == 100) { // 100과 같다.
//				if ((n % 2) == 0) {
//					System.out.println("입력한 수는 100과 같은 수이며 양수이고 짝수입니다.");
//				} else {
//					System.out.println("입력한 수는 100과 같은 수이며 양수이고 홀수입니다.");
//				}
//			} else { // 100보다 작다.
//				if ((n % 2) == 0) {
//					System.out.println("입력한 수는 100보다 작은 수이며 양수이고 짝수입니다.");
//				} else {
//					System.out.println("입력한 수는 100보다 작은 수이며 양수이고 홀수입니다.");
//				}
//			}
//		} else {
//			System.out.println("입력한 수는 음수입니다.");
//		}
//
//		// q4. a,b 두 수가 있을때 둘 중에 큰 값 출력
//		System.out.println();
//		System.out.print("두 수를 입력하시오: ");
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//
//		if (a > b) {
//			System.out.println("a가 b보다 크다 " + a);
//		} else if (a == b) {
//			System.out.println("a와 b는 같다");
//		} else {
//			System.out.println("b가 a보다 크다 " + b);
//		}
//
//		// q5. 숫자가 1일 때, "일", 2일 때, "이", 3일 때, "삼", 다른 수일 때 "그 외" 출력
//		System.out.println();
//		System.out.print("수를 입력하시오: ");
//		int n1 = sc.nextInt();
//		if (n1 == 1) {
//			System.out.println("일");
//		} else if (n1 == 2) {
//			System.out.println("이");
//		} else if (n1 == 3) {
//			System.out.println("삼");
//		} else {
//			System.out.println("그 외");
//		}

		// q6. 월에 따라서 사계절을 출력. 봄:3,4,5 여름:6,7,8 가을:9,10,11 겨울:12,1,2
//		System.out.println();
//		System.out.print("월을 입력하시오: ");
//
//		int s = sc.nextInt();
//
//		if (s >= 1 && s <= 12) {
//			if (s == 3 || s == 4 || s == 5) {
//				System.out.println("봄");
//			} else if (s == 6 || s == 7 || s == 8) {
//				System.out.println("여름");
//			} else if ((s == 9 || s == 10 || s == 11)) {
//				System.out.println("가을");
//			} else if (s == 12 || s == 1 || s == 2) {
//				System.out.println("겨울");
//			}
//		} else {
//			System.out.println("1-12 사이의 수를 입력하시오");
//		}

//		// q7. 두자리 정수의 10의 자리, 1의 자리 숫자가 같은지 출력
//		System.out.println();
//		System.out.print("수를 입력하시오: ");
//
//		int n2 = sc.nextInt();
//
//		if ((n2 / 10) == (n2 % 10)) {
//			System.out.println("10의 자리와 1의 자리 숫자가 같음 " + n2);
//		} else {
//			System.out.println("10의 자리와 1의 자리 숫자가 다름 " + n2);
//		}

		// q8. 사각형의 한쪽 모서리: xa = 10, ya = 20 다른쪽 모서리: xb = 90, yb = 120일 때, 새로운 점:
		// xc, yc가 사각형에 포함되는지 출력
		int xa = 10;
		int ya = 20;
		int xb = 90;
		int yb = 120;

		System.out.println();
		System.out.print("좌표를 입력하시오: ");

//		int xc = sc.nextInt();
//		int yc = sc.nextInt();

//		if ((xc - xa) <= (xb - xa) && (xb - xc) <= (xb - xa)) { // xc가 범위안에 있을 때
//			if ((yc - ya) <= (yb - ya) && (yb - yc) <= (yb - ya)) {
//				System.out.println("xc, yc는 사각형에 포함됨.");
//			} else {
//				System.out.println("xc, yc는 사각형에 포함되지않음.");
//			}
//		} else if ((yc - ya) <= (yb - ya) && (yb - yc) <= (yb - ya)) { // yc가 범위안에 있을 때
//			if ((xc - xa) <= (xb - xa) && (xb - xc) <= (xb - xa)) {
//				System.out.println("xc, yc는 사각형에 포함됨.");
//			} else {
//				System.out.println("xc, yc는 사각형에 포함되지않음.");
//			}
//		} else {
//			System.out.println("xc, yc는 사각형에 포함되지않음.");
//		}

//		if ( ((xa - xc) >=(xb - xc)) && ( (ya- yc) >= (yb - yc)) ) {
//			System.out.print("xc, yc는 사각형에 포함됨.");
//		} else {
//			System.out.print("xc, yc는 사각형에 포함되지않음.");
//		}

//		if (((xa - xc) >= (xb - xc)) && ((ya - yc) >= (yb - yc))) {
//			System.out.print("xc, yc는 사각형에 포함됨.");
//		} else {
//			System.out.print("xc, yc는 사각형에 포함되지않음.");
//		}

//		if (xc >= xa && xc <= xb) {
//			if (yc >= ya && yc <= yb) {
//				System.out.println("xc, yc는 사각형에 포함됨.");
//			} else {
//				System.out.println("xc, yc는 사각형에 포함되지않음.");
//			}
//		} else {
//			System.out.println("xc, yc는 사각형에 포함되지않음.");
//		}

		double rand = Math.random();
		System.out.println();
		System.out.println("rand : " + rand);

		double rand2 = Math.random() * (5 + 1);
		int rand3 = (int) rand2;
		int rand4 = rand3 + 1;
		System.out.println("\n주사위 : " + rand4);

		int rnd1 = (int) (Math.random() * 60000);
		int rnd2 = rnd1 % 6;
		int rnd3 = rnd2 + 1;

		// q9. 가위바위보 게임만들기
		int rock = 1;
		int sissors = 2;
		int paper = 3;

		int input;

//		System.out.println();
//		System.out.print("가위바위보 중에 하나를 입력하시오: (1은 바위, 2는 가위, 3은 보) ");
//
//		input = sc.nextInt();
//		double rd = (int) (Math.random() * 3) + 1;	// 1~3중에 하나 생성
//		
//		if (input >= 1 && input <= 3) {
//			if (input == rock) { 					// 내가 바위일 때
//				if (rd == rock) { 					// 컴퓨터는 바위
//					System.out.println("비김");
//				} else if (rd == sissors) { 		// 컴퓨터는 가위
//					System.out.println("이김");
//				} else { 							// 컴퓨터는 보
//					System.out.println("짐");
//				}
//			} else if (input == sissors) { 			// 내가 가위일 때
//				if (rd == rock) { 					// 컴퓨터는 바위
//					System.out.println("짐");
//				} else if (rd == sissors) { 		// 컴퓨터는 가위
//					System.out.println("비김");
//				} else { 							// 컴퓨터는 보
//					System.out.println("이김");
//				}
//			} else {								// 내가 보일 때
//				if(rd == rock) {					// 컴퓨터는 바위
//					System.out.println("이김");
//				} else if(rd == sissors) {			// 컴퓨터는 가위
//					System.out.println("짐");
//				} else {							// 컴퓨터는 보
//					System.out.println("비김");
//				}
//			}
//		} else {
//			System.out.println("1 ~ 3 중에서 입력하시오 "); // 범위에 없는 숫자를 입력할 경우
//		} 											// 입력한 숫자로 하는 가위바위보
//		
//		String rock1 = "바위";
//		String sissors1 = "가위";
//		String paper1 = "보";
//		
//		System.out.println();
//		System.out.print("가위바위보 중에 하나를 입력하시오: ");
//		
//		String input1 = sc.nextLine();
//		int rd = (int) (Math.random() * 3) + 1;	// 1~3중에 하나 생성
//		
//		if(input1.equals(rock1)) {				// 내가 바위일 때
//			if (rd == rock) { 					// 컴퓨터는 바위
//				System.out.println("비김");
//			} else if (rd == sissors) { 		// 컴퓨터는 가위
//				System.out.println("이김");
//			} else { 							// 컴퓨터는 보
//				System.out.println("짐");
//			} 
//		} else if(input1.equals(sissors1)) { 	// 내가 가위일 때	
//			if (rd == rock) { 					// 컴퓨터는 바위
//				System.out.println("짐");
//			} else if (rd == sissors) { 		// 컴퓨터는 가위
//				System.out.println("비김");
//			} else { 							// 컴퓨터는 보
//				System.out.println("이김");
//			}
//		} else if(input1.equals(paper1)) {		// 내가 보일 때
//			if(rd == rock) {					// 컴퓨터는 바위
//				System.out.println("이김");
//			} else if(rd == sissors) {			// 컴퓨터는 가위
//				System.out.println("짐");
//			} else {							// 컴퓨터는 보
//				System.out.println("비김");
//			}
//		} else {
//			System.out.println("가위바위보 중에 하나를 입력하시오"); // 다른 문자를 입력할 경우
//		}										// 입력한 문자로 하는 가위바위보

		int num = 3;

		switch (num) {
		case 1:
			System.out.println("1번이 나왔습니다." + num);
			break;
		case 2:
			System.out.println("2번이 나왔습니다." + num);
			break;
		case 3:
			System.out.println("3번이 나왔습니다." + num);
			// break;
		default:
			System.out.println("4번이 나왔습니다." + num);
			break;
		}

		int month = 11;
		switch (month) {
		case 1:
			System.out.println("겨울");
			break;
		case 11:
			System.out.println("가을");
			break;
		default:
			break;
		}

		// q10. 통장 잔액이 1만원있을 때 출금액을 입력받아서
		// "잔액이 부족합니다.", "얼마 출금했고 얼마 남았습니다.", "정확히 입력해주세요" 출력
		int m1 = 10000;
		System.out.println("\n출금할 금액을 입력하시오: ");
		int c1 = sc.nextInt();

		if (c1 >= 0) {
			if (m1 < c1) {
				System.out.println("잔액이 부족합니다.");
			} else if (m1 >= c1) {
				System.out.println(c1 + "원 출금했고 " + (m1 - c1) + "원 남았습니다.");
			}
		} else {
			System.out.println("정확히 입력해주세요.");
		}

	}

}
