package inh.func.testcases;

import inh.func.exceoptions.MyAgeException;
import inh.func.inhableclasses.NameMethods;

import java.util.Scanner;

public class TestCase1 extends NameMethods{

	public static void main(String[] args) throws MyAgeException {
		System.out.println("Enter The Age is:");
		Scanner s=new Scanner(System.in);
		int age=s.nextInt();
		TestCase1 tc=new TestCase1();
		tc.AgeFinder(age);
		System.out.println("Enter the Name:");
		String Name=s.next();
		tc.NameFinder(Name);
	}

}
