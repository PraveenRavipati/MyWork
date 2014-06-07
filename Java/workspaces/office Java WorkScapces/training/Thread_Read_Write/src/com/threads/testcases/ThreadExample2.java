package com.threads.testcases;

import java.util.ArrayList;
import java.util.List;


public class ThreadExample2 {

	public static void main(String[] args) {
		String operation[] = { "Read", "Write" };
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < operation.length; i++) {
			ReadWriteThread rw = new ReadWriteThread(operation[i]);
			rw.start();
			list.add(rw);
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

class ReadWriteThread extends Thread {
	String status;
	FileOperation fop = new FileOperation();
	boolean control=true;

	public ReadWriteThread(String status) {
		this.status = status;
	}

	@Override
	public void run() {
		while (control) {
			if (this.status == "Read") {
				if (FileOperation.status == "free"
						|| FileOperation.status == "Read") {
					fop.getReadAccess(this);
					control=false;
				} else {
					synchronized (this) {
						System.out.println("im in syn Read");
						try {
							fop.wait();
							fop.getReadAccess(this);
							control=false;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} else {
				if (FileOperation.status == "free" && FileOperation.count == 0) {
					fop.getWriteAccess(this);
					control=false;
				} else {
					synchronized (this) {
						System.out.println("im in syn");
						try {
							
							fop.wait();
							fop.getWriteAccess(this);
							control=false;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}

class FileOperation {
	static String status = "free";
	static int count = 0;

	public void getReadAccess(ReadWriteThread rwt) {
		count++;
		status = "Read";
		System.out.println(Thread.currentThread().getName()
				+ " is reading the file");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		release(rwt);
	}

	public void getWriteAccess(ReadWriteThread rwt) {
		System.out.println(Thread.currentThread().getName()
				+ " is writing the file");
		status="Write";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void release(ReadWriteThread rwt) {
		status="free";
		count--;
		synchronized (rwt) {
			rwt.notify();
		}
	}
}