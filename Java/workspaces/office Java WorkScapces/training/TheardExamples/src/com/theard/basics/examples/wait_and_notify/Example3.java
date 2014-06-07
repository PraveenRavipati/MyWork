package com.theard.basics.examples.wait_and_notify;

public class Example3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Processor p=new Processor();
		// TODO Auto-generated method stub
		System.out.println("main begines");
		Thread1 t1=new Thread1(p);
		Thread2 t2=new Thread2(p);
		Thread1 t3=new Thread1(p);
		Thread1 t4=new Thread1(p);
		Thread2 t5=new Thread2(p);
		System.out.println("threads initiazed");
		
		t1.start();
		System.out.println("Thread  1 started");
		t2.start();
		System.out.println("Thread 2 started");
		t3.start();
		System.out.println("Thread 3 started");
		t4.start();
		System.out.println("Thread 4 started");
		t5.start();
		System.out.println("Thread 5 started");
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		System.out.println("Main completed");
	}

}
class Thread1 extends Thread
{
	Processor p=null;
	public Thread1(Processor p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	
	@Override
	public void run() {
		try {
			p.producer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Thread2 extends Thread
{
	Processor p=null;
	public Thread2(Processor p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	@Override
	public void run() {
		try {
			p.consumer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
