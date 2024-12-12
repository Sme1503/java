package quiz;

import java.util.Scanner;

public class CPService3 {
	int chooseMenu;
	int sum, cnt1;
	
	
	//2차원 배열
	String[][] coffeeMenu = { { "에스프레소", "아이스 에스프레소" }, { "카페 아메리카노", "아이스 아메리카노" }, { "카페 라떼", "아이스 카페 라떼" },
			{ "카푸치노", "아이스 카푸치노" }, { "카페 모카", "아이스 카페 모카" }, { "카페 비엔나", "아이스 카페 비엔나" }, };

	int[] coffeePrice = { 5000, 6000, 7000, 8000, 5000, 5500 };
	int[][] cnt = new int [6][2];

	Scanner sc = new Scanner(System.in);

	void run() {
		cnt1 = 0;
		while (true) {
			System.out.println("1. 주문, 2. 종료");
			
			this.chooseMenu = sc.nextInt();
			if (this.chooseMenu < 3 && this.chooseMenu > 0) {
				if (this.chooseMenu == 1) {
					System.out.println("커피를 선택하시오.");

					for (int j = 0; j < coffeeMenu.length + 2; j++) {

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
						if (j == 7) {
							System.out.print((j + 1) + ". 처음으로");
						}

					}
					System.out.println();

					chooseMenu = sc.nextInt();
					int n = chooseMenu;

					if (chooseMenu <= 6 && chooseMenu >= 1) {
						for (int j = 0; j < this.coffeeMenu[chooseMenu - 1].length+2; j++) {

							if (j != 0) {
								System.out.print(", ");
							}
							if (j <= 1) {
								System.out.print((j + 1) + ". " + this.coffeeMenu[chooseMenu - 1][j]);
							}
							if (j == 1) {
								System.out.print(" (500원 추가)");
							}

							if (j == 2) {
								System.out.print((j + 1) + ". 종료");
							}
							if (j == 3) {
								System.out.print((j + 1) + ". 처음으로");
							}
						}
						System.out.println();

						chooseMenu = sc.nextInt();

						if (chooseMenu <= 3 && chooseMenu >= 1) {
							if (chooseMenu == 1) {
								cnt[n-1][chooseMenu-1]++;
								System.out.println("현재 선택한 " + this.coffeeMenu[n - 1][chooseMenu - 1] + "는 총 " + cnt[n-1][chooseMenu-1] +"잔이고 가격은 "
										+ this.coffeePrice[n - 1] + "원입니다.");
								sum += coffeePrice[n - 1];
								cnt1++;
							} else if (chooseMenu == 2) {
								cnt[n-1][chooseMenu-1]++;
								System.out.println("현재 선택한 " + this.coffeeMenu[n - 1][chooseMenu - 1] + "는 총 " + cnt[n-1][chooseMenu-1] + "잔이고 가격은 "
										+ (this.coffeePrice[n - 1] + 500) + "원입니다.");
								sum += coffeePrice[n - 1];
								cnt1++;

							} else if (chooseMenu == 3) {
								System.out.println("종료합니다.");
								break;
							} else if (chooseMenu == 4) {
								System.out.println("처음으로 돌아갑니다.");
								continue;
							}
							System.out.println();

						}
					} else if (chooseMenu == 7) {
						System.out.println("종료합니다.");						
						break;
					} else if (chooseMenu == 8) {
						System.out.println("처음으로 돌아갑니다.");						
						continue;
					} 
					

				}else if(chooseMenu == 2) {
					System.out.println("종료합니다.");
					break;
				}
			}
			
		}
		
		System.out.println("총 금액: " + sum + "원, "+cnt1+ "잔");
	}
}
