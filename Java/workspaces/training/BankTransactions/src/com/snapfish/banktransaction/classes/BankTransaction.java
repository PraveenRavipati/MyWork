package com.snapfish.banktransaction.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BankTransaction {
	public static void main(String[] args) {
		Hashtable<Integer, Double> UserAccounts = new Hashtable<Integer, Double>();
		if (args.length != 1) {
			System.err
					.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}
		String FilePath = args[0];

		BankTransaction bt = new BankTransaction();
		UserAccounts = bt.input(FilePath, UserAccounts);
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
					if (UserAccounts.containsKey(AccountNo)) {
						UserAccounts = transaction(UserAccounts, AccountNo,
								Amount, transaction);
					} else {
						UserAccounts.put(AccountNo, bal);
						UserAccounts = transaction(UserAccounts, AccountNo,
								Amount, transaction);
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
			double amount, String transaction) {
		if (transaction.equalsIgnoreCase("deposite")) {
			UserAccounts.put(AccountNo, UserAccounts.get(AccountNo) + amount);
		} else if (transaction.equalsIgnoreCase("withdraw")) {
			UserAccounts.put(AccountNo, UserAccounts.get(AccountNo) - amount);
		}
		return UserAccounts;
	}

}
