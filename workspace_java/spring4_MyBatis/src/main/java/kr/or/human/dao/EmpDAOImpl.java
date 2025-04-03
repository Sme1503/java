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
		int i = -1;

		try {
			i = sqlSession.update("mapper.emp.updateEmp", dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int insertEmp(EmpDTO dto) {

		int i = -1;

//		i = sqlSession.insert("mapper.emp.insertEmp", dto);
		i = sqlSession.insert("mapper.emp.insertEmp2", dto);
		System.out.println(dto);
		
		// 이후 여러개의 insert 가능
		
		return i;
	}

	@Override
	public int deleteEmp(EmpDTO dto) {

		int i = -1;

		i = sqlSession.delete("mapper.emp.deleteEmp", dto);

		return i;
	}

	@Override
	public void getSeq() {
		int seq = sqlSession.selectOne("mapper.emp.getSeq");
		
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(seq);
		
	}

	@Override
	public List<EmpDTO> selectSearch(String ename) {
		
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.search", ename);
		System.out.println("result : " + result);
		
		return result;
	}
	
	@Override
	public List<EmpDTO> selectEmpSearchList(EmpDTO dto) {
		
//		List<EmpDTO> result = sqlSession.selectList("mapper.emp.dynamic.selectEmp", dto);
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.page.selectEmp", dto);
		System.out.println("result : " + result);
		
		return result;
	}

}
