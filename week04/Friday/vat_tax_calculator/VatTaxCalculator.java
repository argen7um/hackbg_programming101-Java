package week04.Friday.vat_tax_calculator;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class VatTaxCalculator {

	private static Map<String, Integer> countries;
	private static CountryVatTax defaultCountry;
	
	public static void addCountries(List<CountryVatTax> countries) {
		VatTaxCalculator.countries = new HashMap<>();
		fillHashMap(countries);
		defaultCountry = findDefaultCountry(countries);
	}
	
	private static CountryVatTax findDefaultCountry(List<CountryVatTax> countries) {
		for (CountryVatTax country: countries) {
			if (country.isDefault()) {
				return country;
			}
		}
		return null;
	}
	
	private static void fillHashMap(List<CountryVatTax> countries) {
		for (CountryVatTax country: countries) {
			VatTaxCalculator.countries.put(country.getCountryId(), country.getVatTax());
		}
	}
	
	public static double calculateTax(double price, String countryId) {
		int tax = countries.get(countryId);
		return (price * tax) / 100;
	}
	
	public static double calculateTax(double price) {
		return calculateTax(price, defaultCountry.getCountryId());
	}
	
}
