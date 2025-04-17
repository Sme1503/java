package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000mt_DAO;
import kr.or.ktpn.dto.tb_mr_1000mt_DTO;

@Service
public class Svc_tb_mr_1000mtImpl implements Svc_tb_mr_1000mt {
	
	@Autowired
	tb_mr_1000mt_DAO tb_mr_1000mt_dao;

	@Override
	public List getMaterials() {
		// TODO Auto-generated method stub
		
		System.out.println("service_mr_1000mt");
		List list = tb_mr_1000mt_dao.selectMaterials();
		System.out.println("service list all : " + list);
		
		return list;
	}
	
	@Override
	public List getMaterials(String code) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		List list = tb_mr_1000mt_dao.selectMaterials(code);
		System.out.println("service list one : " + list);
		
		return list;
	}

	@Override
	public int insertMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.insertMaterials(dto);
		System.out.println("service insert i : " + i);
		
		return i;
	}

	@Override
	public int updateMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.updateMaterials(dto);
		System.out.println("service update i : " + i);
		
		return i;
	}

	@Override
	public int deleteMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.deleteMaterials(dto);
		System.out.println("service delete i : " + i);
		
		return i;
	}
}
