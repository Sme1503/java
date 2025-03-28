package sec01.exam01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "c:\\temp";
		String fileName = "test.txt";
		
//		OutputStream os = new FileOutputStream(path + "\\"+ fileName);
		OutputStream os = null;
		try {
			os = new FileOutputStream(path + System.getProperty("file.separator")+ fileName);
			
			String data = "abc\n한글\n123";
			byte[] datas = data.getBytes();
			
			// 쓰기
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		// try-with-resources
		try(
			OutputStream os3 = new FileOutputStream(path + "\\" + fileName);
		){
			String data = "abc\n한글\n1231231234545";
			byte[] datas = data.getBytes();
			
			// 쓰기
			os3.write(datas, 0, datas.length);
			os3.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
