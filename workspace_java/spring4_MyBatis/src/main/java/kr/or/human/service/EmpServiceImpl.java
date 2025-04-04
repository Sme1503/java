package kr.or.human.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human.dao.EmpDAO;
import kr.or.human.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List getEmpList() {
	
		List list = empDAO.selectEmpList();
		
		return list;
	}

	@Override
	public EmpDTO getEmpOne() {
		
		EmpDTO dto = empDAO.selectOneEmp();
		
		return dto;
	}

	@Override
	public EmpDTO getEmpnoOne(int i) {
		
		EmpDTO dto = empDAO.selectOneEmpno(i);
		
		return dto;
	}
	
	@Override
	public EmpDTO getEmpno(EmpDTO dto) {
		
		EmpDTO dto1 = empDAO.selectEmpno(dto);
		
		return dto1;
	}

	@Override
	public int modifyEmp(EmpDTO dto) {
		
		int i = empDAO.updateEmp(dto);
		
		return i;
	}

	@Override
	public int insertEmp(EmpDTO dto) {
		
		int i = empDAO.insertEmp(dto);
		
		return i;
	}

	@Override
	public int deleteEmp(EmpDTO dto) {
		
		int i = empDAO.deleteEmp(dto);
		
		return i;
	}

	@Override
	public List getSearch(String ename) {
		
		List list = empDAO.selectSearch(ename);
		
		return list;
	}
	
	@Override
	public Map<String, Object> getEmpSearchList(EmpDTO dto) {
		
		if("ename".equals(dto.getType())) {
			dto.setEname(dto.getKeyword());
		} else if("sal".equals(dto.getType())) {
			try {
				int sal = Integer.parseInt(dto.getKeyword());				
				dto.setSal(sal);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 보여줄 시작, 끝 index 찾기
		int page = dto.getPage();
		int viewCount = dto.getViewCount();
		
		int indexStart = (viewCount * (page -1)) + 1;
		int indexEnd = page * viewCount;
		
		dto.setIndexStart(indexStart);
		dto.setIndexEnd(indexEnd);
		
		// 한 페이지의 내용만 있는 리스트
		List list = empDAO.selectEmpSearchList(dto);
		
		// 전체 글 개수
		int total = empDAO.totalList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("total", total);
		
		return map;
	}

}
