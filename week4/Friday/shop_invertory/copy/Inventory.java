package week4.Friday.shop_invertory.copy;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	private Map<Integer, Product> invetory;

	public Inventory() {
		invetory = new HashMap<>();
	}

	public void addProduct(Product p) {
		if (!invetory.containsKey(p.getProductId())) {
			invetory.put(p.getProductId(), p);
		} else {
			System.out.println("product with that ID already exist");
		}

	}
	
	public String toString() {
		return invetory.toString();
	}
	
	public void increaseQuantity(Integer productId, Integer quantity) {
		if (invetory.containsKey(productId)) {
			invetory.get(productId).add(quantity);
		} else {
			System.out.println("Product do not Exist, firs add product");
		}
	}
	
	public Product getPoduct(Integer productId) {
		return invetory.get(productId);
	}
	
	public double Audit() {
		double res = 0;
		Product item;
		for (Map.Entry<Integer, Product> entry : invetory.entrySet()) {
			item = entry.getValue();
			res += item.getPrice() * item.getQuantity();
		}
		return res;
	}

	public Double RequestOrder(Order r) {
		Double res = 0.0;
		Product product;
		for (Map.Entry<Integer, Integer> entry : r) {
			if (invetory.containsKey(entry.getKey())) {
				product = invetory.get(entry.getKey());
			} else {
				// throw new NotAvailableInInventoryException("");
				System.out.println("NotAvailableInInventoryException");
				return res;
			}
			if (product.getQuantity() >= entry.getValue()) {
				product.setQuantity(product.getQuantity() - entry.getValue());
				res += entry.getValue() * product.getPrice();
			} else {
				// throw new NotAvailableInInventoryException("");
				System.out.println("NotAvailableInInventoryException");
			}
		}
		return res;
	}
}
