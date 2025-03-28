package kr.or.webtoon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.webtoon.dto.webtoonDTO;

@Controller
public class webtoonController {
	
	List list = new ArrayList();
	
	@RequestMapping("/webshow")
	public ModelAndView show() {
		
		ModelAndView mav = new ModelAndView("webtoonList");
		
		return mav;
	}
	
	@RequestMapping(value= "/webcon", method=RequestMethod.POST)
	public ModelAndView webcon(webtoonDTO dto) {
		
		System.out.println("form 이미지: " + dto.getImage());
		System.out.println("form 제목: " + dto.getTitle());
		System.out.println("form 작가: " + dto.getAuthor());
		System.out.println("form 설명: " + dto.getExplanation());
				
		list.add(dto);
		
		ModelAndView mav = new ModelAndView("webtoonList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/ajax1")
	@ResponseBody
	public List ajax1(@RequestBody webtoonDTO dto) {
		
		System.out.println("ajax 이미지: " + dto.getImage());
		System.out.println("ajax 제목: " + dto.getTitle());
		System.out.println("ajax 작가: " + dto.getAuthor());
		System.out.println("ajax 설명: " + dto.getExplanation());
		
//		List list = new ArrayList();
		list.add(dto);
		
		
//		List list1 = (List) list.get(list.size() - 1); // 마지막 인덱스를 새로운 리스트에 저장
		// 안되는 이유 - list.get()하면 webtoonDTO가 나오는데 webtooonDTO는 리스트타입으로 캐스트할 수 없다
		
//		webtoonDTO ddto = (webtoonDTO) list.get(list.size() - 1);	// 리턴을 webtoonDTO로 해아한다
		
		
		List list2 = new ArrayList();
		list2.add(list.get(list.size() - 1));		// 마지막 인덱스를 새로운 리스트에 저장
		// 자바에서 처리하는건 옳은 방법이 아니고 자바스크립트로 화면을 한번 초기화하고 받은 리스트를 그린다
		
		return list;
	}
}
