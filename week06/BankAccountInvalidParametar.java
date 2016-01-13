package week06;

public class BankAccountInvalidParametar extends Exception {
	
	public BankAccountInvalidParametar() {
		super();
	}

	public BankAccountInvalidParametar(String messString) {
		super(messString);
	}
	
	public BankAccountInvalidParametar(String messString, Throwable cause) {
		super(messString, cause);
	}

	
}
