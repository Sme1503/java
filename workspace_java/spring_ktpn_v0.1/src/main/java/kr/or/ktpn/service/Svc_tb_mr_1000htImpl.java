package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000ht_DAO;

@Service
public class Svc_tb_mr_1000htImpl implements Svc_tb_mr_1000ht {

	@Autowired
	tb_mr_1000ht_DAO tb_mr_1000ht_dao;

	@Override
	public List getMlog() {
		// TODO Auto-generated method stub
		
		System.out.println("service_mr_1000ht");
		List list = tb_mr_1000ht_dao.selectMlog();
		System.out.println("list : " + list);

		return list;
	}
}
