package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.tb_mr_1000ht_DTO;

@Repository
public class tb_mr_1000ht_DAOImpl implements tb_mr_1000ht_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectMlog() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_mr_1000ht.selectMlog");
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int insertMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = sqlSession.insert("mapper.tb_mr_1000ht.insertMlog");
		System.out.println("insert i : " + i);
		
		return i;
	}

	@Override
	public int updateMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		int i = sqlSession.update("mapper.tb_mr_1000ht.updateMlog");
		System.out.println("update i : " + i);
		
		return i;
	}

	@Override
	public List selectLastMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectOne("mapper.tb_mr_1000ht.selectLastMlog", dto);
		System.out.println("result : " + result);
		
		return result;
	}
}
