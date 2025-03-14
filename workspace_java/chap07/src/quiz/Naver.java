package quiz;

public class Naver extends Function {
	
	@Override
	boolean join(String name, String id, String pw) {
		// TODO Auto-generated method stub
		return super.join(name, id, pw);
	}
	
	@Override
	String findId(String name) {
		// TODO Auto-generated method stub
		return super.findId(name);
	}
	
	@Override
	String findPw(String name, String id) {
		// TODO Auto-generated method stub
		return super.findPw(name, id);
	}
	
	
	
	
	public Naver(String siteName) {
		
		super.siteName = siteName;
	}
}
