package week06;

import java.io.IOException;
import java.io.Serializable;

public class TransferTransaction implements Transaction, Serializable{
	
	private Integer sender;
	private Integer receiver;
	private double amount;
	private BankAccount senderAccount;
	private BankAccount receiverAccount;
	
	public TransferTransaction(Integer sender, Integer receiver, double amount) {
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public void doTransaction() throws InsufficientFundsException, NonExistingBankAccountException, IOException {
		senderAccount = DbBankAccounts.get(sender);
		receiverAccount = DbBankAccounts.get(receiver);
		senderAccount.transfer(receiverAccount, amount);
		senderAccount.addToHistory(this);
		receiverAccount.addToHistory(this);
		DbBankAccounts.save();
	}

	public String toString() {
		return String.format("Transaction: Transfer sender: %s, receiver: %s amount: %s", senderAccount, receiverAccount, amount); 
	}
	
}
