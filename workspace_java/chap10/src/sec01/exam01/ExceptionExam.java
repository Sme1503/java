package sec01.exam01;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
			
		}
		
		int a = 10;
		String b = "100sd";
		
		try {
			a = Integer.parseInt(b);
			
			Class clasz = Class.forName("java.lang.String2");
			
			System.out.println("실행");
		}catch(Exception e) {
			System.out.println("catch 블럭");
			System.out.println(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally 실행");
		}
		
		System.out.println("end");
	}
}