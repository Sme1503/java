package quiz;

public class Gugudan {

	// 한단 출력
	void print(int x) {
		for(int i=1; i<=9; i++) {
			System.out.println(x + " x " + i + " = " + x*i);
		}
		System.out.println();
	}
	
	// 여러단 출력
	void print(int x, int y) {
		for(int i=x; i <=y; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.println(i + " x " + j + " = " + i*j);
//			}
//			System.out.println();
			print(i);
		}
	}
	
	void print2(int x, int y) {
		for(int i=x; i<=y; i++) {
			//print(i);
			print(x);
			x++;
		}
	}
	
	void print3() {
		print(2, 9);
	}
	
	void print3(int x) {
		print(x, 9);
	}
}
