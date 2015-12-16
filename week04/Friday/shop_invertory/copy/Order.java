package week04.Friday.shop_invertory.copy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Order implements Iterable<Map.Entry<Integer, Integer>>{
	
	private Map<Integer, Integer> products;

	public Order() {
		products = new HashMap<>();
	}
	
	public Order(Integer id, Integer quantity) {
		this();
		addProduct(id, quantity);	
	}
	
	public void addProduct(Integer id, Integer quantity) {
		products.put(id, quantity);
	}
	
	@Override
	public Iterator<Map.Entry<Integer, Integer>> iterator() {
		return products.entrySet().iterator();
	}
	
}
