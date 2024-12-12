package sec01.exam01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] score;  // score 변수는 int로 구성된 배열
		int score2[] = new int[5];
		
		score = null;
		
		int score_0 = 90;
		int score_1 = 70;
		int score_2 = 50;
		
		// 배열 선언하는 방법 1 - 값이 없으면 타입 별 초기값으로 초기화 
		int[] intArray = new int[3];
		intArray[0] = 90;
		intArray[1] = 70;
//		intArray[2] = 50;
		
		System.out.println("intArray[0] : "+ intArray[0]);
		
		// 기본값은 0 false, null로 초기화된다.
		System.out.println("intArray[2] : "+ intArray[2]);
		
		// 에러 - 범위를 벗어남
//		System.out.println("intArray[3] : "+ intArray[3]);
		
		// 배열 선언하는 방법 2 - 넣을 값을 모두 정확히 알고 있는 경우
		int[] intArray2 = new int[] {90, 60, 70}; 
		
		int[] intArray2_1 = null;
		intArray2_1 = new int[] {90, 60, 70};
		
		// 배열 선언하는 방법 3 - new 타입[] 생략 - 선언과 동시에 초기화하는 경우에만 생략 가능
		int[] intArray3 = {90, 60, 70};  // 선언과 동시에 초기화
		
		System.out.println("intArray3의 길이 : "+ intArray3.length);
		
		System.out.println("intArray3 : " + intArray3);
		
		String[] sArr = new String[14];
		sArr[0] = "이름1";
		sArr[1] = "이름2";
		
		int k = 1;
		sArr[k+1] = "이름" + (k+2);
		
		for(int i =0; i<sArr.length; i++) {
			sArr[i] = "이름" + (i+1);
			
		}
		
		// sArr의 모든 내용 출력
		for(int i =0; i<sArr.length; i++) {
			System.out.println(sArr[i]);
		}
		System.out.println();
		
		// q1. 1~10까지 배열에 넣고 배열의 총 합, 평균값 출력
		int[] num = new int[10];
		int sum =0; 
		double avg = 0;
		
		for(int i =0; i< num.length; i++) {
			num[i] = (i+1);
			sum += num[i];
		}
		avg = (double) sum / num.length;
		
		System.out.println("배열의 총합 : "+sum +", 평균값 : "+avg);
		System.out.println();
		
		// q2. 10~1까지 출력
		for(int i = num.length-1; i>=0; i--) {
			System.out.println(num[i]);
		}
		System.out.println();
		for(int i = 0; i<num.length; i++) {
			System.out.println(num[num.length-1-i]);
		}
		System.out.println();
		
		// q3. [3,4,7,5,1,4,6] 
		int[] nums = {3,4,7,5,1,4,6};
		// q3-1. 홀수의 개수 구하기
		int n = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] % 2 == 1) {
				n++;
			}
		}
		System.out.println("홀수의 개수 : "+ n);
		System.out.println();
		
		// q3-2. 4보다 큰 수의 개수 구하기
		n = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 4) {
				n++;
			}
		}
		System.out.println("4보다 큰 수의 개수 : "+ n);
		System.out.println();
		
		// q3-3. 최대깂 구하기
		n = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			
			if(max < nums[i]) {
				max = nums[i];
			}
