package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000mt_DAO;

@Service
public class Svc_tb_mr_1000mtImpl implements Svc_tb_mr_1000mt {
	
	@Autowired
	tb_mr_1000mt_DAO tb_mr_1000mt_dao;

	@Override
	public List getMaterials() {
		// TODO Auto-generated method stub
		
		System.out.println("service_mr_1000mt");
		List list = tb_mr_1000mt_dao.selectMaterials();
		System.out.println("list : " + list);
		
		return list;
	}
}
