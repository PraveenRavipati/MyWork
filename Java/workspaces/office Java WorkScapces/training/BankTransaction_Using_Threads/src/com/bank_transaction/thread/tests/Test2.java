package com.bank_transaction.thread.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		System.out.println("Main Begins");
		File folder = new File(
				"/home/praveen/Desktop/works/Banking using threads/");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println("in if");
				Thread t = new Thread(new MTask(file.getAbsolutePath()));
				t.start();
				list.add(t);
			}
		}

		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main over");

	}

}

final class MTask implements Runnable {
	private String taskId;

	public MTask(String id) {
		this.taskId = id;
	}

	@Override
	public void run() {
		System.out.println("Thread begins");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Task ID : " + this.taskId + " performed by "
				+ Thread.currentThread().getName());
		
		System.out.println("Thread over");
	}

}