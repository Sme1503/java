package kr.or.ktpn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.tb_fs_1000ht_DTO;
import kr.or.ktpn.dto.tb_fs_1000mt_DTO;
import kr.or.ktpn.dto.tb_mr_1000ht_DTO;
import kr.or.ktpn.dto.tb_mr_1000mt_DTO;
import kr.or.ktpn.service.Svc_md_1000mt;
import kr.or.ktpn.service.Svc_member;
import kr.or.ktpn.service.Svc_tb_fs_1000ht;
import kr.or.ktpn.service.Svc_tb_fs_1000mt;
import kr.or.ktpn.service.Svc_tb_mr_1000ht;
import kr.or.ktpn.service.Svc_tb_mr_1000mt;
import kr.or.ktpn.service.Svc_tb_od_1000mt;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;

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
	
	
	
	@Autowired
	Svc_member svc_member;
	
	@Autowired
	Svc_md_1000mt svc_md_1000mt;
	
	@Autowired
	TAK_Svc_pr_1100mt tak_Svc_pr_1100mt;
	

	
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

	
	
	
	
	
	
	
	
	// 테스트 페이지(원자재추가) - 작업자, 원자재 코드, 원자재명 보여주는 메소드
	@RequestMapping(value = "/addm1", method = RequestMethod.GET)
	public String addM1(Model model) {
		
		// 작업자
		List workerList = svc_member.getWorker();
		
		// 기준관리 - 원자재 코드, 원자재명
		List McodeList = svc_md_1000mt.getMcodeList();
		
		model.addAttribute("mList", workerList);
		model.addAttribute("mcList", McodeList);

		return "TestMM_add2_park.tiles";
	}
	
	// 원자재 현황, 원자재로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/addm2", method = RequestMethod.POST)
	public String addM2(tb_mr_1000ht_DTO mlogdto) {
		
		List list = new ArrayList();
		tb_mr_1000mt_DTO mdto = new tb_mr_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + mlogdto);
		
		if("i".equals(mlogdto.getIob_se_cd())) {		// 입고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {		// 원자재 현황테이블에 데이터가 없을 경우
				mdto.setMtrl_cd(mlogdto.getMtrl_cd());
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setStn_cnt(1000);
				mdto.setCrnt_aftr_cnt(0 + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				
				i = svc_mr_1000mt.insertMaterials(mdto);
				System.out.println("입력한 데이터 : " + mdto);
				System.out.println("원자재 현황 테이블에 " + i + "행이 삽입되었습니다");
				
				if(i > 0) {
					check = true;
				}
			} else {					// 원자재 현황테이블에 데이터가 있을 경우
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);

				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() >= 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
		else if("o".equals(mlogdto.getIob_se_cd())) { 		// 출고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() - mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
			
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);
				
				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() >= 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
			
		}
		
		if(check == true) {
			mlogdto.setStn_cnt(mdto.getStn_cnt());
			mlogdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt());
			mlogdto.setOrdr_rqrd_yn(mdto.getOrdr_rqrd_yn());
			
			mlogdto.setChng_dt(mlogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Mlog 데이터 : " + mlogdto);

			i = svc_mr_1000ht.insertMlog(mlogdto);
			System.out.println("원자재 로그테이블에 " + i + "행이 삽입되었습니다");

		}
		

		return "redirect: mainmp";
	}
	
	// 테스트 페이지(원자재수정) - 작업자, 원자재 코드, 원자재명 보여주는 메소드
	@RequestMapping(value = "/updatem1", method = RequestMethod.GET)
	public String updateM1(Model model, String mcode) {
		
		System.out.println("mcode : " + mcode);
		
		// 작업자
		List workerList = svc_member.getWorker();
			
		// 수정할 리스트
		List materials = svc_mr_1000mt.getMaterials(mcode);
		System.out.println("materials : " + materials);

		tb_mr_1000mt_DTO dto = new tb_mr_1000mt_DTO();
		dto = (tb_mr_1000mt_DTO) materials.get(0);
		System.out.println("dto : " + dto);
		
		
		model.addAttribute("mList", workerList);
		model.addAttribute("dto", dto);
		

		return "TestMM_update_park.tiles";
	}
		
	// 원자재 현황 수정, 원자재로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/updatem2", method = RequestMethod.GET)
	public String updateM2(Model model) {
			
		

		return "redirect: mainmp";
	}
	
	
	
	
	// 테스트 페이지(완제품추가) - 작업자, 생산완료인 완제품 코드, 완제품명 보여주는 메소드
	@RequestMapping(value = "/addp1", method = RequestMethod.GET)
	public String addP1(Model model) {
			
		// 작업자
		List workerList = svc_member.getWorker();
			
		// 생산 - 생산코드, 완제품 코드, 완제품명
		List PcodeList = tak_Svc_pr_1100mt.getPcode();
		
		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PcodeList);

		return "TestMM_addP2_park.tiles";
	}
	
	// 생산완료인 완제품 현황, 완제품로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/addp2", method = RequestMethod.POST)
	public String addP2(tb_fs_1000ht_DTO plogdto) {
				
		List list = new ArrayList();
		tb_fs_1000mt_DTO pdto = new tb_fs_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + plogdto);
		
		if("i".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());
			
			if(list == null) {
				pdto.setFnsh_code(plogdto.getFnsh_code());
				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(0 + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				i = svc_fs_1000mt.insertProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 삽입되었습니다");

				if(i > 0) {
					check = true;
				}
			} else {				
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				i = svc_fs_1000mt.updateProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				System.out.println("수정 후 데이터: " + pdto);

				
				if(i > 0) {
					check = true;
				}
			}
				
		} else if("o".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());

			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() - plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				if(pdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(pdto.getCrnt_aftr_cnt() > 0) {
					i = svc_fs_1000mt.updateProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				
					if(i > 0) {
						check = true;
					}
				} else {
					i = svc_fs_1000mt.deleteProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 삭제되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
			
		if(check == true) {
			plogdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt());
			plogdto.setChng_dt(plogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Plog 데이터 : " + plogdto);

			i = svc_fs_1000ht.insertPlog(plogdto);
			System.out.println("완제품 로그테이블에 " + i + "행이 삽입되었습니다");

		}
		
		return "redirect: mainmp";
	}
	
	// 테스트 페이지(완제품수정) - 작업자, 생산완료인 완제품 코드, 완제품명 보여주는 메소드
	@RequestMapping(value = "/updatep1", method = RequestMethod.GET)
	public String updateP1(Model model, String code) {
				
		// 작업자
		List workerList = svc_member.getWorker();
				
		// 생산 - 생산코드, 완제품 코드, 완제품명
		List PcodeList = svc_tb_fs_1000mt;
			
		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PcodeList);

		return "TestMM_updateP_park.tiles";
	}
		
	// 생산완료인 완제품 현황 수정, 완제품로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/updatep2", method = RequestMethod.GET)
	public String updateP2(Model model) {
				
		

		return "redirect: mainmp";
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
