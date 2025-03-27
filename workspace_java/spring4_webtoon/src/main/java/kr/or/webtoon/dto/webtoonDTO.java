package kr.or.webtoon.dto;

public class webtoonDTO {
	
	private String image;
	private String title;
	private String author;
	private String explanation;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	
	@Override
	public String toString() {
		return "webtoonDTO [image=" + image + ", title=" + title + ", author=" + author + ", explanation=" + explanation
				+ "]";
	}
	
	
}
