package kr.or.human.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human.dao.EmpDAO;
import kr.or.human.dao.EmpDAOImpl;
import kr.or.human.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List getEmpList() {
	
		List list = empDAO.selectEmpList();
		
		return list;
	}

	@Override
	public EmpDTO getEmpOne() {
		
		EmpDTO dto = empDAO.selectOneEmp();
		
		return dto;
	}

	@Override
	public EmpDTO getEmpnoOne(int i) {
		
		EmpDTO dto = empDAO.selectOneEmpno(i);
		
		return dto;
	}
	
	@Override
	public EmpDTO getEmpno(EmpDTO dto) {
		
		EmpDTO dto1 = empDAO.selectEmpno(dto);
		
		return dto1;
	}

	@Override
	public int getUpdateEmp(EmpDTO dto) {
		
		int i = empDAO.updateEmp(dto);
		
		return i;
	}

}
