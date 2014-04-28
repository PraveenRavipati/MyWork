package com.searchs;

import java.util.Arrays;
import praveen.bean.EmpBean;

import com.myrules.MyCriteria;

public class BinarySearch {
        //This method checks whether key is Exist or Not
	public boolean isExist(Object[] Elements, Object searchKey, MyCriteria m) {
		int first = 0, len = Elements.length;
		int condition;
		EmpBean[] emp = (EmpBean[]) Elements;
		int searchID = 0;
		String searchName = null;
		Object[] id = new Integer[Elements.length];
		Object[] names = new String[Elements.length];
		try {
			searchID = (Integer) searchKey;
		} catch (ClassCastException e) {
			searchName = (String) searchKey;
		}
		if (searchID != 0) {
			for (int i = 0; i < emp.length; i++) {
				id[i] = emp[i].EmployeeID;
			}
			Arrays.sort(id);
			while (first < len) {
				int mid = (first + len) / 2;
				condition = m.checkCondition(id[mid], searchKey);
				if (condition == 0) {
					return true;
				} else if (condition > 0) {
					len = mid;
				} else {
					first = mid + 1;
				}
			}
			return false;

		} else if (searchName != null) {
			for (int i = 0; i < emp.length; i++)
				names[i] = emp[i].EmployeeName;
			Arrays.sort(names);
			while (first < len) {
				int mid = (first + len) / 2;
				condition = m.checkCondition(names[mid], searchKey);
				if (condition == 0) {
					return true;
				} else if (condition > 0) {
					first = mid + 1;
				} else {
					len = mid;
				}
			}
			return false;
		}
		return false;
	}
	
}
