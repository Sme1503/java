package sec03.exam01;

public class KimbobExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kimbob 천안역점 = new Kimbob(1000);
		천안역점.order(0);
		
		천안역점.print(0, 3);
		천안역점.add("참치김밥", 5000);
		천안역점.allMenu();
		
		System.out.println(천안역점.menu);
	}

}
