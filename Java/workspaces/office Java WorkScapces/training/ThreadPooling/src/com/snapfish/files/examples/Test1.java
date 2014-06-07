package com.snapfish.files.examples;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<Thread> list=new ArrayList<Thread>();
		System.out.println("The MAIN Thread Started");
		String operation[]={"Read","Read","Write","Write","Read","Write"};
		System.out.println("The length:"+operation.length);
		for(int i=0;i<operation.length;i++)
		{
			ExpThread et=new ExpThread(operation[i]);
			et.start();
			list.add(et);
		}
		for(Thread t:list)
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("MAIN completed");
	}

}
class ExpThread extends Thread
{
	String status;
	public ExpThread(String status) {
		this.status=status;
	}
	@Override
	public void run() {
		System.out.println(this.getName()+" started");
		System.out.println("Thread:"+this.getName()+" status:"+status);
		synchronized (this) {
			if(this.status=="Read")
			{
				System.out.println(this.getName()+" says");
				try {
					ReadWrite.readPermission();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println(this.getName()+" says");
				try {
					ReadWrite.writePermission();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
	
}
class ReadWrite
{
	static int count;
	static ReadWrite rw=new ReadWrite();
	static int read,write;
	public static void readPermission() throws InterruptedException
	{
		synchronized (rw) {
			System.out.println(Thread.currentThread().getName()+"Im in reading ....");
			count++;
			getReadAccess();
		}
		
	}
	public static void writePermission() throws InterruptedException
	{
		synchronized (rw) {
			System.out.println(Thread.currentThread().getName()+" Im in Write ....");
			getWriteAccess();
		}
		
	}
	static void getReadAccess() throws InterruptedException 
	{
		if(write==0&&count>=0)
		{
		System.out.println(Thread.currentThread().getName()+" I am reading the file ......");
		Thread.sleep(4000);
		System.out.println(Thread.currentThread().getName()+" is waiting for another read");
		}
		
		else {
			System.out.println(Thread.currentThread().getName()+" Read permission is waiting........");
			read=1;
			rw.wait();
			read=0;
			fileReading();
			System.out.println(Thread.currentThread().getName()+" Read is Resumed");
		}
	}
	static void getWriteAccess() throws InterruptedException
	{
		if(read==0&&count<=0){
		System.out.println(Thread.currentThread().getName()+" I am Writing the file ......");
		Thread.sleep(4000);
		write=0;
		}
		else {
			System.out.println(Thread.currentThread().getName()+" Write permission is waiting..........");
			write=1;
			rw.wait();
			write=0;
			fileWriting();
			System.out.println(Thread.currentThread().getName()+" Write is Resumed");
		}
	}
	static void fileReading() throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName()+" Im reading the file......");
		Thread.sleep(6000);
		if(write==1)
		{
			rw.notify();
		}
	}
	static void fileWriting() throws InterruptedException
	{ 
		System.out.println(Thread.currentThread().getName()+" Im writing the file......");
		Thread.sleep(6000);
		if(read==1)
		{
			rw.notify();
		}
	}
}
