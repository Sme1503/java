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
	public int modifyEmp(EmpDTO dto) {
		
		int i = empDAO.updateEmp(dto);
		
		return i;
	}

	@Override
	public int insertEmp(EmpDTO dto) {
		
		int i = empDAO.insertEmp(dto);
		
		return i;
	}

	@Override
	public int deleteEmp(EmpDTO dto) {
		
		int i = empDAO.deleteEmp(dto);
		
		return i;
	}

	@Override
	public List getSearch(String ename) {
		
		List list = empDAO.selectSearch(ename);
		
		return list;
	}
	
	@Override
	public List getEmpSearchList(EmpDTO dto) {
		
		if("ename".equals(dto.getType())) {
			dto.setEname(dto.getKeyword());
		} else if("sal".equals(dto.getType())) {
			try {
				int sal = Integer.parseInt(dto.getKeyword());				
				dto.setSal(sal);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List list = empDAO.selectEmpSearchList(dto);
		
		return list;
	}

}
