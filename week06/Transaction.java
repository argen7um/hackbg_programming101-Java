package week06;

import java.io.IOException;

public interface Transaction {
	
	public void doTransaction() throws InsufficientFundsException, NonExistingBankAccountException, IOException;

}
