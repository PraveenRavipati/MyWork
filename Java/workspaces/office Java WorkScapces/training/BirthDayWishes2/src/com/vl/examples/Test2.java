package com.vl.examples;

import java.io.BufferedReader;
import java.util.Scanner;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the string:");
		String string=s.nextLine();
		System.out.print("\nEnter the integer:");
		int i=s.nextInt();
		System.out.println(string+" "+i);
	}

}
