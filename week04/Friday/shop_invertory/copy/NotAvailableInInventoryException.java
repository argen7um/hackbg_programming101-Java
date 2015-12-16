package week04.Friday.shop_invertory.copy;

public class NotAvailableInInventoryException extends Exception{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public NotAvailableInInventoryException(String msg) {
		super(msg);
	}

}
