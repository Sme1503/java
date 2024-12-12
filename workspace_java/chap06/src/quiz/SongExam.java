package quiz;

public class SongExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Song song1 = new Song();              // 새로운 song1 객체 생성
		Song song2 = new Song();              // 새로운 song2 객체 생성
		Song song3 = new Song();              // 새로운 song3 객체 생성
		
		// 제목과 가수명을 넣고 
		// 제목, 가수명, 좋아요수를 출력
		
		song1.title = "홈 스윗 홈";
		song1.singer = "지드래곤";
		song1.like = 11000;
		
		System.out.println("제목: "+song1.title);
		System.out.println("가수명: "+song1.singer);
		System.out.println("좋아요 수: "+song1.like);
				
		song2.title = "아파트";
		song2.singer = "로제_브르노마스";
		song2.like = 11000;
		
		System.out.println("제목: "+song2.title);
		System.out.println("가수명: "+song2.singer);
		System.out.println("좋아요 수: "+song2.like);
		
		song3.setTitle("위플래시");
		System.out.println("제목: "+song3.title);
		
	}

}
