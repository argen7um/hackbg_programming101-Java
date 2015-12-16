package week04.Friday.vat_tax_calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<CountryVatTax> countries = new ArrayList<>();
		countries.add(new CountryVatTax("bg", 20, true));
		countries.add(new CountryVatTax("ru", 15, false));
		countries.add(new CountryVatTax("ita", 30, false));
	
		VatTaxCalculator.addCountries(countries);
		System.out.println(VatTaxCalculator.calculateTax(200));
		System.out.println(VatTaxCalculator.calculateTax(149, "ita"));
	}
}
