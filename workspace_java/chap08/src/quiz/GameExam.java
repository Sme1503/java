package quiz;

public class GameExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		CharacterJob c1 = new CharacterJob();
//		CharacterJob.Worrior worrior = c1.new Worrior(); 
//		
//		CharacterJob c2 = new CharacterJob();
//		CharacterJob.Mage mage = c2.new Mage();
//		
//		
//		CharacterJob c3 = new CharacterJob();
//		CharacterJob.Priest priest = c3.new Priest();
//		
//		CharacterJob c4 = new CharacterJob();
//		CharacterJob.Holyknight holyknight = c4.new Holyknight();
//		
//		worrior.d_skill1();
		
		
		Worrior worrior = new Worrior();
		Mage mage = new Mage();
		Priest priest = new Priest();
		Holyknight holyknight = new Holyknight();
		
		
		Game g1 = new Game();
		
		g1.inGame(worrior);
		g1.inGame(mage);
		g1.inGame(priest);
		g1.inGame(holyknight);
	}

}
