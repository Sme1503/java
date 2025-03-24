package kr.or.human.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.human.dao.MemberDAO;
import kr.or.human.dao.MemberDAOImpl;
import kr.or.human.dao.MemberDAOImpl2;

@Service
public class MemberServiceImpl implements MemberService{

	public MemberServiceImpl() {
		
		System.out.println("MemberServiceImpl 생성자 실행");
	}
	
	// IoC
	// Inversion of Control
	// 제어의 역전
	// 타입에 맞는 클래스를 찾아서 대신 생성 해줌
	// 정확히 동일한 클래스 또는 자동 형변환 되는 클래스
	
	// DI
	// Dependency Injection
	// 의존성 주입
	// IoC로 생성한 클래스를 변수에 넣어준다
	
	// 우선순위
	// 1 완전히 동일한 클래스
	// 2 자동 형 변환이 가능한 클래스
	
	
	// @Autowired의 대상 Bean의 후보가 2개 이상이라면 
	// 1 @Qualifier(bean id)에 해당하는 객체 찾기
	// 2 @primary 객체 찾기
	// 3 둘 다 없으면 변수명과 bean id가 같은 것 찾기
	@Autowired
	@Qualifier("memberDAOImpl")
	MemberDAO memberDAO;
//	MemberDAO memberDAOImal;
	
	// @Autowired, @Resource, Inject 비슷비슷하게 IoC, DI를 해준다
	
	@Override
	public List getList() {
		// TODO Auto-generated method stub
		
//		MemberDAO memberDAO = new MemberDAOImpl();
//		MemberDAO memberDAO = new MemberDAOImpl2();
		List list = memberDAO.selectList();
		
		return list;
	}

	
}
