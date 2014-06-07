package com.snapfish.threads.beans;

import java.util.Hashtable;

public class AccountRecord {
	static Hashtable<Integer, AccountRecord> map;
	private int AccountId;
	private double amount;

	public AccountRecord(int AccountId) {
		this.AccountId = AccountId;
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

	public static AccountRecord setAccountRecord(Integer UserId,
			Hashtable<Integer, AccountRecord> set) {
		synchronized (AccountRecord.class) {
			map = set;
			AccountRecord obj = null;
			if (map.containsKey(UserId)) {
				obj = map.get(UserId);
				System.out.println("Userid:" + UserId + " contains in Thread:"
						+ Thread.currentThread().getName() + " with amount:"
						+ obj.getAmount());
			} else {
				obj = new AccountRecord(UserId);
				System.out.println("Userid:" + UserId
						+ " not contain in Thread:"
						+ Thread.currentThread().getName() + " with amount:"
						+ obj.getAmount());
				map.put(UserId, obj);
			}
			return obj;
		}
	}

	public AccountRecord addValue(double amount) {
		this.amount = this.amount + amount;
		return this;
	}

	public AccountRecord diffValue(double amount) {
		this.amount = this.amount - amount;
		return this;
	}

	public static void displayAll() {
		System.out.println("Hashset:" + map);

	}
}
