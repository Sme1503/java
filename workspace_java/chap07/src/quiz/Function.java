package quiz;

import java.util.Scanner;

public class Function {
	
	String name, id, pw, siteName;
	
	
	boolean join(String name, String id, String pw) {
		
		this.name = name;
		this.id = id;
		this.pw = pw;
		
		System.out.println("회원 가입되었습니다.");
		
		return true;
	}
	
	String findId(String name) {
		
		if(this.name.equals(name)) {
			return this.id;
		}
		else {
			System.out.println("아이디가 없습니다.");
			return null;
		}
	}
	
	String findPw(String name, String id) {
		
		if(this.name.equals(name) && this.id.equals(id)) {
			System.out.println("새로운 비밀번호를 입력해주세요.");
			setPw();
			return this.pw;
		}
		else {
			System.out.println("이름과 아이디가 정확하지않습니다.");
			return null;
		}
	}
	
	boolean loginCheck(String id, String pw) {
		
		if(this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void setPw() {
		
		Scanner sc = new Scanner(System.in);
		this.pw = sc.nextLine();
		
	}

}
