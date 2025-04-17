package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000ht_DAO;
import kr.or.ktpn.dto.tb_mr_1000ht_DTO;

@Service
public class Svc_tb_mr_1000htImpl implements Svc_tb_mr_1000ht {

	@Autowired
	tb_mr_1000ht_DAO tb_mr_1000ht_dao;

	@Override
	public List getMlog() {
		// TODO Auto-generated method stub
		
		System.out.println("service_mr_1000ht");
		List list = tb_mr_1000ht_dao.selectMlog();
		System.out.println("service list all : " + list);

		return list;
	}

	@Override
	public int insertMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		int i = tb_mr_1000ht_dao.insertMlog(dto);
		System.out.println("service insert i : " + i);

		return i;
	}

	@Override
	public int updateMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		int i = tb_mr_1000ht_dao.updateMlog(dto);
		System.out.println("service update i : " + i);

		return i;
	}

	@Override
	public List getLastMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		List list = tb_mr_1000ht_dao.selectLastMlog(dto);
		System.out.println("service last list : " + list);

		return list;
	}
}
