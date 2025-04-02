package kr.or.human.service;

import java.util.List;

import kr.or.human.dto.EmpDTO;

public interface EmpService {
	
	List getEmpList();

	EmpDTO getEmpOne();	

	EmpDTO getEmpnoOne(int i);

	EmpDTO getEmpno(EmpDTO dto);
	
	int modifyEmp(EmpDTO dto);
	
	int insertEmp(EmpDTO dto);
	
	int deleteEmp(EmpDTO dto);
	
	List getSearch(String ename);

	List getEmpSearchList(EmpDTO dto);
}
