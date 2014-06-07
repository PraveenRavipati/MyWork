package com.searchs;


import java.util.InputMismatchException;
import java.util.Scanner;

import praveen.bean.EmpBean;

import com.myrules.MyCriteria;

public class BinarySearch extends MyCriteria{

	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		Scanner s=new Scanner(System.in);
		System.out.print("How records do ypu want to Enter:\t");
		int len=s.nextInt();
		Object[] emp=bs.input(len);
		Object SearchKey=bs.inputOfSearchKey();
		if(SearchKey!=null)
		{	
			if(bs.isExist(emp,SearchKey))
			{
				System.out.println("The Employee found");
			}
			else {
				System.out.println("The Employee Not found");
			}
		}
		else {
			System.out.println("Sorry try again...!");
		}
	}

	private Object inputOfSearchKey() {
		Scanner s=new Scanner(System.in);
		boolean condition=true;
		Object searchkey=null;
		while(condition)
		{
			System.out.println("1.Search through ID:");
			System.out.println("2.Search through Name:");
			System.out.println("\n\n\n");
			System.out.print("Enter the Option:\t");
			int option=s.nextInt();
			if(option==1)
			{
				System.out.print("\nEnter Key To Search:\t");
				int key=s.nextInt();
				searchkey=new Integer(key);
				condition=false;
			}
			else if (option==2) {
				System.out.print("\nEnter Key To Search:\t");
				String key=s.next();
				searchkey=new String(key);
				condition=false;
			}
			else {
				System.out.println("");
				condition=false;
			}
		}
		return searchkey;
	}

	private  boolean isExist(Object[] emp, Object searchKey) {
		int first=0,len=emp.length;
		int condition;
		
		while(first < len)
		{
			int mid = (first + len) / 2;
			condition=checkCondition(emp[mid], searchKey);
			if (condition==0)
				return true;
			else if (condition>0)
				len = mid;
			else
				first = mid + 1;
		}
		return false;	
	}

	private Object[] input(int len) {
		Scanner s=new Scanner(System.in);
		Object[] emp=new EmpBean[len];
		System.out.println("Enter the Employee Details");
		for(int i=0;i<emp.length;i++)
		{
			emp[i]=new EmpBean();
			//System.out.print("Employee "+(i+1)+" ID :\t");
			int id=1;
			try {
				id = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n\n\n\nID Should be Number");
				System.out.println("Sorry Try Again....!");
				System.exit(0);
			}
			//System.out.print("Employee "+(i+1)+" Name:\t");
			String name=s.next();
			((EmpBean) emp[i]).EmployeeID=id;
			((EmpBean) emp[i]).EmployeeName=name;
		}
		return emp;
	}

}