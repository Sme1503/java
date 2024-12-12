package quiz;

public class Calc {
	// 계산기 클래스

	// double x, y;

	/**
	 * compute
	 * 
	 * @param int, String, int
	 * @return void
	 */
	double compute(int x, String a, int y) {

		if (a.equals("+") || a.equals("더하기") || a.equals("플러스") || a.equals("plus")) {
			return plus(x, y);
		} else if (a.equals("-") || a.equals("빼기") || a.equals("마이너스") || a.equals("minus")) {
			return minus(x, y);
		} else if (a.equals("*") || a.equals("곱하기") || a.equals("멀티") || a.equals("multi")) {
			return multi(x, y);
		} else if (a.equals("/") || a.equals("나누기") || a.equals("디브") || a.equals("div")) {
			return div(x, y);
		} else {
			System.out.println("제대로 입력하시오.");
			return 0;
		}
	}
	double compute(int x, String a, double y) {

		if (a.equals("+") || a.equals("더하기") || a.equals("플러스") || a.equals("plus")) {
			return plus(x, y);
		} else if (a.equals("-") || a.equals("빼기") || a.equals("마이너스") || a.equals("minus")) {
			return minus(x, y);
		} else if (a.equals("*") || a.equals("곱하기") || a.equals("멀티") || a.equals("multi")) {
			return multi(x, y);
		} else if (a.equals("/") || a.equals("나누기") || a.equals("디브") || a.equals("div")) {
			return div(x, y);
		} else {
			System.out.println("제대로 입력하시오.");
			return 0;
		}
	}
	double compute(double x, String a, int y) {

		if (a.equals("+") || a.equals("더하기") || a.equals("플러스") || a.equals("plus")) {
			return plus(x, y);
		} else if (a.equals("-") || a.equals("빼기") || a.equals("마이너스") || a.equals("minus")) {
			return minus(x, y);
		} else if (a.equals("*") || a.equals("곱하기") || a.equals("멀티") || a.equals("multi")) {
			return multi(x, y);
		} else if (a.equals("/") || a.equals("나누기") || a.equals("디브") || a.equals("div")) {
			return div(x, y);
		} else {
			System.out.println("제대로 입력하시오.");
			return 0;
		}
	}
	double compute(double x, String a, double y) {

		if (a.equals("+") || a.equals("더하기") || a.equals("플러스") || a.equals("plus")) {
			return plus(x, y);
		} else if (a.equals("-") || a.equals("빼기") || a.equals("마이너스") || a.equals("minus")) {
			return minus(x, y);
		} else if (a.equals("*") || a.equals("곱하기") || a.equals("멀티") || a.equals("multi")) {
			return multi(x, y);
		} else if (a.equals("/") || a.equals("나누기") || a.equals("디브") || a.equals("div")) {
			return div(x, y);
		} else {
			System.out.println("제대로 입력하시오.");
			return 0;
		}
	}

	/**
	 * plus
	 * 
	 * @param int, int
	 * @return int
	 */
	int plus(int x, int y) {

		return x + y;
	}

	double plus(int x, double y) {

		return x + y;
	}

	double plus(double x, int y) {

		return x + y;
	}

	double plus(double x, double y) {

		return x + y;
	}

	/**
	 * minus
	 * 
	 * @param int, int
	 * @return int
	 */
	int minus(int x, int y) {

		return x - y;
	}

	double minus(int x, double y) {

		return x - y;
	}

	double minus(double x, int y) {

		return x - y;
	}

	double minus(double x, double y) {

		return x - y;
	}

	/**
	 * multi
	 * 
	 * @param int, int
	 * @return double
	 */
	double multi(double x, double y) {

		return x * y;
	}

	double multi(int x, int y) {

		return x * y;
	}

	double multi(double x, int y) {

		return x * y;
	}

	double multi(int x, double y) {

		return x * y;
	}

	/**
	 * div
	 * 
	 * @param int, int
	 * @return double
	 */
	double div(double x, double y) {

		return x / y;
	}

	double div(int x, int y) {

		return x / y;
	}

	double div(double x, int y) {

		return x / y;
	}

	double div(int x, double y) {

		return x / y;
	}

}
