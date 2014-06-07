package com.theard.basics.examples.wait_and_notify;

import java.util.Scanner;

public class Processor {
	void producer() throws InterruptedException
	{
		System.out.println("Im Thread:"+Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("Thread:"+Thread.currentThread().getName()+" is processing the order ....");
			wait();
			System.out.println("resumed.");
		}
	}
	void consumer() throws InterruptedException
	{
		System.out.println("Im Thread:"+Thread.currentThread().getName());
		Scanner s=new Scanner(System.in);
		synchronized (this) {
			Thread.sleep(5000);
			System.out.println("Thread:"+Thread.currentThread().getName()+" is waiting for return key....");
			s.nextLine();
			System.out.println("return key pressed.");
			notify();
		}
	}
}

