package com.vlabs.banksummay.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

public class BankSummary {
	public static void main(String[] args) {
		Hashtable<String, Double> userAccount=new Hashtable<String, Double>();
		File folder = new File("/home/praveen/Desktop/works/new input/");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t=new MyThread(file.getAbsolutePath(),userAccount);
				t.start();
				 System.out.println("in if");

			}
		}
	}

}
class MyThread extends Thread
{
	static Hashtable<String, Double> userAccount;
	String filepath;
	public MyThread(String filepath,Hashtable<String, Double> users)
	{
		this.filepath=filepath;
		userAccount=users;
	}
	public void run()
	{
		try {
			BufferedReader input=new BufferedReader(new FileReader(filepath));
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
					String UserId=arg[0];
					String trans=arg[1];
					double amount=Double.parseDouble(arg[2]);

					System.out.println("Thread"+Thread.currentThread().getName());
					addToTable(UserId,trans,amount);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void addToTable(String userId, String trans, double amount) {
			System.out.println("UserId:"+userId+" transaction:"+trans+" Amount:"+amount+" thread:"+Thread.currentThread().getName());	
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
