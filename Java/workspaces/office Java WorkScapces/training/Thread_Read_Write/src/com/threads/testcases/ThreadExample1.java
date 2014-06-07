package com.threads.testcases;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample1 {
	public static ReadWriteAccess lock=null; 
	public static void main(String[] args) {
		lock = new ReadWriteAccess();
		String operation[] = { "Read", "Write"};
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < operation.length; i++) {
			if(operation[i]=="Read")
			{
				ReadThread rt=new ReadThread(lock,operation[i]);
				rt.start();
				list.add(rt);
			}
			else {
				WriteThread wt=new WriteThread(lock,operation[i]);
				wt.start();
				list.add(wt);
			}
			
		}
		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
class ReadThread extends Thread
{
	ReadWriteAccess lock=null;
	String status;
	public ReadThread(ReadWriteAccess lock,String status) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
		this.status=status;
	}
	@Override
	public void run() {
		System.out.println(this.getName()+" in the ReadThread");
		lock.readFile();

		System.out.println(this.getName()+" completed");
	}
}
class WriteThread extends Thread
{
	String status;
	ReadWriteAccess lock=null;
	public WriteThread(ReadWriteAccess lock,String status) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
		this.status=status;
	}
	@Override
	public void run() {
		System.out.println(this.getName()+" in the WriteThread");
		lock.writeFile();
		System.out.println(this.getName()+" completed");
		
	}
}
