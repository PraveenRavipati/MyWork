package praveen.simtestcases;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the Key:");
		String key = s.next();
		int key2;
		Float f = Float.parseFloat(key);
		if (f.isNaN()) {
			System.out.println("\n\nkey is a String " + key);
		} else {
			key2 = Integer.parseInt(key);
			System.out.println("\n\nkey is a Interger " + key2);
		}

	}

}
