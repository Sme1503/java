package sec05.exam02._static;

public class Constant {
	
	static final int LOGIN_SUCCESS = 1;
	static final int LOGIN_FAIL = 2;
	static final int LOGIN_PW_90 = 3;
	static final int LOGIN_TEMP_PW = 4;
}

class ConstExam {
	public static void main(String a[]) {
		int result = loginCheck("root", "abcd");
		
		if(result == Constant.LOGIN_SUCCESS) {
			System.out.println("로그인 성공");
		} else if(result == Constant.LOGIN_FAIL) {
			System.out.println("로그인 실패");
		}
	}
	
	static int loginCheck(String id, String pw) {
		if("admin".equals(id) && "1234".equals(pw)) {
			return Constant.LOGIN_SUCCESS;
		} else {
			return Constant.LOGIN_FAIL;
		}
	}
}