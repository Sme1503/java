package quiz;

import java.util.Scanner;

public class GugudanExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan gugu = new Gugudan();
		
		System.out.println("3");
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		gugu.print(a);
		System.out.println();
		
		System.out.println("3  6");
		gugu.print(3, 6);
		System.out.println();
		
		System.out.println("3  7");
		gugu.print2(3, 7);
		System.out.println();
		
		System.out.println("2  9");
		gugu.print3();
		System.out.println();
		
		System.out.println("5  9");
		gugu.print3(5);
		System.out.println();
	}

}
