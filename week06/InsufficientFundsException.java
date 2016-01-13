package week06;

public class InsufficientFundsException extends Exception{
	
	public InsufficientFundsException() {
		super();
	}

	public InsufficientFundsException(String messString) {
		super(messString);
	}
	
	public InsufficientFundsException(String messString, Throwable cause) {
		super(messString, cause);
	}
	
}
