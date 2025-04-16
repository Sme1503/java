package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_fs_1000mt_DAO;

@Service
public class Svc_tb_fs_1000mtImpl implements Svc_tb_fs_1000mt {

	@Autowired
	tb_fs_1000mt_DAO tb_fs_1000mt_dao;

	@Override
	public List getProducts() {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000mt");
		List list = tb_fs_1000mt_dao.selectProducts();
		System.out.println("list : " + list);

		return list;
	}
	
}
