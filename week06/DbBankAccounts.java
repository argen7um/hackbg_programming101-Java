package week06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class DbBankAccounts implements Serializable {

	private static HashMap<Integer, BankAccount> data = new HashMap<Integer, BankAccount>();
	private static boolean isOpen = false;
	
	public static BankAccount get(Integer acountNumber)
			throws NonExistingBankAccountException, IOException{
		if (isOpen == false) {
			open();
		}
		BankAccount account = data.get(acountNumber);
		if (account == null) {
			throw new NonExistingBankAccountException("Account not excist");
		}
		return account;
	}

	public static void add(Integer acountNumber, BankAccount account) throws IOException {
		if (isOpen == false) {
			open();
		}
		data.put(acountNumber, account);
		save();
	}
	

	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("/home/angel/mytmp/db.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(data);
		out.close();
		fileOut.close();
	}
	
	public static void open() throws IOException {
		FileInputStream fileIn;
		ObjectInputStream in;
		try{
			fileIn = new FileInputStream("/home/angel/mytmp/db.ser");
			in = new ObjectInputStream(fileIn);
			data = (HashMap<Integer, BankAccount>) in.readObject();
			in.close();
	        fileIn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
         isOpen = true;
	}
}
