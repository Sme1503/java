package sec01.exam01;

public class Tv implements RemoteControl, Searchable {

	int vol;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("tv를 끕니다");
	}

	@Override
	public void setVolume(int vol) {
		// TODO Auto-generated method stub
		if(vol <= RemoteControl.MAX_VOLUME && vol >= RemoteControl.MIN_VOLUME) {	
			this.vol = vol;
			System.out.println(vol + "로 볼륨을 바꿉니다");
		} else {
			if(vol > RemoteControl.MAX_VOLUME) {
				this.vol = RemoteControl.MAX_VOLUME;
				System.out.println(vol + "로 볼륨을 바꿀 수 없습니다. 0~10사이 값을 입력하세요.");
			} else {
				this.vol = RemoteControl.MIN_VOLUME;
				System.out.println(vol + "로 볼륨을 바꿀 수 없습니다");				
			}
		}
		
	}

	@Override
	public void search(String text) {
		// TODO Auto-generated method stub
		System.out.println("TV로 " + text +"를 검색하는 중...");
	}

}
