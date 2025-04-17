package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_mr_1000mt_DTO;

public interface Svc_tb_mr_1000mt {

	public List getMaterials();
	
	public List getMaterials(String code);
	
	public int insertMaterials(tb_mr_1000mt_DTO dto);
	
	public int updateMaterials(tb_mr_1000mt_DTO dto);
	
	public int deleteMaterials(tb_mr_1000mt_DTO dto);
}
