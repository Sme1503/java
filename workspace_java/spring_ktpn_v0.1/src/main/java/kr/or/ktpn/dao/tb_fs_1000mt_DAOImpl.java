package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.tb_fs_1000mt_DTO;

@Repository
public class tb_fs_1000mt_DAOImpl implements tb_fs_1000mt_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectProducts() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_fs_1000mt.selectProducts");
		System.out.println("result : " + result);
		
		return result;
	}
	
	@Override
	public List selectProducts(String code) {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectOne("mapper.tb_fs_1000mt.selectCurrentP", code);
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int insertProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = sqlSession.insert("mapper.tb_fs_1000mt.insertCurrentP", dto);
		System.out.println("insert i : " + i);
				
		return i;
	}

	@Override
	public int updateProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		int i = sqlSession.update("mapper.tb_fs_1000mt.updateCurrentP", dto);
		System.out.println("update i : " + i);
				
		return i;
	}

	@Override
	public int deleteProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = sqlSession.delete("mapper.tb_fs_1000mt.deleteCurrentP", dto);
		System.out.println("delete i : " + i);
				
		return i;
	}

}
