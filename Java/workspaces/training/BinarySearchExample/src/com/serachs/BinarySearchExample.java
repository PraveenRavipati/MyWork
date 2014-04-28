package com.serachs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beans.Employee;

public class BinarySearchExample {

	public static void main(String[] args) {

		Employee e1 = new Employee(514,"Kavya");
		Employee e2 = new Employee(515,"Bargavi");
		Employee e3 = new Employee(519,"Nagaraju");
		Employee e4 = new Employee(523,"Praveen");
		Employee e5 = new Employee(1206,"Sumanth");

		List<Employee> list = new ArrayList<Employee>();

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		System.out.println("---------------- Binary Search ----------------");

		Collections.sort(list);

		int location = Collections.binarySearch(list, new Employee("Praveen"));

		if (location >= 0) {

			Employee emp = (Employee) list.get(location);
			System.out.println("Successfully Searched Employee : "
					+ emp.getEmpName());
		} else {

			System.out.println("Employee does not exists");
		}
	}
}
