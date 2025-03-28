package kr.or.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.or.human.dto.EmpDTO;
import kr.or.human.service.EmpService;
import kr.or.human.service.EmpServiceImpl;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/empin", method = RequestMethod.GET)
	public String listEmp() {
		
		List<EmpDTO> list = empService.getEmpList();
		List list1 = empService.getEmpList();
		
		for(int i=0; i<list.size(); i++) {
			
//			EmpDTO dto = (EmpDTO) list1.get(i);
//			System.out.println("emp : " + dto);
			
			System.out.println("emp : " + list.get(i));
			System.out.println("emp : " + (EmpDTO) list1.get(i));
		}
		
		
		return "emp";
	}
	
	@RequestMapping(value="/empin1", method = RequestMethod.GET)
	public ModelAndView listEmp1() {
		
		List<EmpDTO> list = empService.getEmpList();
		List list1 = empService.getEmpList();
		
		for(int i=0; i<list.size(); i++) {
			
//			EmpDTO dto = (EmpDTO) list1.get(i);
//			System.out.println("emp : " + dto);
			
			System.out.println("emp : " + list.get(i));
//			System.out.println("emp : " + (EmpDTO) list1.get(i));
		}
		
		ModelAndView mav = new ModelAndView("emp");
		mav.addObject("emplist", list);
		
		return mav;
	}
}
