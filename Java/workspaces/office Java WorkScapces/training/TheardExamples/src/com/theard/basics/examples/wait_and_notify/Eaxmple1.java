package com.theard.basics.examples.wait_and_notify;

import java.util.Scanner;

public class Eaxmple1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("\nEnter the Number:");
		int n=s.nextInt();
		ThreadB b = new ThreadB(n);
		b.start();

		synchronized (b) {
			try {
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("The Sum of "+n+" numbers: " + ThreadB.total);
	}
}

class ThreadB extends Thread {
	static int total;
	int n;
	public ThreadB(int n) {
		// TODO Auto-generated constructor stub
		this.n=n;
	}
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i <= n; i++) {
				total += i;
			}
			notify();
		}
	}
}