package lab9_task2;

public class SachThamKhao extends AnPham {
	String field;

	public SachThamKhao(String title, int pagemNum, int year, String author, double price, String field) {
		super(title, pagemNum, year, author, price);
		this.field = field;
	}
	
	public String getType() {return "Sach Tham Khao";}
	
	
	public int getNumPage(){
		return this.getPageNum();
	}

	@Override
	public String toString() {
		return "SachThamKhao [field=" + field + ", title=" + title + ", pageNum=" + pageNum + ", year=" + year
				+ ", author=" + author + ", price=" + price + "]";
	}
	
	
	
	
}	
