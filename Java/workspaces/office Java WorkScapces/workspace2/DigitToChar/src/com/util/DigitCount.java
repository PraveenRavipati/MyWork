package com.util;

public class DigitCount {
	/* This Method Counts the Number of Digits*/
	public int digitCount(int number)
	{
		int count=0;
		while(number>0)
		{
			count++;
			//System.out.println("count"+count);
			number=number/10;
			//System.out.println("number:"+number);
		}
		return count;
	}
}
