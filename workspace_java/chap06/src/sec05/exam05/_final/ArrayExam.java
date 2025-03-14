package sec05.exam05._final;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[5];
		a[0] = 1;
		
		// 생성하고 add()에 값을 넣으면 자동으로 현재 index에 추가
		// 단, 크기를 벗어나면 "에러 문구 출력"
		// get()에 index를 넣으면 그 index의 값을 return 
		
		Array array = new Array(5);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);
		
		System.out.println();
		
		System.out.println("값: " + array.get(0));
		System.out.println("값: " + array.get(1));
		System.out.println("값: " + array.get(2));
		System.out.println("값: " + array.get(3));
		System.out.println("값: " + array.get(4));
		System.out.println("값: " + array.get(5));
		
		
	}

}
