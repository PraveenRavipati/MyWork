package com.snapfish.maps.Examples.Beans;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
	
	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeAddress;
	private float EmployeeSal;

	public Employee() {

	}

	public Employee(String EmployeeName, int EmployeeId,
			String EmployeeAddress,float EmployeeSal) {
		this.EmployeeName = EmployeeName;
		this.EmployeeId = EmployeeId;
		this.EmployeeAddress = EmployeeAddress;
		this.EmployeeSal=EmployeeSal;
	}
	public String getEmployeeAddress() {
		return EmployeeAddress;
	}
	public static Employee setEmployee() {
		Scanner s = new Scanner(System.in);
		int id = 0;
		String Name = null;
		String Add = null;
		float sal=(float) 0.0;
		Employee e=null;
		System.out.print("\nEnter the Employee Id:\t");

		try {
			id = s.nextInt();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Id should be Number\n");
			return null;
		}
		System.out.print("\nEnter The Employee Name:\t");
		try {
			Name = s.next();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Name Should not Be Number\n");
			return null;
		}
		System.out.print("\nEnter The Employee Address:");
		try {
			Add = s.next();
		} catch (InputMismatchException e1) {
			System.out.print("\nThe Address should not be number\n");
			return null;
		}
		System.out.print("\nEnter The Employee Salary:");
		try {
			sal = s.nextFloat();
		} catch (InputMismatchException e1) {
			System.out.print("\nThe Salary sholud not be number\n");
			return null;
		}
		if((id!=0)&&(Name!=null)&&(Add!=null)){
			e = new Employee(Name, id,Add,sal);
		}
		return e;
	}
	public static void displayEmployee(Employee e) {
		System.out.println("\n\nEmployee ID:"+e.EmployeeId);
		System.out.print("\tEmployee Name:"+e.EmployeeName);
		System.out.println("\tEmployee Address:"+e.EmployeeAddress);
		System.out.println("\tEmployee Salary:"+e.EmployeeSal);
	}

	public float getEmployeeSal() {
		return EmployeeSal;
	}

	public void setEmployeeSal(float employeeSal) {
		EmployeeSal = employeeSal;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
}
