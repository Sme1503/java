package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class tb_mr_1000mt_DAOImpl implements tb_mr_1000mt_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectMaterials() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectMaterials");
		System.out.println("result : " + result);
		
		return result;
	}
}
