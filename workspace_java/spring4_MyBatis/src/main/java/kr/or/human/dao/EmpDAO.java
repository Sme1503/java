package kr.or.human.dao;

import java.util.List;

import kr.or.human.dto.EmpDTO;

public interface EmpDAO {
	
	public List<EmpDTO> selectEmpList();

	public EmpDTO selectOneEmp();
	
	public EmpDTO selectOneEmpno(int i);

	public EmpDTO selectEmpno(EmpDTO dto);
	
	public int updateEmp(EmpDTO dto);
}
