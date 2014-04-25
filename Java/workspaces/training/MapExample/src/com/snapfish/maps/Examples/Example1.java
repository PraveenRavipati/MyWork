package com.snapfish.maps.Examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.snapfish.maps.Examples.Beans.Employee;
import com.snapfish.maps.Examples.keys.KeyE1;

public class Example1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Map<KeyE1, Employee> m=new HashMap<KeyE1, Employee>();
		int condition=1;
		while(condition!=4)
		{
			System.out.print("\nMenu\n1)Add\n2)Display\n3)Search\n4)Exit\n\noption:");
			int option=s.nextInt();
			if(option==1)
			{
				System.out.println("Enter the Details of An Employee:");
				Employee e=Employee.setEmployee();
				
				if(m.put(KeyE1.setKey(e.getEmployeeId(), e.getEmployeeName()), e)==null)
				{
					System.out.println("the Element is completely Inserted");
				}
				else
				{
					System.out.println("The Insertion Failed");
				}
			}
			else if (option==2) {
				for (Entry<KeyE1, Employee> entry : m.entrySet()) {
		            KeyE1 key = entry.getKey();
		            Employee employee = entry.getValue();
		            System.out.println("Key = " + key.getID()+" ,"+key.getName());
		            Employee.displayEmployee(employee);
		        }
			}
			else if (option==3) {
				System.out.println("Enter The Key to Serach");
				System.out.print("\nEnter The Id:");
				int id=s.nextInt();
				System.out.print("\nEnter The Name:");
				String Name=s.next();
				KeyE1 key=new KeyE1(id, Name);
				Employee employee=m.get(key);
				if(employee!=null)
				{
					Employee.displayEmployee(employee);
				}
				else {
					System.out.println("No Employee Found with this Number");
				}
				
			}
			else if (option==4) {
				System.out.println("Thank you for Testing");
				condition=option;
			}
			else {
				System.out.println("sorry wrong option");
			}
		}
	}

}
