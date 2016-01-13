package week06;

public class NonExistingBankAccountException extends Exception {
	
	public NonExistingBankAccountException() {
		super();
	}

	public NonExistingBankAccountException(String message) {
		super(message);
	}
	
	public NonExistingBankAccountException(String message, Throwable couse) {
		super(message, couse);
	}
	
}
