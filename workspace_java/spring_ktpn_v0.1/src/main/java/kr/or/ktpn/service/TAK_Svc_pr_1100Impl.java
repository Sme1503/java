package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1100MTDAO;

@Service
public class TAK_Svc_pr_1100Impl implements TAK_Svc_pr_1100mt {

	@Autowired
	TAK_PR_1100MTDAO tb_pr_1100MTDAO;

	@Override
	public List selectDAO() {

		List PR_1100MTSVC = tb_pr_1100MTDAO.selectDTO();
		System.out.println("PR_1100MTSVC : "+PR_1100MTSVC);
		return PR_1100MTSVC;
	}

	
	
	
	
	// 생산완료인 생산코드 가져오는 메소드
	@Override
	public List getPcode() {
		// TODO Auto-generated method stub
		
		System.out.println("service pr_1100mt");
		List list = tb_pr_1100MTDAO.selectPcode();
		System.out.println("list : " + list);
		
		return list;
	}
	
	
}
