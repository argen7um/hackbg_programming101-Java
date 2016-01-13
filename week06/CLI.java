package week06;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import week06.BankAccount.TypeInterest;

public class CLI {
	
	private Scanner scanner;
	private String init_message;
	private String prompt;
	private String options;
	
	public CLI() {
		scanner = new Scanner(System.in);
		init_message = "Choose Option";
		options = "\n0: show options\n1: creat bank account\n2: show history\n3: add money\n4: withdraw money\n5: transfer money\n";
		prompt = ">>> "; 
	}
	
	public void start() {
		System.out.println(options);
		while (true) {
			System.out.println("\n" + init_message + "\n");
			System.out.print(prompt);
			Integer option = scanner.nextInt();
			scanner.nextLine();
			if (option.equals(1)) {
				createBankAccount();
			} else if (option.equals(2)) {
				showHistory();
			} else if (option.equals(3)) {
				addMoney();
			} else if (option.equals(4)) {
				withdrawMoney();
			} else if (option.equals(5)) {
				transferMoney();
			} else if (option.equals(0)) {
				System.out.println(options);
 			}
		}
	}
	
	private void createBankAccount() {
		System.out.println("Creating Bank Account");
		Scanner innerScanner = new Scanner(System.in);
		String line;
		String firstName, lastName, typeStringInterest;
		Integer age;
		double balance, interest;
		BankAccount account;
		while (true) {
			System.out.print("Enter Fist Name\n" + prompt);
			line = innerScanner.nextLine();
			firstName = getFirstArg(line);
			System.out.print("Enter Last Name\n" + prompt);
			line = innerScanner.nextLine();
			lastName = getFirstArg(line);
			System.out.print("Enter Age\n" + prompt);
			age = innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter balance\n" + prompt);
			balance = (double) innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Interest\n" + prompt);
			interest = (double) innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Type of Interest\n");
			typeStringInterest = innerScanner.next().toUpperCase();
			innerScanner.nextLine();
			try {
				Client client = new Client(firstName, lastName, age);
				account = new BankAccount(client, balance, TypeInterest.valueOf(typeStringInterest), interest);
				DbBankAccounts.add(account.getNumber(), account);
			} catch (Exception e) {
				System.out.println(e);
				System.out.print("Try Again\n" + prompt);
				continue;
			}
			System.out.println("Bank Account was created successfully");
			System.out.println(account);
			return;
		}
	}
	
	private void showHistory() {
		System.out.println("Showing History");
		Scanner innerScanner = new Scanner(System.in);
		Integer accountNumber;
		while (true) {
			System.out.print("Enter Bank Account Number\n" + prompt);
			accountNumber = innerScanner.nextInt();
			innerScanner.nextLine();
			try {
				BankAccount account = DbBankAccounts.get(accountNumber);
				System.out.print(account.showHistory());
			} catch (Exception e) {
				System.out.println(e);
				System.out.print("Try Again\n" + prompt);
				continue;
			}
			return;
		}
	}

	private void addMoney() {
		System.out.println("Adding Money");
		Scanner innerScanner = new Scanner(System.in);
		Integer accountNumber;
		double amount;
		while (true) {
			System.out.print("Enter Bank Account Number\n" + prompt);
			accountNumber = innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Amount\n" + prompt);
			amount = (double) innerScanner.nextInt();
			innerScanner.nextLine();
			try {
				Transaction transaction = new AddTransaction(accountNumber, amount);
				transaction.doTransaction();
				System.out.println(String.format("%s was made successfully", transaction));
			} catch (Exception e) {
				System.out.println(e);
				System.out.print("Try Again\n" + prompt);
				continue;
			}
			return;
		}
	}
	
	private void withdrawMoney() {
		System.out.println("Withdrawing Money");
		Scanner innerScanner = new Scanner(System.in);
		Integer accountNumber;
		double amount;
		while (true) {
			System.out.print("Enter Bank Account Number\n" + prompt);
			accountNumber = innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Amount\n" + prompt);
			amount = (double) innerScanner.nextInt();
			innerScanner.nextLine();
			try {
				Transaction transaction = new withdrawTransaction(accountNumber, amount);
				transaction.doTransaction();
				System.out.println(String.format("%s was made successfully", transaction));
			} catch (Exception e) {
				System.out.println(e);
				System.out.print("Try Again\n" + prompt);
				continue;
			}
			return;
		}
	}
	
	private void transferMoney() {
		System.out.println("Transfering Money");
		Scanner innerScanner = new Scanner(System.in);
		Integer accountNumberSending;
		Integer accountNumberReceiving;
		double amount;
		while (true) {
			System.out.print("Enter Origin Bank Account Number\n" + prompt);
			accountNumberSending = innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Destination Bank Account Number\n" + prompt);
			accountNumberReceiving = innerScanner.nextInt();
			innerScanner.nextLine();
			System.out.print("Enter Amount\n" + prompt);
			amount = (double) innerScanner.nextInt();
			innerScanner.nextLine();
			try {
				Transaction transaction = new TransferTransaction(accountNumberSending, accountNumberReceiving, amount);
				transaction.doTransaction();
				System.out.println(String.format("%s was made successfully", transaction));
			} catch (Exception e) {
				System.out.println(e);
				System.out.print("Try Again\n" + prompt);
				continue;
			}
			return;
		}
	}
	
	private String getFirstArg(String line) {
		String [] words = line.split("\\s+");
		return words[0];
	}
	
}