//			if(n < nums[i]) {
//				n = nums[i];
//			}
		}
		System.out.println("최대값 : "+ max);
		System.out.println();
		
		// q3-4. 두번째로 큰 수 구하기
		n = 0;								// 최대값 변수 초기화
		int[] nums2 = new int[nums.length];
		
		for(int i=0; i<nums.length; i++) {
			
			if(n < nums[i]) {				// 첫번째 배열의 최대값
				n = nums[i];
			}
		}
		for(int i=0; i<nums.length; i++) {
			if(n>nums[i]) {					// 첫번째 배열의 최대값을 제외한 나머지로 새로운 배열 만들기
				nums2[i] = nums[i];
			}
		}
		n = 0;								// 최대값 변수 초기화
		for(int i=0; i<nums2.length; i++) {
			
			if(n < nums2[i]) {				// 두번째 배열의 최대값
				n = nums2[i];
			}
		}
	
		System.out.println("두번째로 큰 수 : "+ n);
		System.out.println();
																
		// q3-4. 다른 방법
		max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			
			if(max < nums[i]) {
				max = nums[i];
			}	
		}
		int second = nums[0];
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=max && second < nums[i]) {
				second = nums[i];
			}
		}
		System.out.println("두번째로 큰 수 : "+ second);
		System.out.println();
		
		// 정렬
		for(int i=0; i<nums.length; i++) {
		
			int a = 0;
			if(i+1 != nums.length) {
				if(nums[i]>nums[i+1]) {
				a = nums[i+1];
				nums[i+1] = nums[i]; 
				nums[i] = a;
				}
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println();
		
//		for(int i=0; i<nums.length; i++) {
//			for(int j=1; j<nums.length; j++) {
//				int a = 0;
//				if(nums[i]>num[j]) {
//					a = nums[j];
//					nums[j] = nums[i]; 
//					nums[i] = a;
//				}
//			}
//		}
		
		// q4. 배열을 하나씩 뒤로 밀기
		int[] nums4 = {1,2,3,4};
		
		// q4-1. 밀고 밀린 자리는 0으로 채우기 ex) 0 1 2 3
		for(int i = nums4.length-1; i>=0; i--) {
					
			if(i == 0) {
				nums4[i] = 0;
			}
			if((i-1) == -1) {
				break;
			}
			nums4[i] = nums4[i-1];
			
			
		}
		for(int i=0; i<nums4.length; i++) {
			System.out.print(nums4[i]+" ");
		}
		System.out.println();
		
		
		
		// q4-2. 밀고 밀린 자리는 마지막 것 넣기 ex) 4 1 2 3
		int[] nums5 = {1,2,3,4};
		int e = 0;
		for(int i = nums5.length-1; i>=0; i--) {		
			
			if(i==nums5.length-1) {
				e = nums5[nums5.length-1];
			}
			
			if(i == 0) {
				nums5[i] = e;
			}
			if((i-1) == -1) {
				break;
			}
			nums5[i] = nums5[i-1];

		}
		for(int i=0; i<nums5.length; i++) {
			System.out.print(nums5[i]+" ");
		}
		System.out.println();
		System.out.println();
		
//		// q5. 임시 비밀번호 8자리 만들기
//		// q5-1. 숫자로 8자리
		Scanner sc = new Scanner(System.in);
//		int[] pw = new int[8];						// 비밀번호 8자리
//		int[] pw_1 = new int[pw.length];
//		
//		System.out.print("비밀번호 입력: ");
//		for(int i=0; i<pw.length; i++) {			// 원래 비밀번호
//			int in = sc.nextInt();
//			pw[i] = in;
//		}
//		System.out.println();
//		
//		System.out.print("비밀번호 확인: ");		// 확인 비밀번호
//		for(int i=0; i<pw_1.length; i++) {
//			int in = sc.nextInt();
//			pw_1[i] = in;
//		}
//		System.out.println();
//		
//		for(int i=0; i<pw.length; i++) {
//			if(pw[i] != pw_1[i]) {
//				System.out.println("비밀번호 다름");
//			}
//			else {
//				System.out.println("비밀번호 같음");
//			}
//		}
//		System.out.println();
//		
//		for(int i=0; i<pw.length; i++) {
//			System.out.print(pw[i]+" ");
//		}
//		System.out.println();
//		for(int i=0; i<pw_1.length; i++) {
//			System.out.print(pw_1[i]+" ");
//		}
//		System.out.println();
		System.out.println();
		
		// q5-2. 소문자로 8자리
		String[] pw1 = new String[8];				// 비밀번호 8자리
		String[] pw1_1 = new String[pw1.length];
		
		System.out.print("비밀번호 입력: ");
		for(int i=0; i<pw1.length; i++) {			// 원래 비밀번호
			String in = sc.next();
			pw1[i] = in;
		}
		System.out.println();
		
		System.out.print("비밀번호 확인: ");
		for(int i=0; i<pw1_1.length; i++) {			// 확인 비밀번호
			String in = sc.next();
			pw1_1[i] = in;
		}
		System.out.println();
		
		for(int i=0; i<pw1.length; i++) {
			if(pw1[i].equals(pw1_1[i])) {
				System.out.println("비밀번호 같음");
			}
			else {
				System.out.println("비밀번호 다름");
			}
		}
		System.out.println();
		
		for(int i=0; i<pw1.length; i++) {
			System.out.print(pw1[i]+" ");
		}		
		System.out.println();
		
		for(int i=0; i<pw1_1.length; i++) {
			System.out.print(pw1_1[i]+" ");
		}		
		System.out.println();
		System.out.println();
//
//		// q5-3. 숫자2개 이상, 대/소문자 조합
//		String[] pw2 = new String[8];				// 비밀번호 8자리
//		String[] pw2_1 = new String[pw2.length];	
//		
//		System.out.print("비밀번호 입력: ");
//		for(int i=0; i<pw2.length; i++) {			// 원래 비밀번호
//			String in = sc.next();
//			pw2[i] = in;
//		}
//		System.out.println();
//		
//		System.out.print("비밀번호 확인: ");
//		for(int i=0; i<pw2_1.length; i++) {			// 확인 비밀번호
//			String in = sc.next();
//			pw2_1[i] = in;
//		}
//		System.out.println();
//		
//		for(int i=0; i<pw2.length; i++) {
//			if(pw2[i].equals(pw2_1[i])) {
//				System.out.println("비밀번호 같음");
//			}
//			else {
//				System.out.println("비밀번호 다름");
//			}
//		}
//		System.out.println();
//		
//		for(int i=0; i<pw2.length; i++) {
//			System.out.print(pw2[i]);
//		}		
//		System.out.println();
//		
//		for(int i=0; i<pw2_1.length; i++) {
//			System.out.print(pw2_1[i]);
//		}		
//		System.out.println();
		System.out.println();
		
		// q6. 예약 - 자리가 10개 있는 소극장 예약 시스템 자리 번호는 1-10번까지
		//			- 예약이 가능하면 n번자리 예약성공
		// 			- 예약이 불가능하면 이미 예약되있음
		//          - 메뉴 : 1.예약, 2. 모든 좌석 현황, 3. 잔여 좌석, 4. 종료
		boolean[] seat = new boolean[10];          // 실제 좌석 배열
		//boolean check = true;
		String[] seat_show = new String[10];         // 화면에 보기편하게 표시하는 배열
		for(int i = 0; i<seat_show.length; i++) {
			seat_show[i] = "예약 가능";			 	 // 예약 가능으로 초기화
		}
		do{
			System.out.println("메뉴");
			System.out.println("1. 예약  2. 전제 좌석 현황  3. 잔여 좌석  4. 종료");
			System.out.print("입력: ");
			int menu = sc.nextInt();
			System.out.println();
			
			if(menu <= 4) {
				if(menu == 1) {									// 예약
					System.out.print("1~10 중 예약할 좌석을 고르시오 : ");
					int choose = sc.nextInt();
					
					if(choose<=10) {
						if(seat[choose-1] == false) {			 // 예약이 없으면
							seat[choose-1] = true;              // 선택한 좌석 예약
							seat_show[choose-1] = "예약 불가";
							System.out.println("선택한 자리 예약 완료");
							System.out.println();
							//continue;
							}
						else {
							System.out.println("선택한 자리 예약 불가");
							System.out.println();
							//continue;
						}
						
					} 
					else {
						System.out.println("1~10 중에 고르시오");
						//continue;								// 메뉴로 돌아가기
					}
				}
				else if(menu == 2) {							// 전체 좌석 현황
					System.out.println("전체 좌석 현황");
					for(int i=0; i<seat_show.length; i++) {
						System.out.print((i+1)+": "+seat_show[i]+ " ");
					}
					System.out.println();
					System.out.println();
				}
				else if(menu == 3) {							// 잔여 좌석
					System.out.print("잔여 좌석은 ");
					
					for(int i=0; i<seat.length; i++) {
						//int[] seat_1 = new int[seat.length];
				
						if(seat[i] == false) {
							//seat_1[i] = i+1;
							
							System.out.print(", "+(i+1));							
						}
						
					}
					System.out.println("번 입니다.");
					System.out.println();
				}
				else {											// 종료
					break;
				}
			}
			else {												// 4보다 큰 수를 입력했을 때
				System.out.println("제대로 입력하시오: ");
				System.out.println();
			}
			
			
			
		}while(true);
		
		//-------------
		// q7. 로또 6개를 배열에 중복없이 저장
		int[] lotto = new int[6];							 // 1차원 배열
		
		
		for(int i = 0; i<lotto.length; i++) {
			int rand = (int)(Math.random()*45)+1;           // 난수 생성
			lotto[i] = rand;								 // 배열[i]에 저장
			
			if(i == 0) {									 // 처음 한번은 비교없이 진행		
				continue;
			}
			else {											 // 두번째부터 바로 이전 값과 비교
//				if(lotto[i] == lotto[i-1]) {				 // 새로운 값과 이전 값이 같으면		
//					rand = (int)(Math.random()*45)+1;	     // 새로운 난수 생성
//					lotto[i] = rand;						 // 저장
//				}
				for(int j = 0; j<=i-1; j++) {				 // 배열[i]를 배열[0]부터 베열[i-1]까지 비교
					if(lotto[i] == lotto[j]) {				 // 새로운 값과 이전 값이 같으면		
						rand = (int)(Math.random()*45)+1;	 // 새로운 난수 생성
						lotto[i] = rand;					 // 저장
						//break;
					}
				}
				
			}
			System.out.print(lotto[i]+" ");					 // 출력
		}
		System.out.println();								 // 문제 a[i] == a[i+1]은 중복이 아니지만
		System.out.println();													 //      a[i] == a[i+2]는 중복인 경우 발생
															 //      ex) 6 1 6 4 28 2
		
		int[][] lotto2 = new int[2][6];						 // 2차원 배열
		
		for(int i = 0; i<lotto2[0].length; i++) {
			int rand = (int)(Math.random()*45)+1;           // 난수 생성
			lotto2[1][0] = rand;
			
			if(i == 0) {									 // 처음 한번은 비교없이 진행
				lotto2[0][i] = lotto2[1][0];
				continue;
			}
			else {
				
			}
		}
		
		// 로또 다른 방법
		boolean flag= false;
		for(int j = 0; j<lotto.length; j++) {
			do {
				lotto[j] = (int)(Math.random()*45)+1;
				flag = false;
				for(int i=0; i<j;i++) {
					if(lotto[i]== lotto[j]) {
						flag = true;
						break;
					}
				}
			} while(flag);
		}
		for(int i=0; i<lotto.length; i++) {
			
			System.out.println(lotto[i]+ ", ");
			if(i != 0) {
				System.out.println(","+ lotto[i]);
			}
			else {
				System.out.println(lotto[i]);
			}
		}
		
		
		
		
		
		// -----------p212. 다차원 배열 -----
		int[] class1 = new int[20];
		int[] class2 = new int[20];
		int[] class3 = new int[20];
		int[] class4 = new int[20];
		
		int[][] 천안 = new int[4][20];
		
		System.out.println("천안 : "+ 천안);
		System.out.println("천안[0] : "+ 천안[0]);
		System.out.println("천안[0][0] : "+ 천안[0][0]);
		
		// 서로 다른 크기를 가지는 2차원 배열
		int[][] test = {
							{1,2,3},
							{1,2,3,4},
							{78}
						};
		System.out.println(test[1][3]);
		System.out.println("test.length : " + test.length);
		System.out.println("test[0].length : " + test[0].length);
		System.out.println("test[1].length : " + test[1].length);
		
		int[][] 수원 = new int[4][20];
		int[][] 서울 = new int[4][20];
		
		int[][][] 휴먼 = new int[3][4][20];
		System.out.println();
		
		// qq1. 가상 달력
		// 12개월, 각 달은 30일까지만 존재.
		// 모든 날짜 채우기 및 출력
		
		int[][] mon = new int[12][30];
		
		for(int i =0; i<mon.length; i++) {
			for(int j =0; j<mon[i].length; j++) {
				mon[i][j] = j+1;
			}
		}
		for(int i =0; i<mon.length; i++) {
			System.out.println(i+1+"월");
			for(int j =0; j<mon[i].length; j++) {
				System.out.print(mon[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int j =0; j<mon[0].length; j++) {
			mon[0][j] = j+1;
		}
		System.out.println("1월");
		for(int j =0; j<mon[0].length; j++) {
			System.out.print(mon[0][j] + " ");
		}
		System.out.println();
		System.out.println();
	
		
		// ----------p217. 배열 복사-----
		String[] name1 = {"김","이","박","최"};
		
		String[] name2 = new String[name1.length];
		for(int i=0; i<name1.length; i++) {
			name2[i] = name1[i];
			
			System.out.print(name2[i]+" ");
		}
//		System.arraycopy();
//		Arrays.copyOf();
		
		
		System.out.println();
		
		
		
		
	}

}
