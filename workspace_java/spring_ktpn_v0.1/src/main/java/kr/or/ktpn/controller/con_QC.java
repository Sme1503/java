package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.tb_qa_1100dt_DTO;
import kr.or.ktpn.service.Svc_tb_qa_1000dt;
import kr.or.ktpn.service.Svc_tb_qa_1100dt;

@Controller
public class con_QC {
	
	// 품질관리 컨트롤러
	
	@Autowired
	Svc_tb_qa_1000dt svc_qa_1000dt;

	@Autowired
	Svc_tb_qa_1100dt svc_qa_1100dt;
	
	// 문제 : 추가 할때 뒤로가기를 한다던가하면 같은 값이 또 입력되서 중복값이 생긴다
	// 해결 : 테이블에 기본키 설정이 안되있었다. 기본키 설정할 것
	
	// 품질관리 목록 보여주는 메소드
	@RequestMapping(value="/mainqc", method = RequestMethod.GET)
	public String showQc(Model model) {
		
		List list = svc_qa_1100dt.getSelectQC();
		model.addAttribute("list", list);
		
		return "TestQA_main_park2.tiles";
	}
	
	// 품질관리와 생산을 조인한 결과를 보여주는 메소드
	@RequestMapping(value="/showjoin", method = RequestMethod.GET)
	public String showJoin(Model model, String pcode) {
		
		System.out.println("pcode : " + pcode);
		// 소문자로 인식해서 검색이 안된다 s0001 => S0001 대문자로 바꾸기 -> 완료
		
		List list = svc_qa_1100dt.getJoinQC(pcode);
		System.out.println("list : " + list);
		
		model.addAttribute("QcList", list);
		
		return "TestQA_report_park_table_show2.tiles";
	}
	
	// 품질관리에서 목록에 추가하는 메소드
	@RequestMapping(value="/addqc", method = RequestMethod.POST)
	public String addQc(Model model, tb_qa_1100dt_DTO dto) {
		
		int i = svc_qa_1100dt.getInsertQC(dto);
		
//		return "TestQA_report_park_table_show2.tiles";
		return "redirect: mainqc";
	}
	
	// 품질관리에서 목록에 수정하는 메소드
	@RequestMapping(value="/updateqc", method = RequestMethod.POST)
	public String updateQc(Model model, tb_qa_1100dt_DTO dto) {
		
		int i = svc_qa_1100dt.getUpdateQC(dto);
		
//		return "TestQA_report_park_table_show2.tiles";
		return "redirect: mainqc";
	}
	
	// 품질관리에서 목록에 삭제하는 메소드
	@RequestMapping(value="/deleteqc", method = RequestMethod.POST)
	public String removeQc(Model model, tb_qa_1100dt_DTO dto) {
		
		int i = svc_qa_1100dt.getDeleteQC(dto);
		
//		return "TestQA_report_park_table_show2.tiles";
		return "redirect: mainqc";
	}
	
}
