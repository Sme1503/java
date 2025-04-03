package kr.or.human.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.human.dto.EmpDTO;
import kr.or.human.service.EmpService;
import kr.or.human.service.EmpServiceImpl;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	// 전체 emp목록을 console에서 보여주는 메소드
	@RequestMapping(value = "/empin", method = RequestMethod.GET)
	public String listEmp() {

		List<EmpDTO> list = empService.getEmpList();
		List list1 = empService.getEmpList();

		for (int i = 0; i < list.size(); i++) {

//			EmpDTO dto = (EmpDTO) list1.get(i);
//			System.out.println("emp : " + dto);

			System.out.println("emp : " + list.get(i));
			System.out.println("emp : " + (EmpDTO) list1.get(i));
		}

		return "emp";
	}

	// 전체 emp목록을 emp.jsp에 보여주는 메소드
	@RequestMapping(value = "/empin1", method = RequestMethod.GET)
	public ModelAndView listEmp1() {

		List<EmpDTO> list = empService.getEmpList();
		List list1 = empService.getEmpList();

		for (int i = 0; i < list.size(); i++) {

//			EmpDTO dto = (EmpDTO) list1.get(i);
//			System.out.println("emp : " + dto);

			System.out.println("emp : " + list.get(i));
//			System.out.println("emp : " + (EmpDTO) list1.get(i));
		}

		ModelAndView mav = new ModelAndView("emp");
		mav.addObject("emplist", list);

		return mav;
	}

	// emp하나만 console에 보여주는 메소드
	@RequestMapping(value = "/empOne", method = RequestMethod.GET)
	public String EmpOne() {

		EmpDTO dto = empService.getEmpOne();

		System.out.println("controller dto : " + dto);

		return "emp";
	}

	// empno가 ? 인 emp하나만 console에 보여주는 메소드 - 매개변수가 int
	@RequestMapping(value = "/empnoOne", method = RequestMethod.GET)
	public String EmpnoOne(@RequestParam("empno") int i) {

		EmpDTO dto = empService.getEmpnoOne(i);

		System.out.println("controller dto : " + dto);

		return "emp";
	}

	// empno가 ? 인 emp하나만 console에 보여주는 메소드 - 매개변수가 EmpDTO
	@RequestMapping(value = "/empno", method = RequestMethod.GET)
	public String Empno(@ModelAttribute EmpDTO dto) {

		EmpDTO dto1 = empService.getEmpno(dto);

		System.out.println("controller dto : " + dto1);

		return "emp";
	}

	// empno가 ?인 emp만 emp.jsp에 보여주는 메소드
	@RequestMapping(value = "/empnoList", method = RequestMethod.GET)
	public ModelAndView EmpnoList(EmpDTO dto) {

		EmpDTO dto1 = empService.getEmpno(dto);
		List list = new ArrayList();
		list.add(dto1);

		System.out.println("controller dto : " + dto1);

		ModelAndView mav = new ModelAndView("emp");
		mav.addObject("emplist", list);

		return mav;
	}

	// empno가 ?인 emp만 emp2.jsp에 보여주는 메소드
	@RequestMapping(value = "/choiceempno", method = RequestMethod.GET)
	public ModelAndView choiceEmpno(EmpDTO dto) {

		EmpDTO dto1 = empService.getEmpno(dto);
		List list = new ArrayList();
		list.add(dto1);

		System.out.println("controller dto : " + dto1);

		ModelAndView mav = new ModelAndView("emp2");
		mav.addObject("emplist", list);

		return mav;
	}

	// 전체 emp목록을 allEmp.jsp에 보여주는 메소드
	@RequestMapping(value = "/allEmp", method = RequestMethod.GET)
	public String AllEmp(Model model,
			EmpDTO dto
			) {
		
		System.out.println(dto);
		
		int page = 3;
		int viewCount = 3;
		
		dto.setPage(page);
		dto.setViewCount(viewCount);
		
		
//		List<EmpDTO> list = empService.getEmpList();
		List<EmpDTO> list = empService.getEmpSearchList(dto);
		System.out.println("controller dto : " + list);

		model.addAttribute("list", list);

		return "allEmp";
	}

	// empno가 ?인 emp만 detailEmp.jsp에 보여주는 메소드
	@RequestMapping(value = "/detailEmp", method = RequestMethod.GET)
	public String detailEmp(@ModelAttribute EmpDTO dto,

			Model model) {

		EmpDTO dto1 = empService.getEmpno(dto);

		System.out.println("controller dto : " + dto1);

		model.addAttribute("dto", dto1);

		return "detailEmp";
	}

	// empno가 ?인 emp만 modifyEmp_form.jsp에 보여주는 메소드
	@RequestMapping(value = "/modifyEmp_form", method = RequestMethod.GET)
	public String modifyEmp_form(@ModelAttribute EmpDTO dto,

			Model model) {

		EmpDTO dto1 = empService.getEmpno(dto);

		System.out.println("controller dto : " + dto1);

		model.addAttribute("dto", dto1);

		return "modifyEmp_form";
	}
	
	// empno가 ?인 emp만 modifyEmp.jsp에 보여주는 메소드
		@RequestMapping(value = "/modifyEmp", method = RequestMethod.GET)
		public String modifyEmp(@ModelAttribute EmpDTO dto,

				Model model) {

			EmpDTO dto1 = empService.getEmpno(dto);

			System.out.println("controller dto : " + dto1);

			model.addAttribute("dto", dto1);

			return "modifyEmp";
		}

	// 실제 업데이트하는 메소드	- form
	@RequestMapping(value = "/allEmp0", method = RequestMethod.POST)
	public String modifyEmp2(@ModelAttribute EmpDTO dto,

			Model model) {
		
		System.out.println("수정하는 dto :" + dto);

		// 업데이트 작동
		int i = empService.modifyEmp(dto);

		return "redirect:allEmp";
	}

	// 실제 업데이트하는 메소드 - ajax
	// ajax를 사용할 때는 @RequestBody, @ResponseBody를 사용해야한다. @ModelAttribute는 form(get, post)또는 쿼리스트링 방식만 가능
	@PutMapping("/allEmp1")
