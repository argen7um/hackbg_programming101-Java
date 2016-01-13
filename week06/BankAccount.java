package week06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class BankAccount implements Serializable {
	
	private int number;
	private Client client;
	private double balance;
	public enum TypeInterest {
		SIMPLE, COMPLEX
	}
	private TypeInterest typeInterest;
	private double interest;
	private List<Transaction> history;	
	
	public BankAccount(Client client, double balance,
			TypeInterest typeInterest, double interest) throws BankAccountInvalidParametar, IOException {
		setNumber();
		setClient(client);
		setTypeInterest(typeInterest);
		setInterest(interest);
		setBalance(balance);
		history = new LinkedList<Transaction>();
	}
	
	public String toString() {
		return String.format("%s accountNumber:%s balance:%s", client, getNumber(), balance);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber() throws IOException {
		number = getLastNumber() + 1;
		saveLastNumber(number);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) throws BankAccountInvalidParametar {
		if (balance < 0) {
			throw new BankAccountInvalidParametar("Balance must be positive value");
		}
		this.balance = balance;
	}

	public String getTypeInterest() {
		return typeInterest.name();
	}

	public void setTypeInterest(TypeInterest typeInterest) {
		this.typeInterest = typeInterest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) throws BankAccountInvalidParametar {
		if (interest < 0) {
			throw new BankAccountInvalidParametar("Interest must be positive value");
		}
		this.interest = interest;
	}
	
	public void add(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException("Not enough funds in account");
		}
		balance -= amount;
	}
	
	public void transfer(BankAccount account, double amount) throws InsufficientFundsException {
		withdraw(amount);
		account.add(amount);
		//Transaction transaction = new Transaction(this, account, amount);
		//addToHistory(transaction);
		//account.addToHistory(transaction);
	}
	
	public void addToHistory(Transaction transaction) {
		if (history.size() >= 5) {
			history.remove(0);
		}
		history.add(transaction);		
	}
	
	public String showHistory() {
		String res = "";
		for (Transaction temp: history) {
			res += temp.toString() + "\n";
		}
		return res;
	}
	
	private void saveLastNumber(int lastNumber) throws IOException {
		FileOutputStream outFile = new FileOutputStream("/home/angel/mytmp/number.ser");
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		out.writeObject(lastNumber);
		out.close();
		outFile.close();
	} 
	
	private int getLastNumber() {
		Integer res = 0;
		try {
			FileInputStream inFile = new FileInputStream("/home/angel/mytmp/number.ser");
			ObjectInputStream in = new ObjectInputStream(inFile);
			res = (Integer) in.readObject();
			in.close();
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return res;
	}
}
