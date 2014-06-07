package testFolder.testclasses;

import java.util.Scanner;

import mainfolder.a.a1.A1;

public class Test1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Enter String:");
		String name=s.next();
		A1 a1=new A1();
		a1.setA1(name);
		a1.setA2(name);
		a1.printA1();
	}

}
