package kr.or.ktpn.service;

import java.util.List;

public interface TAK_Svc_pr_1100mt {

	public List selectDAO();
	
	
	
	
	
	
	
	// 생산완료인 생산코드 가져오는 메소드
	public List getPcode();
	
	// 완제품코드가 x이고 생산이 완료된 생산코드 가져오는 메소드
	public List getPFcode(String fcode);
}
