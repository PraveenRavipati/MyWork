package com.bank_transaction.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;

class BankTransaction_Using_Threads {
	public static void main(String[] args) {
		BankTransaction_Using_Threads bt = new BankTransaction_Using_Threads();
		System.out.println("Main Begins");
		Hashtable<String, Double> hashtable = new Hashtable<String, Double>();
		File folder = new File("/home/praveen/Desktop/works/new input/");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				// System.out.println("in if");
				Thread t = new Thread(new GivenTask(hashtable,
						file.getAbsolutePath()));
				t.start();
				list.add(t);
			}
		}
		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		bt.summary(hashtable);
		System.out.println("Main completed");
		if (hashtable != null) {
			// System.out.println("ya");
			hashtable = null;
		}
	}

	public void summary(Hashtable<String, Double> hashtable) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<String, Double> entry : hashtable.entrySet()) {
			String Account = entry.getKey();
			double Amount = entry.getValue();
			System.out.println("The Account Id:\t" + Account + "\t\tAmount:\t"
					+ Amount);
		}
	}

}

class GivenTask implements Runnable {
	private Hashtable<String, Double> hashtable;
	private String filepath;

	public GivenTask(Hashtable<String, Double> hashtable, String filepath) {
		this.hashtable = hashtable;
		this.filepath = filepath;
		// System.out.println("thread "+Thread.currentThread().getName()+" initialized");
	}

	@Override
	public void run() {
		System.out.println("thread " + Thread.currentThread().getName()
				+ " started");
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filepath));
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
					// System.out.println("lo0p"+Thread.currentThread().getName());
					String AccountNo = arg[0];
					System.err.println("Account id"+AccountNo);
					String trans = arg[1];
					double Amount = Double.parseDouble(arg[2]);
					// System.out.println("\n \t\ttrans:"+transaction+"thread"+Thread.currentThread().getName());
					synchronized (AccountNo) {
						System.err.println("in syn Account id"+AccountNo);					
//						System.out.println("Thread:"+ Thread.currentThread().getName() + " is in"+ " acc id " + AccountNo);
						Double initialAmount = hashtable.get(AccountNo);
						System.out.println("initial amount in "+ Thread.currentThread().getName() + " is "+ initialAmount);
						
							if (initialAmount != null) {
								System.out.println("Thread "+ Thread.currentThread().getName()+ " if in if block");
								hashtable=transaction(hashtable, AccountNo, Amount,trans, initialAmount);
							} else {
								hashtable.put(AccountNo, bal);
								hashtable=transaction(hashtable, AccountNo, Amount,trans, bal);
								System.out.println("Thread "+ Thread.currentThread().getName()+ " is in else block");
							}
							System.out.println("Thread"
									+ Thread.currentThread().getName()
									+ "completed");
						
					}
					}
				}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread" + Thread.currentThread().getName()
				+ "completed");
	}

	public Hashtable<String, Double> transaction(Hashtable<String, Double> hashtable,
			String AccountNo, double amount, String transaction,
			double initialAmount) {
		synchronized (AccountNo) {
			System.out.println("1)Thread:"+Thread.currentThread().getName());
			if (transaction.equalsIgnoreCase("deposite")) {
				System.out.println("1)Thread:"+Thread.currentThread().getName());
				hashtable.put(AccountNo, initialAmount + amount);
			} else if (transaction.equalsIgnoreCase("withdraw")) {
				System.out.println("1)Thread:"+Thread.currentThread().getName());
				hashtable.put(AccountNo, initialAmount - amount);
			}
		}
		return hashtable;
	}

}
