package lab9_task2;

public class TapChi extends AnPham {
	String name;

	public TapChi(String title, int pagemNum, int year, String author, double price, String name) {
		super(title, pagemNum, year, author, price);
		this.name = name;
	}
	
	public String getType() {return "Tap Chi";}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isOlderThan1() {return (2021 - this.getYear() >= 1);}
	
}
