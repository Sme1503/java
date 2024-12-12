package sec01.exam01;

import java.util.Scanner;

public class WhileExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int i=1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		
//		while(true) {
//			System.out.print("메뉴를 고르시오 ");
//			System.out.println("1: 커피 2: 홍차 0: 종료");
//			int n = sc.nextInt();
//			
//			if(n==1) {
//				System.out.println("커피 드림");
//			}
//			else if(n==2) {
//				System.out.println("홍차 드림");
//			}
//			else if(n ==0) {
//				System.out.println("다음에 오세요 ");
//				break;
//			}
//			else {
//				System.out.println("메뉴를 고르시오 ");
//			}
//			
//			if(n !=0) {
//				if(n==1) {
//					System.out.println("커피 드림");
//				}
//				else if(n==2) {
//					System.out.println("홍차 드림");
//				}
//				else {
//					System.out.println("메뉴를 고르시오 ");
//				}
//			}else {
//				System.out.println("다음에 오세요 ");
//				break;
//			}
//		}
		
		System.out.print("메뉴를 고르시오 ");
		System.out.println("1: 커피 2: 홍차 0: 종료");
		int n = sc.nextInt();
		
		while(n != 0) {
			if(n==1) {
				System.out.println("커피 드림");
			}
			else if(n==2) {
				System.out.println("홍차 드림");
			}
			else {
				System.out.println("메뉴를 고르시오 ");
			}
			
			System.out.print("메뉴를 고르시오 ");
			System.out.println("1: 커피 2: 홍차 0: 종료");
			n = sc.nextInt();
		}
		System.out.println("다음에 오세요 ");
		
		
		do {
			System.out.print("메뉴를 고르시오 ");
			System.out.println("1: 커피 2: 홍차 0: 종료");
			n = sc.nextInt();
			if(n==1) {
				System.out.println("커피 드림");
			}
			else if(n==2) {
				System.out.println("홍차 드림");
			}
		}while(n != 0);
		System.out.println("다음에 오세요 ");
		
		String n1;
		do {
			System.out.print("메뉴를 고르시오 ");
			System.out.println("1: 커피 2: 홍차 x: 종료");
			n1 = sc.nextLine();
			if(n1.equals("1")) {
				System.out.println("커피 드림");
			}
			else if(n1.equals("2")) {
				System.out.println("홍차 드림");
			}
		}while(!n1.equals("x"));
		System.out.println("다음에 오세요 ");
		
	}

}
