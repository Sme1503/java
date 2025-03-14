package quiz;

public class HumanLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Function f1 = new Naver("네이버");
		Function f2 = new Daum("다음");
		
		
		f1.join("김철수", "p1", "1234");
		System.out.println("아이디는 " + f1.findId("김철수") + "입니다.");
		System.out.println("비밀번호는 " + f1.findPw("김철수", "p1") + "입니다.");
		HumanLoginCheck(f1, "p1", "123");
		
		
		System.out.println();
		
		
		f2.join("김수철", "p2", "1235");
		System.out.println("아이디는 " + f2.findId("김수철") + "입니다.");
		System.out.println("비밀번호는 " + f2.findPw("김수철", "p2") + "입니다.");
		System.out.println();
		
		
	}
	
	static void HumanLoginCheck(Function f, String id, String pw) {
		boolean loginCheck = f.loginCheck(id, pw);
		
		if(loginCheck == true) {
			System.out.println(f.siteName + "회원입니다.");
		}
		else {
			System.out.println(f.siteName + "회원이 아닙니다.");
		}
	}

}
