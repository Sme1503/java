package sec05.exam05._final;

public class Array {

//	int[] a = new int[3];
//	
//	Array() {
//		System.out.println(a.length);
//		
//		a.length // final 정수 변수
//	}

	final int length;
	int[] arr;
	int cursor = 0;

	Array(int length) {
		this.length = length;
		arr = new int[length];
	}

	void add(int x) {
		if (this.cursor < this.length) {
			arr[this.cursor++] = x;
			printAll();
		} else {
			System.out.println("에러");
		}
	}

	int get(int index) {
		if (index < this.length) {
			return arr[index];
		} else {
			System.out.println("에러");
			return Integer.MIN_VALUE;
		}

	}

	void printAll() {
		System.out.print("값: ");
		for (int x = 0; x < cursor; x++) { // 배열의 초기값이 아닌 크기만큼 출력
			System.out.print(arr[x] + " ");
		}

		System.out.println();

//		System.out.print("값: ");
//		for(int x=0; x<this.length; x++) {
//			if(arr[x] > Integer.MIN_VALUE) {		// 배열을 Integer.MIN_VALUE로 초기화했을 때, 배열안의 값이 초기값보다 크면
//				System.out.print(arr[x]+ " ");		// 그 값만 출력
//			}
//		}
//		System.out.println();

	}
}
