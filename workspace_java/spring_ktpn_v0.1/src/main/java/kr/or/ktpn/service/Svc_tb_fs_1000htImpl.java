package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_fs_1000ht_DAO;

@Service
public class Svc_tb_fs_1000htImpl implements Svc_tb_fs_1000ht{

	@Autowired
	tb_fs_1000ht_DAO tb_fs_1000ht_dao;
	
	@Override
	public List getPlog() {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000ht");
		List list = tb_fs_1000ht_dao.selectPlog();
		System.out.println("list : " + list);
		
		return list;
	}

}
