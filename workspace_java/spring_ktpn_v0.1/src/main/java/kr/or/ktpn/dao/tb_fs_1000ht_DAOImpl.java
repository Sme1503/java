package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class tb_fs_1000ht_DAOImpl implements tb_fs_1000ht_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectPlog() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_fs_1000ht.selectPlog");
		System.out.println("result : " + result);
		
		return result;
	}
}
