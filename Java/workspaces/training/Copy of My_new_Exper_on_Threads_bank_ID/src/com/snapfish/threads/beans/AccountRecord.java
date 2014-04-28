package com.snapfish.threads.beans;

import java.util.HashMap;

public class AccountRecord {
	static HashMap<Integer,AccountRecord> map=new HashMap<Integer,AccountRecord>();
	private int AccountId;
	private double amount;
	public AccountRecord(int AccountId,double amount) {
		this.AccountId=AccountId;
		this.amount=amount;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public static synchronized AccountRecord setAccountRecord(Integer UserId,double amount)
	{
		AccountRecord obj=null;
		if(map.containsKey(UserId))
		{
			obj=map.get(UserId);
		}
		else {
			obj=new AccountRecord(UserId,amount);
			map.put(UserId,obj);
		}
		
		return obj;
	}
}
