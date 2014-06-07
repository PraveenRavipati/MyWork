package com.util;

public class PrimeNumber {
	/*this method checks whether the number is prime or not*/
	public boolean isPrime(int number)
	{
		boolean flag=false;
		//System.out.println("number"+number);
		for(int i=2;i<number;i++)
		{
			if(((number%i)%2)==0)
			{
				flag=false;
			}
			else {
				flag=true;
			}
		}
		//System.out.println(flag);
		return flag;
	}
}