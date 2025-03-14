package quiz;

import java.util.ArrayList;

public class EmpTable {
	
	ArrayList list = new ArrayList();
	
	void add(Emp e) {
		list.add(e);
	}
	
	void print() {
		for(int i=0; i<list.size(); i++) {
			Emp e = (Emp) list.get(i);
			System.out.println(e.empno + " " + e.ename + " " + e.mgr + " " + e.sal);
		}
		System.out.println();
	}
	
	void print_sal(int sal) {
		for(int i=0; i<list.size(); i++) {
			Emp e = (Emp) list.get(i);
			if(e.sal >= sal) {
				System.out.println(e.empno + " " + e.ename + " " + e.mgr + " " + e.sal);
			}
		}
		System.out.println();
	}
	
	void print_mgr(int mgr) {
		for(int i=0; i<list.size(); i++) {
			Emp e = (Emp) list.get(i);
			if(e.mgr >= mgr) {
				System.out.println(e.empno + " " + e.ename + " " + e.mgr + " " + e.sal);
			}
		}
		System.out.println();
	}
	
	void print_ename(String ename) {
		for(int i=0; i<list.size(); i++) {
			Emp e = (Emp) list.get(i);
			//String name = e.ename.substring(ename);
			if(e.ename.equals(ename)) {
				System.out.println(e.empno + " " + e.ename + " " + e.mgr + " " + e.sal);
			}
		}
		System.out.println();
	}
}
