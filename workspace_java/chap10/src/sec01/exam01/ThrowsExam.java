package sec01.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			test();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test2();
		} catch (NumberFormatException e) {
			if("123".equals(e.getMessage())) {
				System.out.println("의도한 메시지");
			}
		} catch (HumanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
			System.out.println("human");
		}
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("c:\\text.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		// try-with-resource
		// close() 자동 실행
		// Closeable 인터페이스가 있는 클래스만 넣을 수 있다.
		try(
			FileInputStream fis2 = new FileInputStream("c:\\text.txt");
		) {
			System.out.println(fis2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test() throws ClassNotFoundException, IOException {

		Class.forName("asdfa");

	}
	
	static void test2() throws HumanException {
		System.out.println(1);
		int a = 10;
		if(a<100) {			
			throw new HumanException("123");
		} else {			
			throw new NumberFormatException("456");
		}
	}
}
