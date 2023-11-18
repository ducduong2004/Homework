package lab9_task2;

public class AnPham implements Comparable<AnPham> {
	protected String title;
	protected int pageNum;
	protected int year;
	protected String author;
	protected double price;

	AnPham(String title, int pageNum, int year, String author, double price){
		this.title = title;
		this.pageNum = pageNum;
		this.year = year;
		this.author = author;
		this.price = price;

	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public boolean tenYearCheck() {return (2021 - this.year >= 10);}
	public String getType() {return "AnPham";}
	public boolean isSame(AnPham ap1, AnPham ap2) {return (ap1.getType().equals(ap2.getType()) && ap1.getAuthor().equals(ap2.getAuthor()));}



	@Override
	public int compareTo(AnPham o) {
		int CompareByTitle = this.getTitle().compareTo(o.getTitle());
		if(CompareByTitle != 0)return CompareByTitle;
		return o.getYear() - this.getYear();
	}


	
	
	

}
