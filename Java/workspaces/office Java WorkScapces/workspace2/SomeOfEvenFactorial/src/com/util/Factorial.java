package com.util;

public class Factorial {
	/* Factorial method*/
	public int factorialValue(int upto)
	{
		int product=1;
		if(upto>0)
		{
			/*Factorial Logic*/
			for(int i=1;i<=upto;i++)
				product=product*i;
			return product;
		}else
		{
		return 1;
		}
	}
}
