package quiz;

public class Movie {
	
	String title;
	int year;
	
	Movie(String e){
		this.title = e;
	}
	
	Movie(String e, int n){
		this.title = e;
		this.year = n;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	void setYear(int n) {
		this.year = n;
	}
	
	void print() {
		System.out.println(this.title+", "+year);
	}
}
