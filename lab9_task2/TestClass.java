package lab9_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestClass {
	  public static void main(String[] args) {
		  // Create instances of TapChi and SachThamKhao for testing
	        TapChi tapChi1 = new TapChi("TapChi1", 100, 2020, "Author1", 25.0, "Name1"); // Change pageNum to int
	        TapChi tapChi2 = new TapChi("TapChi2", 120, 2021, "Author2", 30.0, "Name2"); // Change pageNum to int
	        SachThamKhao sachThamKhao1 = new SachThamKhao("Sach1", 200, 2022, "Author3", 40.0, "Field1"); // Change pageNum to int
	        SachThamKhao sachThamKhao2 = new SachThamKhao("Sach2", 250, 2022, "Author4", 35.0, "Field2"); // Change pageNum to int

	        // Create a list of AnPham objects for testing
	        List<AnPham> danhSachAnPham = new ArrayList<>();
	        danhSachAnPham.add(tapChi1);
	        danhSachAnPham.add(tapChi2);
	        danhSachAnPham.add(sachThamKhao1);
	        danhSachAnPham.add(sachThamKhao2);

	        // Create an instance of DanhMucAnPham
	        DanhMucAnPham danhMuc = new DanhMucAnPham();
	        danhMuc.danhSachAnPham = danhSachAnPham;

	        // Test totalMoney() method
	        double totalMoney = danhMuc.totalMoney();
	        System.out.println("Total money spent on publications: " + totalMoney);

	        // Test getMaxPageSTK() method
	        SachThamKhao maxPageSTK = danhMuc.getMaxPageSTK();
	        if (maxPageSTK != null) {
	            System.out.println("Max pages in SachThamKhao: " + maxPageSTK.getNumPage());
	        } else {
	            System.out.println("No SachThamKhao found.");
	        }

	        // Test getTapChi(String name) method
	        TapChi foundTapChi = danhMuc.getTapChi("Name1");
	        if (foundTapChi != null) {
	            System.out.println("Found TapChi with name 'Name1'.");
	        } else {
	            System.out.println("TapChi with name 'Name1' not found.");
	        }

	        // Test listTapChi1YearOld() method
	        List<TapChi> tapChiOlderThan1Year = danhMuc.listTapChi1YearOld();
	        System.out.println("TapChi older than 1 year:");
	        for (TapChi tc : tapChiOlderThan1Year) {
	            System.out.println(tc.getTitle());
	        }

	        // Test sortByTitleAndName() method
	        List<AnPham> sortedList = danhMuc.sortByTitleAndName();
	        System.out.println("Sorted list by title and name:");
	        for (AnPham ap : sortedList) {
	            System.out.println(ap.getTitle() + " - " + ap.getAuthor());
	        }

	        // Test AnPhamAnalyzeByYear() method
	        Map<Integer, Integer> analyzeByYear = danhMuc.AnPhamAnalyzeByYear();
	        System.out.println("Publication count by year:");
	        for (Map.Entry<Integer, Integer> entry : analyzeByYear.entrySet()) {
	            System.out.println("Year: " + entry.getKey() + " - Count: " + entry.getValue());
	        }
	    }

}
