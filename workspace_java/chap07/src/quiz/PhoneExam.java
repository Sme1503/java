package quiz;

public class PhoneExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone p1 = new Phone();
		
		p1.call("010-1234-1234");
		p1.receive();
		System.out.println();
		
		FeaturePhone fp1 = new FeaturePhone();
		
		fp1.call("010-1234-1234");
		fp1.receive();
		fp1.sendMessage("010-1234-1234");
		System.out.println();

		SmartPhone sp1 = new SmartPhone();
		
		sp1.call("010-1234-1234");
		sp1.receive();
		sp1.sendMessage("010-1234-1234");
		sp1.searchInternet();
		System.out.println();
	
	}

}