//	@RequestMapping(value = "/allEmp1", method = RequestMethod.PUT) // 위에 @PutMapping이랑 같은 코드
	@ResponseBody
	public String updateEmp(@RequestBody EmpDTO dto,

			Model model) {

		System.out.println("수정하는 dto :" + dto);

		// 업데이트 작동
		int i = empService.modifyEmp(dto);

		String j = i + "";

		System.out.println("i : " + i);
		if (i == 1) {
			System.out.println("업데이트한 행은 " + i + "개입니다");
			return j;

		} else {
			System.out.println("업데이트한 행은 " + i + "개입니다");
			return j;
		}
	}

	// insertEmp.jsp를 보여주는 메소드
	@RequestMapping(value = "/insertEmp", method = RequestMethod.GET)
	public String insertEmp() {

		return "insertEmp";

	}

	// 실제로 추가하는 메소드
	@RequestMapping(value = "/allEmp3", method = RequestMethod.POST)
	public String insertEmp1(@ModelAttribute EmpDTO dto) {

		System.out.println("추가하는 dto :" + dto);
		int i = empService.insertEmp(dto);

		return "redirect:allEmp";

	}

	// 삭제
	@RequestMapping(value = "/allEmp4", method = RequestMethod.POST)
	public String deleteEmp(@ModelAttribute EmpDTO dto) {

		System.out.println("삭제하는 dto :" + dto);
		int i = empService.deleteEmp(dto);

		return "redirect:allEmp";

	}
	
	// joinEmp.jsp를 보여주는 메소드
	@RequestMapping(value = "/joinEmp", method = RequestMethod.GET)
	public String joinEmp() {

		return "joinEmp";

	}
	
	// 실제로 추가하는 메소드 ajax - fetch 사용
	@ResponseBody
	@RequestMapping(value = "/joinEmp", method = RequestMethod.POST)
	public int joinEmpPost(
			@RequestBody
			EmpDTO empDTO
	) {
		System.out.println("empDTO: " + empDTO);
		
		int i = empService.insertEmp(empDTO);	
		System.out.println("i : " + i);
		
		return i;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchEmp(String ename) {

		List list = empService.getSearch(ename);
		System.out.println("list : " + list);
		
		return "allEmp";

	}
	
	// 검색해서 나온 결과를 리턴하는 메소드
	@RequestMapping(value = "/searchEmpList", method = RequestMethod.GET)
	public String searchEmp1(Model model, EmpDTO dto) {
		
		System.out.println("dto : " + dto);
		
		List list = empService.getEmpSearchList(dto);
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		
		return "allEmp";
	}
	
	// 검색해서 나온 결과를 리턴하는 메소드 - ajax
	// ajax - get : @requestBody 사용하면 안된다, json으로 받을 수 없음. @ModelAttribute이나 @RequestParam을 사용해야한다
	// ajax - get이 아닌 메소드 : @requestBody를 사용해서 json으로 받아야한다
	@ResponseBody
	@RequestMapping(value = "/searchEmpList1")
	public List searchEmp2(Model model, 
			
			EmpDTO dto) {
		
		System.out.println("dto : " + dto);
		
		List list = empService.getEmpSearchList(dto);
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		
		return list;
	}
}
