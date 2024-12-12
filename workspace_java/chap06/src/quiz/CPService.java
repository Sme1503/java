package quiz;

import java.util.Scanner;

public class CPService {

	// 커피 뽑아주는 기계

	// String coffee;
	int chooseMenu;
	String[] coffeeMenu = { "에스프레소", "카페 아메리카노", "카페 라떼", "카푸치노", "카페 모카", "카페 비엔나" };
	int[] coffeePrice = { 5000, 6000, 7000, 8000, 5000, 5500 };

	Scanner sc = new Scanner(System.in);

	// 커피 뽑기
	void run() {

		while (true) {

			System.out.println("1. 주문, 2. 종료");
			chooseMenu = sc.nextInt();

			if (this.chooseMenu < 3 && this.chooseMenu > 0) {
				if (this.chooseMenu == 1) {
					System.out.println("커피를 선택하시오.");
					// System.out.println("1. 에스프레소, 2. 카페 아메리카노, 3. 카페 라떼, 4. 카푸치노, 5. 카페 모카, 6. 카페
					// 비엔나");

					// 메뉴와 가격 출력
					for (int i = 0; i < coffeeMenu.length + 1; i++) {

						if (i != 0) {
							System.out.print(", ");
						}
						if(i<=5) {
							System.out.print((i + 1) + ". " + this.coffeeMenu[i] + " ");
						System.out.print(this.coffeePrice[i] + "원");
						}
						
						if ( i == 6) {
							System.out.print((i + 1) + ". 종료" );
						}
						
					}
					System.out.println();

					// 선택한 메뉴 입력
					chooseMenu = sc.nextInt();

					if (chooseMenu <= 7 && chooseMenu >= 1) {

						if (this.chooseMenu == 1) {

							// 상세 종류 출력
							System.out.println("1. 에스프레소, 2. 아이스 에스프레소 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 3 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 에스프레소이고 가격은 " + this.coffeePrice[0] + "원입니다.");

								} else if(this.chooseMenu == 2){
									System.out.println(
											"현재 선택한 커피는 아이스 에스프레소이고 가격은 " + (this.coffeePrice[0] + 500) + "원입니다.");

								} else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();
							} else {
								continue;
							}

						} else if (this.chooseMenu == 2) {

							System.out.println("1. 카페 아메리카노, 2. 아이스 아메리카노 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 3 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 아메리카노이고 가격은 " + this.coffeePrice[1] + "원입니다.");
								} else if(this.chooseMenu == 2) {
									System.out.println(
											"현재 선택한 커피는 아이스 아메리카노이고 가격은 " + (this.coffeePrice[1] + 500) + "원입니다.");
								} else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();
							} else {
								continue;
							}

						} else if (this.chooseMenu == 3) {

							System.out.println("1. 카페 라떼, 2. 아이스 카페 라떼 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 라떼이고 가격은 " + this.coffeePrice[2] + "원입니다.");

								} else if(this.chooseMenu == 2) {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 라떼이고 가격은 " + (this.coffeePrice[2] + 500) + "원입니다.");
								} else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();
							} else {
								continue;
							}

						} else if (this.chooseMenu == 4) {

							System.out.println("1. 카푸치노, 2. 아이스 카푸치노 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카푸치노이고 가격은 " + this.coffeePrice[3] + "원입니다.");
								} else if(this.chooseMenu == 2) {
									System.out.println(
											"현재 선택한 커피는 아이스 카푸치노이고 가격은 " + (this.coffeePrice[3] + 500) + "원입니다.");
								} else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();
							} else {
								continue;
							}

						} else if (this.chooseMenu == 5) {

							System.out.println("1. 카페 모카, 2. 아이스 카페 모카 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 모카이고 가격은 " + this.coffeePrice[4] + "원입니다.");
								} else if(this.chooseMenu == 2) {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 모카이고 가격은 " + (this.coffeePrice[4] + 500) + "원입니다.");
								} else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();

							} else {
								continue;
							}

						} else if (this.chooseMenu == 6) {

							System.out.println("1. 카페 비엔나, 2. 아이스 카페 비엔나 (500원 추가), 3. 종료 ");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 비엔나이고 가격은 " + this.coffeePrice[5] + "원입니다.");
								} else if(this.chooseMenu == 2) {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 비엔나이고 가격은 " + (this.coffeePrice[5] + 500) + "원입니다.");
								}
								else if(this.chooseMenu == 3) {
									System.out.println("종료합니다.");
									break;
								}
								System.out.println();
							} else {
								continue;
							}

						} else if (this.chooseMenu == 7) {
							System.out.println("종료합니다. ");
							System.out.println();
							break;
						} else {
							System.out.println("나오면 안되는 코드 ");
							continue;
						}
					} else {
						System.out.println("제대로 입력해라");
						System.out.println();
						continue;
					}
				} else {
					System.out.println("종료합니다.");
					break;
				}
			} else {
				continue;
			}

		}

	}

	// 중복 코드 제거용 함수
	// 3번째 선택
	void chooseCoffee3() {
		this.chooseMenu = sc.nextInt();
	}

	void chooseCoffee2() {
		this.chooseMenu = sc.nextInt();

		if (chooseMenu <= 6 && chooseMenu >= 1) {
			chooseCoffee3();
		} else {

			System.out.println("제대로 입력해라");
			System.out.println();

		}
	}

	void chooseCoffee1(int i) {

		this.chooseMenu = i;
		if (this.chooseMenu < 3 && this.chooseMenu > 0) {
			if (this.chooseMenu == 1) {
				System.out.println("커피를 선택하시오.");

				for (int j = 0; j < coffeeMenu.length; j++) {

					if (j != 0) {
						System.out.print(", ");
					}
					System.out.print((j + 1) + ". " + this.coffeeMenu[j] + " ");
					System.out.print(this.coffeePrice[j] + "원");

				}
				System.out.println();

				chooseCoffee2();

			} else {

			}
		}
	}

	void run2() {

		while (true) {

			System.out.println("1. 주문, 2. 종료");
			chooseMenu = sc.nextInt();

			chooseCoffee1(chooseMenu);

			if (this.chooseMenu < 3 && this.chooseMenu > 0) {
				if (this.chooseMenu == 1) {
					System.out.println("커피를 선택하시오.");
					// System.out.println("1. 에스프레소, 2. 카페 아메리카노, 3. 카페 라떼, 4. 카푸치노, 5. 카페 모카, 6. 카페
					// 비엔나");

					// 메뉴와 가격 출력
					for (int i = 0; i < coffeeMenu.length; i++) {

						if (i != 0) {
							System.out.print(", ");
						}
						System.out.print((i + 1) + ". " + this.coffeeMenu[i] + " ");
						System.out.print(this.coffeePrice[i] + "원");

					}
					System.out.println();

					// 선택한 메뉴 입력
					chooseMenu = sc.nextInt();

					if (chooseMenu <= 6 && chooseMenu >= 1) {

						if (this.chooseMenu == 1) {

							// 상세 종류 출력
							System.out.println("1. 에스프레소, 2. 아이스 에스프레소 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 에스프레소이고 가격은 " + this.coffeePrice[0] + "원입니다.");

								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 에스프레소이고 가격은 " + (this.coffeePrice[0] + 500) + "원입니다.");

								}
								System.out.println();
							} else {
								break;
							}

						} else if (this.chooseMenu == 2) {

							System.out.println("1. 카페 아메리카노, 2. 아이스 아메리카노 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 아메리카노이고 가격은 " + this.coffeePrice[1] + "원입니다.");

								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 아메리카노이고 가격은 " + (this.coffeePrice[1] + 500) + "원입니다.");

								}
								System.out.println();
							} else {
								break;
							}

						} else if (this.chooseMenu == 3) {

							System.out.println("1. 카페 라떼, 2. 아이스 카페 라떼 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 라떼이고 가격은 " + this.coffeePrice[2] + "원입니다.");

								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 라떼이고 가격은 " + (this.coffeePrice[2] + 500) + "원입니다.");

								}
								System.out.println();
							} else {
								break;
							}

						} else if (this.chooseMenu == 4) {

							System.out.println("1. 카푸치노, 2. 아이스 카푸치노 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카푸치노이고 가격은 " + this.coffeePrice[3] + "원입니다.");

								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 카푸치노이고 가격은 " + (this.coffeePrice[3] + 500) + "원입니다.");

								}
								System.out.println();
							} else {
								break;
							}

						} else if (this.chooseMenu == 5) {

							System.out.println("1. 카페 모카, 2. 아이스 카페 모카 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 모카이고 가격은 " + this.coffeePrice[4] + "원입니다.");
								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 모카이고 가격은 " + (this.coffeePrice[4] + 500) + "원입니다.");
								}
								System.out.println();

							} else {
								break;
							}

						} else if (this.chooseMenu == 6) {

							System.out.println("1. 카페 비엔나, 2. 아이스 카페 비엔나 (500원 추가)");
							chooseMenu = sc.nextInt();

							if (this.chooseMenu <= 2 && this.chooseMenu >= 1) {

								if (this.chooseMenu == 1) {
									System.out.println("현재 선택한 커피는 카페 비엔나이고 가격은 " + this.coffeePrice[5] + "원입니다.");
								} else {
									System.out.println(
											"현재 선택한 커피는 아이스 카페 비엔나이고 가격은 " + (this.coffeePrice[5] + 500) + "원입니다.");
								}
								System.out.println();
							} else {
								break;
							}

						} else {
							System.out.println("나오면 안되는 코드");
							System.out.println();
							break;
						}
					} else {
						System.out.println("제대로 입력해라");
						System.out.println();
						break;
					}
				} else {
					System.out.println("종료합니다.");
					break;
				}
			} else {
				continue;
			}

		}

	}
}
