package com.logic;

import com.util.PrimeNumber;

public class MainLogic {
	/* This method checks given two numbers are prime or not and their difference is 2 or not*/
	public void mainLogic(int first,int second)
	{
		PrimeNumber pn=new PrimeNumber();
		if((pn.isPrime(first)&&(pn.isPrime(second)))&&(((first-second)==2)||((first-second==-2))))
		{
			System.out.println("It satisfied the condition");
		}
		else {
			System.out.println("It dont satisfied the condition");
		}
	}

}