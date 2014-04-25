package com.bank_transaction.thread.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankTest {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Hashtable<Integer, Double> UserAccounts = new Hashtable<Integer, Double>();
		/*if (args.length != 1) {
			System.err
					.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}
		String FilePath = args[0];*/
		System.out.println("Enter the file path:");
		String FilePath=s.next();

		BankTest bt = new BankTest();
//		UserAccounts = bt.input(FilePath, UserAccounts);
		bt.summary(UserAccounts);
	}

	public void summary(Hashtable<Integer, Double> userAccounts) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<Integer, Double> entry : userAccounts.entrySet()) {
			int Account = entry.getKey();
			double Amount = entry.getValue();
			System.out.println("The Account no:\t" + Account + "\t Amount:\t"
					+ Amount);
		}
	}

	

}
class MyTask implements Runnable
{
	private String filepath;
	
	public MyTask(String filepath)
	{
		this.filepath=filepath;
	}
	@Override
	public void run() {
		
		
		
		
		
	}
	public Hashtable<Integer, Double> input(String filePath,
			Hashtable<Integer, Double> UserAccounts) {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filePath));
			String str = null;
			double bal = 0.0;
			String arg[] = new String[3];
			StringTokenizer sTokenizer = null;
			while ((str = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg[i] = sTokenizer.nextToken();
				}
				if (arg[0] != null) {
					int AccountNo = Integer.parseInt(arg[0]);
					String transaction = arg[1];
					double Amount = Double.parseDouble(arg[2]);
					Double initialAmount = UserAccounts.get(AccountNo);
					if (initialAmount != null) {
						UserAccounts = transaction(UserAccounts, AccountNo,
								Amount, transaction, initialAmount);
					} else {
						UserAccounts.put(AccountNo, bal);
						UserAccounts = transaction(UserAccounts, AccountNo, Amount,
								transaction, bal);
					}

				}
			}
		} catch (NumberFormatException e) {
			System.err.println("Input is not readables");
		} catch (FileNotFoundException e) {
			System.err.println("File is not found");
		} catch (IOException e) {
			System.err.println("File read error");
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				System.err.println("File Read Error");
			}
		}
		return UserAccounts;
	}

	public Hashtable<Integer, Double> transaction(
			Hashtable<Integer, Double> UserAccounts, int AccountNo,
			double amount, String transaction, double initialAmount) {
		if (transaction.equalsIgnoreCase("deposite")) {
			UserAccounts.put(AccountNo, initialAmount + amount);
		} else if (transaction.equalsIgnoreCase("withdraw")) {
			UserAccounts.put(AccountNo, initialAmount - amount);
		}
		return UserAccounts;
	}
	
}
