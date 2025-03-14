package quiz;

public class EmpExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 사원 생성
		Emp e1 = new Emp();
		e1.empno = 7369;
		e1.ename = "SMITH";
		e1.mgr = 7902;
		e1.sal = 800;
		
		Emp e2 = new Emp();
		e2.empno = 7788;
		e2.ename = "SCOTT";
		e2.mgr = 7566;
		e2.sal = 3000;
		
		Emp e3 = new Emp();
		e3.empno = 7902;
		e3.ename = "FORD";
		e3.mgr = 7566;
		e3.sal = 3000;
		
		// 테이블 생성
		EmpTable eTable = new EmpTable();
		
		// 추가
		eTable.add(e1);
		eTable.add(e2);
		eTable.add(e3);

		// 출력
		eTable.print();
		eTable.print_sal(2000);
		
	}

}
