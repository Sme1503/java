package sec01.exam01;

public class Radio implements RemoteControl {

	int vol;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVolume(int vol) {
		// TODO Auto-generated method stub
		if(vol <= MAX_VOLUME && vol >= MIN_VOLUME) {
			this.vol = vol;
		} else {
			System.out.println("0~10 사이 값을 입력하세요");
		}
	}

}
