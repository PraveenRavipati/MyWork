package com.searches;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	/* This Method Checks Whether given key EXIST or NOT */
	private static boolean isElementExist(int[] Elements, int key) {
		int first=0,len=Elements.length;
		while(first < len)
		{
			int mid = (first + len) / 2;
			if (Elements[mid] == key)
				return true;
			else if (Elements[mid] > key)
				len = mid;
			else
				first = mid + 1;
		}
		return false;
	}

	/* This method Take Input form User And Sort The Array */
	public int[] input(int len) {
		Scanner s = new Scanner(System.in);
		int[] Elements = new int[len];
		for (int i = 0; i < Elements.length; i++)
			Elements[i] = s.nextInt();
		Arrays.sort(Elements);
		return Elements;
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		Scanner s = new Scanner(System.in);
		int[] Elements;
		System.out.print("Enter number of elements in a list:");
		int ne = s.nextInt();
		Elements = b.input(ne);
		System.out.println("Enter Element to Search:");
		int key = s.nextInt();
		/* checking the key value */
		if (isElementExist(Elements, key))
			System.out.println("Element Exist");
		else
			System.out.println("Element Not Found");
	}

}
