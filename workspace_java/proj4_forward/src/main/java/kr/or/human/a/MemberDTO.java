package kr.or.human.a;

import java.util.ArrayList;
import java.util.List;

public class MemberDTO {
	
	private String id;
	private String pw;
	List list = new ArrayList();
	
	public String getId() {
		System.out.println("MemberDTO getId 실행");
		return id;
	}
	public void setId(String id) {
		System.out.println("MemberDTO setId 실행 id:" + id);
		this.id = id;
		list.add(id);
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
