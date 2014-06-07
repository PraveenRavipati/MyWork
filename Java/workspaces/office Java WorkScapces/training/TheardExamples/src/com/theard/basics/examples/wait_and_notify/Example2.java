package com.theard.basics.examples.wait_and_notify;
/*In this program The main thread,and remaining Threads never finish its execution*/
public class Example2 extends Thread {

    private WaitDemo wd = new WaitDemo();

    public static void main(String[] args) {
    	System.out.println("Main stated");
        Example2 cd1 = new Example2();
        Example2 cd2 = new Example2();
        cd1.setName("Praveen Srinivas Ravipati");
        cd2.setName("Raghavendra Ravipati");
        cd1.start();
        cd2.start();
        try {
			cd1.join();
			cd2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("main completed");

    }

    synchronized void display() {
        System.out.println("Hello");
        notifyAll();
    }

    public void run() {

        synchronized (this) {
            try {
                {
                    this.notify();
                    System.out.println("The thread is " + currentThread().getName());
                    wait();
                    System.out.println("The value is " + wd.display());
                }
            } catch (InterruptedException e) {

            }

        }
    }
}