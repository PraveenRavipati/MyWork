package com.soef;

import java.util.Scanner;

public class SomeOfEvenFact {
	public long seriseLogic(int upto)
	{

		long sum=1;
		long product=1;
		for(int i=2;i<=upto;i=i+2)
		{
			System.out.println("i:"+i);
			product=product*(i-1)*(i);
			System.out.println("product:"+product);
			sum=sum+product;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Enter The Series:");
		int Upto=s.nextInt();
		SomeOfEvenFact m=new SomeOfEvenFact();
		long result=m.seriseLogic(Upto);
		System.out.println("The Result:"+result);

	}

}
