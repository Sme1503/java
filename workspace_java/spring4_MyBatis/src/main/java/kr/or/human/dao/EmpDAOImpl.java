package kr.or.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.human.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpDTO> selectEmpList() {
		
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");
		
		System.out.println("result: " + result);
		
		return result;
	}
	
	@Override
	public EmpDTO selectOneEmp() {
		
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectOneEmp");
		
		System.out.println("dto: " + dto);
		
		return dto;
	}

	@Override
	public EmpDTO selectOneEmpno(int i) {
		
		EmpDTO dto = sqlSession.selectOne("mapper.emp.selectEmpno", i);
		
		System.out.println("dto: " + dto);
		
		return dto;
	}
	
	@Override
	public EmpDTO selectEmpno(EmpDTO dto) {
		
		EmpDTO dto1 = sqlSession.selectOne("mapper.emp.selectEmpno2", dto);
		
		System.out.println("dto: " + dto1);
		
		return dto1;
	}

	@Override
	public int updateEmp(EmpDTO dto) {
		
		int i = sqlSession.update("mapper.emp.updateEmp", dto);
		
		return i;
	}
	
	

}
