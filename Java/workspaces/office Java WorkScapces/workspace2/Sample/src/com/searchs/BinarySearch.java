package com.searchs;

import java.util.InputMismatchException;
import java.util.Scanner;

import praveen.bean.EmpBean;

import com.myrules.MyCriteria;

public class BinarySearch extends MyCriteria{

	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		Scanner s=new Scanner(System.in);
		System.out.println("How records do ypu want to Enter:");
		int len=s.nextInt();
		Object[] emp=bs.input(len);
		System.out.print("Enter Key To Search:");
		int key=s.nextInt();
		Object SearchKey=new Integer(key);
		//checkCondition(emp, key);
		if(bs.isExist(emp,SearchKey))
		{
			System.out.println("ok");
		}
		else {
			System.out.println("not ok");
		}
	}

	private  boolean isExist(Object[] emp, Object searchKey) {
		

		for(int i=0,check;i<emp.length;i++)
		{ 
			check=checkCondition(emp[i], searchKey);
			if(check==0)
			{
				return true;
			}
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
			System.out.print("Employee "+(i+1)+":ID");
			int id=1;
			try {
				id = s.nextInt();
			} catch (InputMismatchException e) {
				//e.printStackTrace();
				System.out.println("\n\n\n\nID Should be Number");
				System.out.println("Sorry Try Again....!");
				System.exit(0);
			}
			//System.out.println("id:"+id);
			System.out.println("Employee Name:");
			String name=s.next();
			//System.out.println("Name:"+name);
			((EmpBean) emp[i]).setEmployeeID(id);
			((EmpBean) emp[i]).setEmployeeName(name);
		}
		return emp;
	}

}
