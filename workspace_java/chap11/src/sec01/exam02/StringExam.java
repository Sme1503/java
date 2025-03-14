package sec01.exam02;

public class StringExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "영일이삼사오육칠팔구삼사";

		char c = s1.charAt(0);
		System.out.println("char c: " + c);

		// 왼쪽부터 첫번째 일치하는 곳의 인덱스를 돌려준다
		// 없으면 -1
		int i = s1.indexOf("삼사");
		System.out.println("indexOf: " + i);

		int i2 = s1.indexOf("a");
		System.out.println("indexOf 없는 것: " + i2);

		int i3 = s1.lastIndexOf("삼사");
		System.out.println("lastIndexOf: " + i3);

		// 이메일 양식 점검
		// @ 와 . 이 하나 이상 있어야 정확한 이메일 주소 양식이라고 판단
		String email = "papappa@naver.co.kr";
		int i4 = email.indexOf("@");
		int i5 = email.indexOf(".");
		if (i4 > -1 && i5 > -1) {
			System.out.println("이메일이 맞습니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}

		// indexOf 구현
//		for(int j =0; j<s1.length(); j++) {
//			char c1 = s1.charAt(j);
//			char c2 = s1.charAt(j+1);
//			if(c1 == '@') { 
//				// 인덱스를 출력 또는 리턴하는 메소드
//				break;
//			}
//		}

		// 첫번째 전달인자를 두번째 전달인자로 모두 바꾼다
		String s2 = s1.replace("삼사", "34");
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		// replace는 해당되는 모든 곳을 바꾼다
		// 원본을 바꾸지않는 비파괴 함수

		// 시작 index부터 종료index 바로 앞까지 잘라서 돌려준다
		String s3 = s1.substring(2, 4);
		System.out.println("s1.substring(2, 4): " + s3);

		// 성별을 "남", "여"로 출력
		String ssn = "123456-1234567";
		int i6 = ssn.indexOf("-") + 1;
		int end = i6 + 1;
		if (ssn.substring(i6, end).equals("1") || ssn.substring(i6, end).equals("3")) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}

		// 전달인자가 하나면 거기서부터 끝까지
		System.out.println(ssn.substring(3));

		// 앞뒤 공백만 제거, 중간의 공백은 제거하지않는다
		String s5 = "     글씨 중간띄우기     ";
		System.out.println("[" + s5 + "]");
		System.out.println("[" + s5.trim() + "]");

		// 구분자로 글씨를 잘라서 배열로 돌려준다
		// 구분자는 사라진다
		// split의 전달인자는 String이 아니라 정규표현식
		// 정규표현식의 예약글자는 그냥 쓰면 안된다
		// 역슬래시(\)로 탈출시키거나 대괄호[]로 감싸준다
		String menu = "아무거나,풀떼기,햄북햄부기";
		String[] menus = menu.split(",");
		for (String m : menus) {
			System.out.println(m);
		}

		String url = "cafe.naver.com";
		// 정규표현식에서 .은 의미가 있는 예약문자라서 사용불가
		String[] urls3 = url.split(".");
		System.out.println(urls3.length);
		for (String m : urls3) {
			System.out.println(m);
		}
		// \\를 사용
		String[] urls = url.split("\\.");
		// []를 사용
		String[] urls2 = url.split("[.]");
		System.out.println(urls.length);

		// 문제1
		// 다음은 query string이 포함된 네이버의 검색 주소입니다
		// 검색어의 key 값은 query입니다
		// 검색어만 출력하시오
		String s6 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=grok3";
		String[] s7 = s6.split("=");
		for (String m : s7) {
			System.out.println(m);

		}
		System.out.println();

		for (String m : s7) {
			if (m.equals("grok3"))
				System.out.println(m);

		}
		System.out.println();

		// 문제2
		// html 속성 class에 cl의 text가 있을 때
		// target의 class가 존재하는지 확인
		String cl = "red bigy px";
		String target = "big";
		String[] cl1 = cl.split(" ");
		for (String m : cl1) {
			System.out.println(m);
		}
		System.out.println();

//		for(String m : cl1) {
//			if(m.equals(target))
//				System.out.println(m);
//		}
//		System.out.println();
		String ch;
		String[] ch1 = null;
		for (int z = 0; z < target.length(); z++) {
			if (z == target.length() - 1) {
				ch1[z] = target.substring(z);
				break;
			}
			ch1[z] = target.substring(z, z + 1);
		}
		for (String m : ch1) {
			System.out.println(m);
		}

//		for (int a = 0; a < ch1.length; a++) {
//			if (ch[a] == cj[a]) {
//				continue;
//			} else {
//				break;
//			}
//		}

		
		// 이렇게 하면 메모리가 낭비된다
		String a = "a";
		a += "b";
		
		// 메모리를 효율적으로 사용한다
		// 스레드에 안전하다 (Thread-safe)
		// 이거 어케 동작함?
		StringBuffer sb = new StringBuffer("abc");
		sb.append("defg");
		sb.append("defg");
		String d = sb.toString();
		
		// 스레드에 안전하지 않다
		StringBuilder sbb = new StringBuilder("abc");
		sbb.append("defg");
		String d2 = sbb.toString();
		
		
		
		
		
		
	}

}
