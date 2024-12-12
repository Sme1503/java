package quiz;

import java.util.Scanner;

public class CPService2 {

	// 2차원 배열 사용
	int chooseMenu;

	String[][] coffeeMenu = { { "에스프레소", "아이스 에스프레소" }, { "카페 아메리카노", "아이스 아메리카노" }, { "카페 라떼", "아이스 카페 라떼" },
			{ "카푸치노", "아이스 카푸치노" }, { "카페 모카", "아이스 카페 모카" }, { "카페 비엔나", "아이스 카페 비엔나" }, };

	int[] coffeePrice = { 5000, 6000, 7000, 8000, 5000, 5500 };

	Scanner sc = new Scanner(System.in);

	void run() {

		while (true) {
			System.out.println("1. 주문, 2. 종료");

			//this.chooseMenu = sc.nextInt();

//			if (this.chooseMenu == 2) {
//				System.out.println("종료합니다.");
//				break;
//			}
//			coffee1(this.chooseMenu);
			
			//int  i = coffee1(this.chooseMenu = sc.nextInt());
			if((coffee1(this.chooseMenu = sc.nextInt())) == 2){
				System.out.println("종료합니다.");
				break;
			}
			else if((coffee1(this.chooseMenu = sc.nextInt())) == 3){
				System.out.println("종료합니다.");
				break;
			}
			else if((coffee1(this.chooseMenu = sc.nextInt())) == 7){
				System.out.println("종료합니다.");
				break;
			}
				

		}
	}

	int coffee1(int i) {

		if (i == 1) {
			System.out.println("커피를 선택하시오.");

			// 메뉴와 가격 출력
			for (int j = 0; j < coffeeMenu.length + 1; j++) {

				if (j != 0) {
					System.out.print(", ");
				}
				if (j <= 5) {
					System.out.print((j + 1) + ". " + this.coffeeMenu[j][0] + " ");
					System.out.print(this.coffeePrice[j] + "원");
				}

				if (j == 6) {
					System.out.print((j + 1) + ". 종료");
				}

			}
			System.out.println();

			
			
			return coffee2(this.chooseMenu = sc.nextInt());
		}else {
			return i;
		}
		

	}

	int coffee2(int i) {

		int n;

		if (i <= 6 && i >= 1) {
			// System.out.println("aaaa");
			n = i;

			for (int j = 0; j < this.coffeeMenu[i - 1].length + 1; j++) {

				if (j != 0) {
					System.out.print(", ");
				}
				if (j <= 1) {
					System.out.print((j + 1) + ". " + this.coffeeMenu[i - 1][j]);
				}
				if (j == 1) {
					System.out.print(" (500원 추가)");
				}

				if (j == 2) {
					System.out.print((j + 1) + ". 종료");
				}
			}
			System.out.println();

			return coffee3(n, this.chooseMenu = sc.nextInt());
		} else if(i == 7) {
			return i;
		}
		
		return 0;
	}

	int coffee3(int i, int j) {

		if (j <= 3 && j >= 1) {
			if (j == 1) {
				System.out.println(
						"현재 선택한 커피는 " + this.coffeeMenu[i - 1][j - 1] + "이고 가격은 " + this.coffeePrice[i - 1] + "원입니다.");
			} else if (j == 2) {
				System.out.println("현재 선택한 커피는 " + this.coffeeMenu[i - 1][j - 1] + "이고 가격은 "
						+ (this.coffeePrice[i - 1] + 500) + "원입니다.");

			} else if (j == 3) {
				System.out.println("종료합니다.");
				return j;
			}
			System.out.println();

		}
		return 0;
	}
}
