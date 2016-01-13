package week06;

import java.io.IOException;
import java.io.Serializable;

public class AddTransaction implements Transaction, Serializable{
	
	private Integer accountNumber;
	private double amount;
	
	public AddTransaction(Integer accountNumber, double amount) {
		this.amount = amount;
		this.accountNumber = accountNumber;
	}

	@Override
	public void doTransaction() throws InsufficientFundsException, NonExistingBankAccountException, IOException {
		BankAccount account =  DbBankAccounts.get(accountNumber);
		account.add(amount);
		account.addToHistory(this);
		DbBankAccounts.save();
	}
	
	public String toString() {
		return String.format("Transaction: Add amount: %s", amount);
	}
	
}
