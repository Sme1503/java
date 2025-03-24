package kr.or.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human.service.MemberService;
import kr.or.human.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	public MemberController() {
		System.out.println("MemberController 생성자 실행");
	}
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member")
	void listMember() {
		System.out.println("listMember 실행");
		
//		MemberService memberService = new MemberServiceImpl();
		
		List memberList = memberService.getList();
		
		System.out.println(memberList);
	}
}
