package com.bank_transaction.thread.tests;

public class StringTest {
	public static void main(String[] args) {
		String s1[]={"praveen","srinu","nagaraju","Sumanth"};
		for(int i=0;i<10;i++)
		{
			Thread t=new Thread(new StringTask(s1));
			t.start();
		}
	}
}

class StringTask implements Runnable {
	String s1[];

	public StringTask(String s[]) {
		this.s1 = s;
	}

	@Override
	public void run() {
		System.out.println("thread"+Thread.currentThread().getName());
		for (int i = 0; i < s1.length; i++) {
			synchronized (s1[i]) {
				try {
					Thread.sleep(5000);
					System.out.println(s1[i]);                
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
			}
		}
	}

}
