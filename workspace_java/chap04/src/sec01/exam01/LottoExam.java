package sec01.exam01;

public class LottoExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double rand = Math.random();		// 0~0.9*
		double temp1 = rand * 45;			// 0~44.9*
		int temp2 = (int)temp1;				// 0~44
		int lotto1 = temp2+1;				// 1~45
		System.out.println(lotto1);
		System.out.println();
		
		
		
		// 모든 경우의 수
		System.out.println("모든 경우의 수");
		for(int e=1; e<=6; e++) {
			for(int g=1; g<=6; g++) {
				if(e+g==2) {
					System.out.print("2의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==3) {
					System.out.print("3의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==4) {
					System.out.print("4의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==5) {
					System.out.print("5의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==6) {
					System.out.print("6의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==7) {
					System.out.print("7의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==8) {
					System.out.print("8의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==9) {
					System.out.print("9의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==10) {
					System.out.print("10의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==11) {
					System.out.print("11의 경우 ");
					System.out.println(e + ", " + g);
				}
				else if(e+g==12) {
					System.out.print("12의 경우 ");
					System.out.println(e + ", " + g);
				}
				
			}
			System.out.println();
			
			
		}
		System.out.println();
		
		
		
		// 모든 경우의 수 
		System.out.println("모든 경우의 수");
		for(int a=2;a<=12;a++) {
			for(int e=1;e<=6;e++) {
				for(int g=1;g<=6;g++) {
					if(e+g == a) {
						System.out.println(a + "의 경우: "+ e+ ", "+ g);
					}
				}	
			}
			System.out.println();
			//System.out.println(a + "의 경우: "+ cnt);
		}
		System.out.println();
		
		// 모든 경우의 수
		System.out.println("모든 경우의 수");
		for(int a=2;a<=12;a++) {
			System.out.print(a + "의 경우: ");
			
			for(int e=1;e<=6;e++) {
				for(int g=1;g<=6;g++) {
					if(e+g == a) {
						System.out.print(e+ ", "+ g + " | ");
					}
				}	
				
			}
			System.out.println();
		}
		System.out.println();
		
		// 중복제거 경우의 수 
		System.out.println("모든 경우의 수, 중복 안된 개수");
		for(int a=2;a<=12;a++) {
			int cnt = 0;
			//int temp3 = 0;   //e
			//int temp4 = 0;	 //g	
			System.out.print(a + "의 경우: ");
			
			for(int e=1;e<=6;e++) {
				for(int g=1;g<=6;g++) {
					
					if(e+g == a) {
						System.out.print(e+ ", "+ g + " | ");
						
//						if(e<=(a-e)) {			// 중복제거
//							cnt++;
//						}
						
						
						if(e>(a-e)) {			// 중복제거
							break;
						}
						cnt++;
						
						
						
//						temp3 = e;
//						temp4 = g;   
//						if(e == g) {
//							cnt++;
//						}
//						else if(e != g) {
//							cnt++;
//							if(temp3 == g && temp4 == e) {
//								cnt--;
//							}
//						}
//						else if(temp3 == g && temp4 == e) {
//							cnt--;
//						}
						
//						if(e == g) {
//							cnt++;
//						}
//						
//						if(e != g) {
//							cnt++;
//							temp1 = e;
//							temp2 = g;   
//							if() {
//								
//							}
//						}
					}
					
				}	
				
			}
			System.out.println();
			System.out.println(a + "의 경우: "+ cnt+ "가지");
			System.out.println();
		
		}
		
		System.out.println();
		
		
		// 중복 안된 경우의 수
		System.out.println("중복 안된 경우의 수");
		for(int a=2;a<=12;a++) {
			int cnt = 0;
			System.out.print(a + "의 경우: ");
			
			for(int e=1;e<=6;e++) {
				for(int g=1;g<=6;g++) {
					
//					if(e<=(a-e)) {			// 중복제거
//						if(e+g == a) {
//						System.out.print(e+ ", "+ g + " | ");
//						cnt++;
//						}
//					}
					if(e<=(g)) {			// 중복제거
						if(e+g == a) {
						System.out.print(e+ ", "+ g + " | ");
						cnt++;
						}
					}
//					if(e<=(a/2)) {			// 중복제거
//						if(e+g == a) {
//						System.out.print(e+ ", "+ g + " | ");
//						cnt++;
//						}
//					}
				}	
			}
			System.out.println();
			System.out.println(a + "의 경우: "+ cnt+ "가지");
			System.out.println();
		}
		System.out.println();
		
		
	}
}
