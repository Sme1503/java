package kr.or.human.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MemberDAOImpl2 implements MemberDAO {
	
	public MemberDAOImpl2() {
		System.out.println("MemberDAOImpl2 생성자 실행");
	}
	
	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		list.add("하나");
		list.add("둘");
		list.add("셋");

		return list;
	}

}
