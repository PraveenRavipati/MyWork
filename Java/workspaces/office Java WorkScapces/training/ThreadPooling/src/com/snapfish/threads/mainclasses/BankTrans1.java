package com.snapfish.threads.mainclasses;

import java.io.File;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.snapfish.threads.Threads.MyThread;
import com.snapfish.threads.beans.AccountRecord;
public class BankTrans1 {

	public static void main(String[] args) {
		BankTrans1 st1=new BankTrans1();
		Hashtable<Integer, AccountRecord> userAccount = new Hashtable<Integer, AccountRecord>();
		File folder = new File("/home/praveen/Desktop/works/id_input/");
		File[] listOfFiles = folder.listFiles();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		int count=0;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t = new MyThread(file.getAbsolutePath(), userAccount);
				executor.execute(t);
				count++;
			}
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
        }
		
		System.out.println("no of files:"+count);
		st1.summary(userAccount);
		System.out.println("Main completed");
		if (userAccount != null) {
			userAccount = null;
		}
		
	}
	public void summary(Hashtable<Integer, AccountRecord> hashtable) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<Integer, AccountRecord> entry : hashtable.entrySet()) {
			AccountRecord Amount = entry.getValue();
			System.out.println("The Account Id:\t" + Amount.getAccountId() + "\t\tAmount:\t"
					+ Amount.getAmount());
		}
	}
}
