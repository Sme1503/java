package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.MemberDAO;

@Service
public class Svc_memberImpl implements Svc_member {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List getWorker() {
		// TODO Auto-generated method stub
		
		System.out.println("service member");
		List list = memberDao.selectWorker();
		System.out.println("all Worker : " + list);
		
		return list;
	}

}
