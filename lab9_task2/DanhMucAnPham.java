package lab9_task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	List<AnPham> danhSachAnPham;
	
	public double totalMoney() {
		double result = 0;
		for(AnPham ap : danhSachAnPham) {
			result += ap.getPrice();
		}
		return result;
	}
	
	public SachThamKhao getMaxPageSTK() {
		SachThamKhao maxPageBook = null;
		for(AnPham ap : danhSachAnPham) {
			if(ap instanceof SachThamKhao) {
				SachThamKhao stk = (SachThamKhao) ap;
				if(maxPageBook == null || maxPageBook.getNumPage() < stk.getNumPage()) {
					maxPageBook = stk;
				}
			}
		}
		return maxPageBook;
	}
	
	public TapChi getTapChi(String name) {
		for(AnPham ap : danhSachAnPham) {
			if(ap instanceof TapChi) {
				TapChi tc = (TapChi) ap;
				if(tc.getName().equals(name)) {return tc;}
			}
		}
		return null;
	}
	
	
	public List<TapChi> listTapChi1YearOld(){
		List<TapChi> result = new ArrayList<TapChi>();
		for(AnPham ap : danhSachAnPham) {
			if(ap instanceof TapChi) {
				TapChi tc = (TapChi) ap;
				if(tc.isOlderThan1()) {
					result.add(tc);
				}
			}
		}
		return result;
	}
	
	
	
	public List<AnPham> sortByTitleAndName(){
		Collections.sort(danhSachAnPham);
		return danhSachAnPham;
	}
	
	public Map<Integer, Integer> AnPhamAnalyzeByYear(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(AnPham ap : danhSachAnPham) {
			int year = ap.getYear();
			if(map.get(year) == null) map.put(year, 0);
			int i = map.get(year);
			map.put(year, ++i);
		}
		return map;
	}
}
