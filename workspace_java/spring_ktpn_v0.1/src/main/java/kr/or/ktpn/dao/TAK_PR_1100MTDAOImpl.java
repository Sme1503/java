package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;

@Repository
public class TAK_PR_1100MTDAOImpl implements TAK_PR_1100MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectDTO() {
		
		List<TAK_PR_1100MTDTO> PR_1100MTDAO = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT");
		System.out.println("PR_1100MTDAO : " + PR_1100MTDAO);
		
		return PR_1100MTDAO;
	}

	
	
	
	
	
	// 생산완료인 생산코드 가져오는 메소드
	@Override
	public List selectPcode() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectFinishAllPCode");
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public List selectPFcode(String fcode) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectFinishAllPCodeFcode", fcode);
		System.out.println("result : " + result);
		
		return result;
	}

}
