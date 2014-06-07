package com.test;

import java.util.Scanner;

import com.required.MainLogic;

public class Test1 {
	/*Main method*/
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter The Series:");
		int Upto=s.nextInt();
		MainLogic m=new MainLogic();
		int result=m.sericeLogic(Upto);
		System.out.println("The Result:"+result);
	}
}