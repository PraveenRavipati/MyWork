package testClasses.tests;

import java.util.Scanner;

import com.myrules.MyCriteria;


public class test {


	public static void main(String[] args) {
		MyCriteria m=new MyCriteria() {
		};
		Scanner s=new Scanner(System.in);
		System.out.println("Enter The No OF Elements To Enter:");
		int len=s.nextInt();
		Object[] id=new Integer[len];
		for(int i=0;i<id.length;i++)
		{
			System.out.print("\n\nEnter the Value of Id : "+(i+1));
			int value=s.nextInt();
			id[i]=new Integer(value);
		}
		
		id=m.sortInDes(id);
		for(int i=0;i<id.length;i++)
		{
			System.out.println("the Value of Id : "+id[i]);
		}
	}

}
