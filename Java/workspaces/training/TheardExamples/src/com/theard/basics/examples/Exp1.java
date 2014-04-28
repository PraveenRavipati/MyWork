package com.theard.basics.examples;

public class Exp1 {

	public static void main(String[] args) {
		MyIncriment myin=new MyIncriment();
		Thread ti=new Thread(myin);
		MyDicriment myde=new MyDicriment();
		Thread td=new Thread(myde);
		ti.start();
		td.start();
		for(int i=0;i<20;i++)
		{
			myin.setI(i);

			myde.setI(i);
		}
		
	}

}
class MyIncriment implements Runnable
{
	static int i;
	public void setI(int i)
	{
		this.i=i;
	}

	@Override
	public void run() {
		i++;
		System.out.println("IN The THREAD "+(this.toString())+" i:"+i);
		
	}
	
}
class MyDicriment implements Runnable
{
	static int i;
	public void setI(int i)
	{
		this.i=i;
	}
	@Override
	public void run() {
		i--;
		System.out.println("IN The THREAD "+(this.toString())+" i:"+i);
	}
	
}