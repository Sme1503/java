package sec01.exam01;

import java.awt.Menu;
import java.util.ArrayList;

public class ArrayCopyExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1호점에서 판매하는 메뉴
		String[] menu1 = new String[3];
		menu1[0]= "따아";
		menu1[1]= "말차";
		menu1[2]= "라떼";
		
		
		
		// 얕은 복사 - shallow copy, thin copy, call by reference
		// 스택 영역의 값(주소)만 복사 = 공유
		// 값을 변경할 경우 원본이 바뀐다.
		
		// 2호점에서 1호점과 똑같은 메뉴 판매
		String[] menu2 = menu1;
		menu2[2] = "바나나라떼";   // 복사본의 값을 바꾸면 원본값이 변경
		System.out.println("menu1[2] : "+ menu1[2]);
		
		
		
		// 깊은 복사
		// deep copy, depp clone, call by value
		// 전혀 다른 heap영역에 똑같은 내용으로 채워놓음
		// 원본과 복사본은 전혀 다른 객체
		String[] menu3 = new String[menu1.length];
		for(int i =0; i<menu1.length; i++) {
			menu3[i] = menu1[i];
		}
		menu3[2] = "연유라떼";
		System.out.println("menu1[2] : "+ menu1[2]);
		System.out.println("menu3[2] : "+ menu3[2]);
		
		
		// 3호점에서만 신메뉴 출시
		String[] menu4 = new String[menu1.length + 1];
		for(int i =0; i<menu1.length; i++) {
			menu4[i] = menu1[i];
		}
		menu4[menu4.length-1] = "사라다빵";
		System.out.println("menu4[3] : "+ menu4[menu4.length-1]);
		
		for(int i =0; i<menu4.length; i++) {
			System.out.println(menu4[i]);
		}
		
		// ArrayList
		ArrayList list = new ArrayList();
		// 추가
		list.add(1);
		list.add("문자");
		list.add(false);
		
		// 사용
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
	
		// 사이즈
		System.out.println(list.size());
		System.out.println(list);
		
		
		// 향상된 for문
		int n = 0;
		for(String menu : menu3) {
			System.out.println("menu : "+menu);					// 순서 확인 불가
			System.out.println("menu" + n + " : "+menu3[n]);	// 순서 확인 가능
			n++;
		}			// 단점 1. 중간중간 건너뛰기 불가
					// 단점 2. 반복 순서가 몇 번째인지 알 수 없다. 외부변수를 줘서 확인은 가능
		System.out.println();
		
		//p223. q5.
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
	
		
		int sum = 0, nn=0, max = Integer.MIN_VALUE;
		double avg = 0.0;
		
		for(int i =0; i<array.length; i++) {
			nn += array[i].length;
			for(int j=0; j<array[i].length; j++) {
				sum += array[i][j];
		
				if(max<array[i][j]) {
					max = array[i][j];
				}
			}
			
		}
		avg = (double) sum/nn;
		
		System.out.println("sum: "+ sum);
		System.out.println("avg: "+ avg);
		System.out.println("max: "+ max);
		System.out.println();
		
		
		
		
	}

}
