package week04.Friday.shop_invertory.copy;

import week04.Friday.vat_tax_calculator.VatTaxCalculator;

public class Product {

	private Integer productId;
	private String name;
	private double price;
	private double priceWithVat ;
	private String country;
	private int quantity;
	
	public Product(Integer productId, String name, double price, String country, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.country = country;
		this.quantity = quantity;
		this.priceWithVat = addVatTax();
	}
	
	public String toString() {
		return String.format("(productId:%d name:%s price:%.2f priceWithVat:%.2f countryId:%s quantity:%d)", 
				productId, name, price, priceWithVat, country, quantity);
	}
	
	private double addVatTax() {
		return price + VatTaxCalculator.calculateTax(price, country);
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getOuntry() {
		return country;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void add(Integer q) {
		quantity += q;
	}

}
