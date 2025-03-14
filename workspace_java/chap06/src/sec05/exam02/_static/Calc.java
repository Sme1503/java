package sec05.exam02._static;

public class Calc {
	
	String color;
//	static double pi = 3.14;
	static double pi;
	
	
	static {
		pi=3.14;
	}
	
	static Print out = new Print();
	
	static void printPi() {
//		System.out.println("pi: " + this.pi);
		System.out.println("pi: " + pi);
	}
	
	static void printColor() {
//		System.out.println("color: "+ this.color);
//		System.out.println("color: "+ color);
	}
	
	void printPi2() {
//		System.out.println("pi: " + this.pi);
		System.out.println("pi: " + pi);
	}
}
