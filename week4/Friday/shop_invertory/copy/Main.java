package week4.Friday.shop_invertory.copy;

import java.util.ArrayList;
import java.util.List;

import week4.Friday.vat_tax_calculator.CountryVatTax;
import week4.Friday.vat_tax_calculator.VatTaxCalculator;

public class Main {

	public static void main(String[] args) {
		
		List<CountryVatTax> countries = new ArrayList<>();
		countries.add(new CountryVatTax("bg", 20, true));
		countries.add(new CountryVatTax("ru", 15, false));
		countries.add(new CountryVatTax("ita", 30, false));
	
		VatTaxCalculator.addCountries(countries);
		
		Inventory inventory = new Inventory();
		inventory.addProduct(new Product(1, "table", 120.0, "ru", 10));
		inventory.addProduct(new Product(2, "chair", 40.0, "ru", 20));
		inventory.addProduct(new Product(3, "bad", 230.0, "ita", 5));
		inventory.addProduct(new Product(4, "sofa", 80.0, "ita", 2));
		inventory.addProduct(new Product(5, "desk", 90.0, "bg", 8));
		
		System.out.println(inventory.Audit());
		
		Order order = new Order(4, 2);
		order.addProduct(2, 10); 
		
		double price = inventory.RequestOrder(order);
		System.out.println(price);
		
		System.out.println(inventory.Audit());
		System.out.println(inventory.getPoduct(4));
		inventory.increaseQuantity(4, 10);
		System.out.println(inventory.getPoduct(4));
		System.out.println(inventory);
	}

}
