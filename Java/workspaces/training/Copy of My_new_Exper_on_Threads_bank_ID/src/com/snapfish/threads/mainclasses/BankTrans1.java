package com.snapfish.threads.mainclasses;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import com.snapfish.threads.Threads.*;
public class BankTrans1 {

	public static void main(String[] args) {
		BankTrans1 st1=new BankTrans1();
		Hashtable<Integer, Double> userAccount = new Hashtable<Integer, Double>();
		File folder = new File("/home/praveen/Desktop/works/id_input/");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t = new MyThread(file.getAbsolutePath(), userAccount);
				t.start();
				System.out.println("in if");
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
		st1.summary(userAccount);
		System.out.println("Main completed");
		if (userAccount != null) {
			// System.out.println("ya");
			userAccount = null;
		}
		
	}
	public void summary(Hashtable<Integer, Double> hashtable) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<Integer, Double> entry : hashtable.entrySet()) {
			int Account = entry.getKey();
			double Amount = entry.getValue();
			System.out.println("The Account Id:\t" + Account + "\t\tAmount:\t"
					+ Amount);
		}
	}
}
