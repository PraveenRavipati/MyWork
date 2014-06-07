package com.snapfish.threads.mainclasses;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import com.snapfish.threads.Threads.*;
import com.snapfish.threads.beans.AccountRecord;
public class BankTrans1 {

	public static void main(String[] args) {
		BankTrans1 st1=new BankTrans1();
		Hashtable<Integer, AccountRecord> userAccount = new Hashtable<Integer, AccountRecord>();
		File folder = new File("/home/praveen/Desktop/works/id_input/");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list=new ArrayList<Thread>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t = new MyThread(file.getAbsolutePath(), userAccount);
				t.start();
				list.add(t);
			}
		}
		for (Thread t : list) {
			synchronized (t) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		st1.summary(userAccount);
		AccountRecord.displayAll();
		System.out.println("Main completed");
		if (userAccount != null) {
			// System.out.println("ya");
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
