package com.threads.testcases;

public class ReadWriteAccess {
	static boolean iswriteAccess = true;
	static boolean isReadAccess = true;

	static public void getWriteAccess() {
		iswriteAccess = false;
		isReadAccess=false;
	}

	static public void getReadAccess() {
		iswriteAccess=false;
	}

	 public void readFile() {
		synchronized (this) {
			getReadAccess();
			System.out.println("im reading the file");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" completed the reading");
			if (!iswriteAccess) {
				notify();
				iswriteAccess=true;
			}
			else if(!isReadAccess){
				notify();
				isReadAccess=true;
			}
		}
	
	}

	  public void writeFile() {
		synchronized (this) {
			getWriteAccess();
			System.out.println("im Writing the file");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" completed the writing");
			if (!iswriteAccess) {
				notify();
				iswriteAccess=true;
			}
			else if(!isReadAccess){
				notify();
				isReadAccess=true;
			}
		}
	}


}
