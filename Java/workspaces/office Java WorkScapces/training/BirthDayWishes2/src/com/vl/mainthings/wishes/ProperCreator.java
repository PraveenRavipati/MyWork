package com.vl.mainthings.wishes;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class ProperCreator {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Wish details:");
		System.out.print("Enter the Name:");
		String name=s.next();
		System.out.println("\nEnter the date:");
		System.out.println("Enter DATE:");
		int date=s.nextInt();
		System.out.println("Enter Month:");
		int month=s.nextInt();
		System.out.println("Enter Year:");
		int year=s.nextInt();

		
		
		System.out.println("Enter the Wish:");
		String wish=s.next();
	}

}
