package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;

public interface TAK_PR_1100MTDAO {
	
	public List<TAK_PR_1100MTDTO> selectDTO();
	
	
	// 생산완료인 생산코드 가져오는 메소드
	public List selectPcode();
}
