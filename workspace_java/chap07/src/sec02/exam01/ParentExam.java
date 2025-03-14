package sec02.exam01;

public class ParentExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parent3_1 p3_1 = new Parent3_1();
		
		Parent2_1 p2_1 = (Parent2_1) p3_1;
		p2_1 = p3_1;
		
		Parent1 p1 = p2_1;
		
		p1 = p3_1;
		
		Parent1 p1_1 = new Parent3_1();
		//////////////////////////////////
		Parent1 p1_2 = new Parent2_2();
		
//		p1_1 = p1_2;
		
		Parent2_1 pp21 = (Parent2_1)p1_1;
		// 런타임 에러 : 실행해봐야 하는 오류
		Parent2_1 pp22 = (Parent2_1)p1_2;
	}

}
