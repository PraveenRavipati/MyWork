package com.bank_transaction.thread.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 public class ThreadPool {

    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(5);
       for (int i =0; i<100; i++){
           service.submit(new Task(i));
       }
    }
  
}

final class Task implements Runnable{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public void run() {
    	for(int i=0;i<10;i++)
    	{
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
    }
  
}