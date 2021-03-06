package praveen.simtestcases;

import java.util.Arrays;
import java.util.Scanner;


public class Test2 {

	public static int searchString(String[] names, String key) {
		int first = 0;
		int last = names.length;
		while (first < last) {
			int mid = (first + last) / 2;
			if (key.compareTo(names[mid]) < 0) {
				last = mid;
			} else if (key.compareTo(names[mid]) > 0) {
				first = mid + 1;
			} else {
				return mid;
			}
		}
		return -(first + 1);
	}

	public String[] input(int len) {
		Scanner s = new Scanner(System.in);
		String[] Elements = new String[len];
		for (int i = 0; i < Elements.length; i++){
			System.out.println("Enter The Element:"+(i+1));
			Elements[i] = s.next();
		}
		Arrays.sort(Elements);
		return Elements;
	}
	public static void main(String args[])
	{
		Test2 b = new Test2();
		Scanner s = new Scanner(System.in);
		String[] Elements;
		System.out.print("Enter number of elements in a list:");
		int ne = s.nextInt();
		Elements = b.input(ne);
		System.out.println("Enter Element to Search:");
		String key = s.next();
		/* checking the key value */
		if (isElementExist(Elements, key))
			System.out.println("Element Exist");
		else
			System.out.println("Element Not Found");
	}
	private static boolean isElementExist(String[] elements, String key) {
		int first=0,len=elements.length;
		int mid=0;
		while(first < len)
		{
			mid = (first + len) / 2;
			if (key.compareTo(elements[mid])<0)
				first = mid + 1;
			else if (key.compareTo(elements[mid]) > 0)
				len = mid;
			else
				return true;
		}
		return false;
	}
}