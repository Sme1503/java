package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.tb_mr_1000mt_DTO;
import kr.or.ktpn.service.Svc_tb_fs_1000ht;
import kr.or.ktpn.service.Svc_tb_fs_1000mt;
import kr.or.ktpn.service.Svc_tb_mr_1000ht;
import kr.or.ktpn.service.Svc_tb_mr_1000mt;
import kr.or.ktpn.service.Svc_tb_od_1000mt;

@Controller
public class con_PMm {

	// 완제품, 원자재, 거래처 컨트롤러

	@Autowired
	Svc_tb_od_1000mt svc_od_1000mt;

	@Autowired
	Svc_tb_mr_1000mt svc_mr_1000mt;

	@Autowired
	Svc_tb_mr_1000ht svc_mr_1000ht;

	@Autowired
	Svc_tb_fs_1000mt svc_fs_1000mt;

	@Autowired
	Svc_tb_fs_1000ht svc_fs_1000ht;

	// 거래처 보여주는 메소드
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String showCompany(Model model) {

		List list = svc_od_1000mt.getCompanyList();
		model.addAttribute("companyList", list);

		return "TestMM_order_park.tiles";
	}

	// 완제품 로그 보여주는 메소드
	@RequestMapping(value = "/plog", method = RequestMethod.GET)
	public String showPlog(Model model) {

		List list = svc_fs_1000ht.getPlog();
		model.addAttribute("plogList", list);

		return "TestMM_main_park_pLog.tiles";
	}

	// 원자재 로그 보여주는 메소드
	@RequestMapping(value = "/mlog", method = RequestMethod.GET)
	public String showMlog(Model model) {

		List list = svc_mr_1000ht.getMlog();
		model.addAttribute("mLogList", list);

		return "TestMM_main_park_mLog.tiles";
	}

	// 원자재, 완제품 목록, 기준관리(원자재코드), 작업자, 생산코드 보여주는 메소드
	@RequestMapping(value = "/mainmp", method = RequestMethod.GET)
	public String showM_P(tb_mr_1000mt_DTO dto, Model model) {

		List list1 = svc_mr_1000mt.getMaterials();

		dto = (tb_mr_1000mt_DTO) list1.get(0);

		List list2 = svc_fs_1000mt.getProducts();

		model.addAttribute("MtableSelect", list1);
		model.addAttribute("dto", dto);
		model.addAttribute("PtableSelect", list2);

		return "TestMM_main2_park.tiles";
	}

	// 원자재 현황, 원자재로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/addm1", method = RequestMethod.GET)
	public String addM1() {
		
		

		return "TestMM_add2_park.tiles";
	}

	// 원자재 현황, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/addm", method = RequestMethod.POST)
	public String addM() {

		return "redirect: mainmp";
	}

	// 원자재 현황 수정, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/updatem", method = RequestMethod.POST)
	public String updateM() {

		return "redirect: mainmp";
	}

	// 원자재 현황 입력취소(undo), 원자재로그 수정, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/undom", method = RequestMethod.POST)
	public String undoM() {

		return "redirect: mainmp";
	}

	// 원자재 현황 삭제, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/deletem", method = RequestMethod.POST)
	public String deleteM() {

		return "redirect: mainmp";
	}

	// 완제품 현황, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/addp", method = RequestMethod.POST)
	public String addP() {

		return "redirect: mainmp";
	}

	// 완제품 현황 수정, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/updatep", method = RequestMethod.POST)
	public String updateP() {

		return "redirect: mainmp";
	}

	// 완제품 현황 입력취소(undo), 완제품로그 수정, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/undop", method = RequestMethod.POST)
	public String undoP() {

		return "redirect: mainmp";
	}

	// 완제품재 현황 삭제, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/deletep", method = RequestMethod.POST)
	public String deleteP() {

		return "redirect: mainmp";
	}
	
	/* 
	 * 입력한(add, update) 데이터 받을 때 어느 dto로 받아올지 생각, 
	 * 또는 2차 프로젝트처럼 httprequestparam으로 받아서 dto에 따로 넣을지
	 *  ajax 사용할 곳 찾아보기
	 *  */ 
	// crud 끝나고 해야할 것 -> 검색 기능, 페이징 처리
}
