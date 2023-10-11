package lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;





	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}



	public double cost() {
		int result = 0;
		for(int i = 0; i < items.length; i++) {
			result += items[i].getP().getPrice();
		}
		return result;
	}



	// using binary search approach
	public boolean contains(Product p) {
		// TODO
		OrderItem[] arr = this.items;
		sortByID();




		return binarySearch(p, 0, items.length-1);
	}


	public boolean binarySearch(Product p, int left, int right) {
		int mid = ( right + left ) / 2;
		if(right < left)
			return false;
		if(this.items[mid].getP().equals(p))
			return true;
		if(this.items[mid].getP().compareTo(new OrderItem(p,0).getP()) > 0)
			return binarySearch(p, left, --mid);
		else
			return binarySearch(p, ++mid, right);
	}


	public  void sortByID() {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getP().getId().compareTo(o2.getP().getId());
			}
		});
	}


	public void sortByType() {
		Arrays.sort(items, new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getP().compareByType(o2.getP());
			}
		});
	}










	@Override
	public String toString() {
		return "Order [items=" + Arrays.toString(items) + "]";
	}



	// get all products based on the given type using 
	//linear search
	public Product[] filter(String type) {

		sortByType();
		int len = getLen(type, 0);
		if (len == 0) {
			// Trường hợp không có sản phẩm trùng khớp với 'type'
			return new Product[0];
		}
		Product[] products = new Product[len];
		takeOutProducts(products, type, 0, 0);
		return products;
	}

	public int getLen(String type, int count) {
		if(count == this.items.length)
			return 0;
		if(this.items[count].getP().getType().equals(type) )
			return 1 + getLen(type, ++count);
		return getLen(type, ++count);
	}


	public void takeOutProducts(Product[] result, String type, int count, int resultIndex) {
		if(count == result.length)
			return;
		if(this.items[count].getP().getType().equals(type)) {
			result[resultIndex] = this.items[count].getP();
			takeOutProducts(result, type, ++count, ++resultIndex);
		}
		else {
			takeOutProducts(result, type, ++count, resultIndex);
		}


	}

}
