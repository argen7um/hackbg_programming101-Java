package week4.Friday.vat_tax_calculator;

public class CountryVatTax {

	private final String countryId;
	private final int vatTax;
	private final boolean isDefault;
	
	public CountryVatTax (String countyId, int vatTax, boolean isDefault) {
		this.countryId = countyId;
		this.vatTax = vatTax;
		this.isDefault = isDefault;
	}

	public String getCountryId() {
		return countryId;
	}

	public int getVatTax() {
		return vatTax;
	}

	public boolean isDefault() {
		return isDefault;
	}
	
}
