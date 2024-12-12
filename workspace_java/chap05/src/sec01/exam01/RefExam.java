package sec01.exam01;

public class RefExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = a;
		System.out.println(a + ", "+b);
		b = 12;
		System.out.println(a + ", "+b);
		
		String c = "박상엽";
		//기본 타입 변수는 스택에 저장
		//참조 타입 변수는 데이터가 저장 된 힙의 주소를 스택에 저장
		System.out.println("c : " +c);
		
		System.out.println(a == b);
		// == 스택의 값을 비교한다
		
		// new == 새로운 힙 주소를 할당
		String d = new String("박상엽");
		System.out.println(d);
		System.out.println(c == d);		// String c, d에 저장 된 주소가 다름
		// == 스택의 값을 비교한다 
		
		System.out.println(c.equals(d));
		// String 값 비교는 equals() 사용
		
		String e = "박상엽";
		System.out.println(c == e);		// new를 사용하지 않은 String의 경우, 저장 된 값이 같으면 자바에서 
										// 기존에 저장 된 힙 주소를 공유한다. 
										// 저장된 값이 바뀔 경우, 새로운 힙 주소를 할당한다.
		//a = null; 						// 기본 타입 변수는 null 사용 불가
										// 참조 타입 변수는 null 사용 가능
		String f = "휴먼";				
		System.out.println("f == null : "+ (f == null));
		System.out.println("f != null : "+ (f != null));
		
		f = null;						// f = "" 와 다름. null은 참조하는 주소가 없는 상태
		System.out.println("f == null : "+ (f == null));
		System.out.println("f != null : "+ (f != null));
		
		System.out.println("f + \"abc\" : "+ (f + "abc"));
		
		String g = null;
		System.out.println("g == null " + (g == null)); // 초기화나 값이 할당되지 않은 경우, 변수 사용 불가
		
		if(g!=null) {			
			System.out.println("g.equals : " + g.equals(c)); // 값이 null일 때는 null인지 아닌지만 비교 가능
		}
		System.out.println(g == f);
	}

}
