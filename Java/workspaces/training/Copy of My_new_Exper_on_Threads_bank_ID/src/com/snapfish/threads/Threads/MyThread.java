package com.snapfish.threads.Threads;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.snapfish.threads.beans.AccountRecord;

public class MyThread extends Thread
{
	static Hashtable<Integer, Double> userAccount;
	String filepath;
	public MyThread(String filepath,Hashtable<Integer, Double> users)
	{
		this.filepath=filepath;
		userAccount=users;
	}
	public MyThread() {
	}
	public void run()
	{
		BufferedReader input=null;
		try {
			input=new BufferedReader(new FileReader(filepath));
			String str = null;
			String arg[] = new String[3];
			StringTokenizer sTokenizer = null;
			while ((str = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg[i] = sTokenizer.nextToken();
				}
				if (arg[0] != null) {
					Integer UserId=Integer.parseInt(arg[0]);
					String trans=arg[1];
					double amount=Double.parseDouble(arg[2]);

					System.out.println("Thread"+Thread.currentThread().getName());
					AccountRecord obj=AccountRecord.setAccountRecord(UserId,amount);
					synchronized (obj) {
						addToTable(UserId, trans, amount);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addToTable(Integer userId, String trans, double amount) {
			double initBal=0.0;
			System.out.println("UserId:"+userId+" transaction:"+trans+" Amount:"+amount+" thread:"+Thread.currentThread().getName());	
			Double init=userAccount.get(userId);
			if(init==null)
			{
				System.out.println("no inital bal");
				userAccount.put(userId,initBal);
				init=initBal;
				synchronized (userId) {
					traansaction(userId, trans, amount,init);
				}
			}
			else {
				System.out.println("some amount is there");
				synchronized (userId) {
					traansaction(userId, trans, amount,init);
				}
			}
		
	}
	public void traansaction(Integer userId,String trans,double amount,double init) {
		if(trans.equalsIgnoreCase("deposite"))
		{
			System.out.println("deposited");
			userAccount.put(userId,(userAccount.get(userId)+amount));
		}
		else {
			System.out.println("deposited");
			userAccount.put(userId,(userAccount.get(userId)-amount));
		}
		System.out.println("trans completed");
	}
}