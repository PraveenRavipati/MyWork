package com.theard.basics;

public class LifeCycle {
	static Iclass i=new Iclass();
	public static void main(String[] args) {
		int n=1;
		
		MyThread m[]=new MyThread[n];
		for(int j=0;j<n;j++)
		{
			m[j]=new MyThread();
			m[j].start();
		}
	}
	public static Iclass getIclass()
	{
		return i;
	}

}
class MyThread extends Thread
{
	
	public void run() {
		for(int j=0;j<100;j++)
		{
			LifeCycle.getIclass().incrI();
			System.out.println("The I value is "+LifeCycle.getIclass().getI()+" was incremented by thread :"+this.getName());
		}
		for(int k=0;k<100;k++)
		{
			LifeCycle.getIclass().decI();
			System.out.println("The I value is "+LifeCycle.getIclass().getI()+" was decremented by thread :"+this.getName());
		}
		
	}
}
class Iclass
{
	private static int i=0;
	public void incrI() {
		i++;
	}
	public void decI()
	{
		i--;
	}
	public int getI() {
		return i;
	}
	
}
