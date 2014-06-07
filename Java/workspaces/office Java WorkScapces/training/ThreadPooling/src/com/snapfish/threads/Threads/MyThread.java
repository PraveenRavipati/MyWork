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
	static Hashtable<Integer, AccountRecord> userAccount;
	String filepath;
	public MyThread(String filepath,Hashtable<Integer, AccountRecord> users)
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

					System.out.println("in if Thread"+Thread.currentThread().getName());
					AccountRecord obj=AccountRecord.setAccountRecord(UserId, userAccount);
					System.out.println("After object creation Thread:"+Thread.currentThread().getName()+"Object "+obj.getAccountId()+" amount:"+obj.getAmount());
					synchronized (obj) {
						transaction(UserId, trans, amount);
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
			
	public void transaction(Integer userId,String trans,double amount) {
		if(trans.equalsIgnoreCase("deposite"))
		{
			userAccount.put(userId,(userAccount.get(userId).addValue(amount)));
			System.out.println("\ndeposited Thread:"+Thread.currentThread().getName()+" userId:"+userId+" with amount:"+amount);
			System.out.println("\ncurrent balence in "+userId+" is "+userAccount.get(userId).getAmount());
		}
		else {
			userAccount.put(userId,(userAccount.get(userId).diffValue(amount)));
			System.out.println("\nWithdraw Thread:"+Thread.currentThread().getName()+" userId:"+userId+" with amount:"+amount);
			System.out.println("\ncurrent balence in "+userId+" is "+userAccount.get(userId).getAmount());
		}
		System.out.println("\ntrans completed Thread:"+Thread.currentThread().getName()+" userId:"+userId+"\n");
	}
	
}