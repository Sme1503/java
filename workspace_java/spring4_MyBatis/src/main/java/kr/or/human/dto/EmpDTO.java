package kr.or.human.dto;
import java.sql.Date;
import java.util.List;

import lombok.Data;


// DTO : Data Transfer Object
// VO : Value Object
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor // 생성자
//@EqualsAndHashCode
@Data		// 이거 하나가 위의 5가지를 다 포함한다
public class EmpDTO {

	private int empno;		// 사원번호
	private String ename;	// 사원명
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal = -1;
	private Integer comm;
	private int deptno;
	
	private String type;
	private String keyword;
	
	private List empnos;
	
	private int page = 1;		// 현재 페이지
	private int viewCount = 10;	// 페이지당 보여줄 수 countPerPage rowPerPage
	private int indexStart;
	private int indexEnd;
	
	
	
	
	
	
	
}
