package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_od_1000mt_DAO;

@Service
public class Svc_tb_od_1000mtImpl implements Svc_tb_od_1000mt {

	@Autowired
	tb_od_1000mt_DAO tb_od_1000mt_dao;
	
	@Override
	public List getCompanyList() {
		// TODO Auto-generated method stub
		
		System.out.println("service_od_1000mt");
		List list = tb_od_1000mt_dao.selectCompanyList();
		System.out.println("service list all : " + list);
		
		return list;
	}

}
