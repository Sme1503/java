package quiz;

public class Game implements GameCharacter {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	
	

	@Override
	public void defence() {
		// TODO Auto-generated method stub
		
	}
	
	void inGame(CharacterJob c) {
		
		if(c instanceof Worrior) {
			Worrior w = (Worrior) c;
			w.d_skill1();
			w.d_skill2();
			w.d_skill3();
		}
		else if(c instanceof Mage) {
			Mage m = (Mage) c;
			m.a_skill1();
			m.a_skill2();
			m.a_skill3();
		}
		else if(c instanceof Priest) {
			Priest p = (Priest) c;
			p.h_skill1();
			p.h_skill2();
			p.h_skill3();
		}
		else if(c instanceof Holyknight) {
			Holyknight h = (Holyknight) c;
			h.d_skill1();
			h.d_skill2();
			h.d_skill3();
			h.h_skill1();
			h.h_skill2();
			h.h_skill3();
		}
		System.out.println();
	}
}
