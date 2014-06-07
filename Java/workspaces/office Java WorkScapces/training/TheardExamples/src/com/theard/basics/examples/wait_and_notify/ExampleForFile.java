package com.theard.basics.examples.wait_and_notify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExampleForFile {

	public static void main(String[] args) {
		ReadWrite r = new ReadWrite();
		String operation[] = { "Read", "Write", "Write", "Write", "Read",
				"Write", "Read", "Read", "Write", "Write", "Write", "Read" };
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < operation.length; i++) {
			RWThread rw = new RWThread(r, operation[i]);
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

class ReadWrite {
	static int count = 0;
	static boolean isWriteWaiting = false;
	static boolean isReadWaiting = false;
	static final String filePath = "/home/praveen/Desktop/works/Read_Write_input/file1.txt";
	private BufferedReader input;
	StringBuilder str=null;

	public void getReadAccess() throws InterruptedException, IOException {
		// System.out.println(Thread.currentThread().getName()+" reading the file .....");

		input = new BufferedReader(new FileReader(filePath));
		String string;
		while ((string = input.readLine()) != null) {
			System.out.println(string);
			str=new StringBuilder(string);
		}
		count--;
		System.out.println("count2:" + count);
	}

	public void getWriteAccess() throws InterruptedException, IOException {
		// System.out.println(Thread.currentThread().getName()+" Writing the file .....");
		BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
		Scanner s = new Scanner(System.in);
		System.out.println("Enter to string to write");
		String str = s.next();
		out.write(str);
		out.close();
		// Thread.sleep(10000);
	}

	public void release(ReadWrite rw) {
		rw.notify();
	}

	public void readFile() throws InterruptedException, IOException {
		synchronized (this) {
			if (isWriteWaiting && count == 0) {
				System.out.println("waiting state");
				isReadWaiting = true;
				this.wait();
				isReadWaiting = false;
				System.out.println(Thread.currentThread().getName()
						+ " Reasumed");
				getReadAccess();
			} else {
				count++;
				System.out.println("count1:" + count);
				getReadAccess();
				if (count == 0 && isWriteWaiting) {
					release(this);
				}
			}
		}
	}

	public void writeFile() throws InterruptedException, IOException {
		synchronized (this) {

			if (isReadWaiting && isWriteWaiting) {
				System.out.println("waiting state");
				isReadWaiting = true;
				this.wait();
				isReadWaiting = false;
				System.out.println(Thread.currentThread().getName()
						+ " Reasumed");
				getWriteAccess();
			} else if (isReadWaiting && !isWriteWaiting) {
				System.out.println("waiting state");
				isReadWaiting = true;
				this.wait();
				isReadWaiting = false;
				System.out.println(Thread.currentThread().getName()
						+ " Reasumed");
				getWriteAccess();

			} else {
				getWriteAccess();
				if (isReadWaiting) {
					System.out.println("in if");
					release(this);
				} else if (isWriteWaiting) {
					System.out.println("in else");
					release(this);
				}
			}
		}
	}

}

class RWThread extends Thread {
	ReadWrite w = null;
	String status;
	public RWThread(ReadWrite w, String status) {
		this.w = w;
		this.status = status;
	}
	@Override
	public void run() {
		// System.out.println(this.getName()+" is initized with status:"+status);
		if (this.status == "Read") {
			try {
				w.readFile();
				System.out.println(this.getName() + " is completed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				w.writeFile();
				System.out.println(this.getName() + " is completed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
