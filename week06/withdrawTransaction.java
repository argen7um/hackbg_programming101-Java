package week06;

import java.io.IOException;
import java.io.Serializable;

public class withdrawTransaction implements Transaction, Serializable {
 
	private Integer accountNumber;
	private double amount;
	
	public withdrawTransaction(Integer accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	@Override
	public void doTransaction() throws InsufficientFundsException, NonExistingBankAccountException, IOException {
		BankAccount account = DbBankAccounts.get(accountNumber);
		account.withdraw(amount);
		account.addToHistory(this);
		DbBankAccounts.save();
	}
	
	public String toString() {
		return String.format("Transaction: Withdraw amount: %s", amount);
	}
	
}
