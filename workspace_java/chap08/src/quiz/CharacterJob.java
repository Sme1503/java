package quiz;

public class CharacterJob implements PassiveSkill {

	@Override
	public void passiveAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passiveDefence() {
		// TODO Auto-generated method stub
		
	}

}

class Worrior extends CharacterJob implements Defence {

	@Override
	public void d_skill1() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어1");
	}

	@Override
	public void d_skill2() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어2");
	}

	@Override
	public void d_skill3() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어3");
	}
	
}

class Mage extends CharacterJob implements Attack {
	
	@Override
	public void a_skill1() {
		// TODO Auto-generated method stub
		System.out.println("맞으면 아픈 공격1");
	}

	@Override
	public void a_skill2() {
		// TODO Auto-generated method stub
		System.out.println("맞으면 아픈 공격2");
	}

	@Override
	public void a_skill3() {
		// TODO Auto-generated method stub
		System.out.println("맞으면 아픈 공격3");
	}
}

class Priest extends CharacterJob implements Heal {

	@Override
	public void h_skill1() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복1");
	}

	@Override
	public void h_skill2() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복2");
	}

	@Override
	public void h_skill3() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복3");
	}
	
}

class Holyknight extends CharacterJob implements Defence, Heal {
	
	@Override
	public void d_skill1() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어1");
	}

	@Override
	public void d_skill2() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어2");
	}

	@Override
	public void d_skill3() {
		// TODO Auto-generated method stub
		System.out.println("방패로 막는 방어3");
	}
	
	@Override
	public void h_skill1() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복1");
	}

	@Override
	public void h_skill2() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복2");
	}

	@Override
	public void h_skill3() {
		// TODO Auto-generated method stub
		System.out.println("몸이 튼튼해지는 회복3");
	}
	
}


