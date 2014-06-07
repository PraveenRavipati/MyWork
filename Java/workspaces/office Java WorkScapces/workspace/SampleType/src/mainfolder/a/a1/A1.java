package mainfolder.a.a1;

import mainfolder.a.a1.a2.A2;

public class A1 extends A2{
	private String A1;
	public void setA1(String a) {
		A1 = a;
	}
	public void printA1()
	{
		System.out.println(A1+"in the A1 class");
		printA2();
	}
}
