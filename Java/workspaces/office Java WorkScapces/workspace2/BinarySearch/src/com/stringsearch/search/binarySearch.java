package com.stringsearch.search;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		binarySearch b=new binarySearch();
		System.out.print("\n\nEnter the number of Elements to enter:\t");
		int len=s.nextInt();
		String[] names=new String[len];
		names=b.input(len);
		System.out.print("\n\nEnter the key to search:\t");
		String key=s.next();
		/*b.out(names);*/
		if(b.isExist(names,key))
		{
			System.out.println("The Element is found");
		}
		else {
			System.out.println("The Element is not found");
		}
	}

/*	private void out(String[] names) {
		for(int i=0;i<names.length;i++)
		{
			System.out.println("\nElement "+(i+1)+" is "+names[i]);
		}
		
	}*/

	public boolean isExist(String[] names, String key) {
		int first=0,len=names.length;
		while(first < len)
		{
			int mid = (first + len) / 2;
			if ((key.compareTo(names[mid])==0))
				return true;
			else if ((key.compareTo(names[mid])>0))
				first = mid + 1;
			else
				len = mid;
		}
		return false;
		
	}

	public String[] input(int len) {
		String names[]=new String[len];
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Details:");
		for(int i=0;i<names.length;i++)
		{
			System.out.println("Element "+(i+1));
			names[i]=s.next();
		}
		Arrays.sort(names);
		return names;
	}

}
