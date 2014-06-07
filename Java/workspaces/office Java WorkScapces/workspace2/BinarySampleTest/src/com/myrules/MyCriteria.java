package com.myrules;

import praveen.bean.EmpBean;
import praveen.rules.Criteria;

public class MyCriteria implements Criteria{
	public int checkCondition(Object Element,Object key)
	{
		EmpBean emp=(EmpBean) Element;
		Integer searchID=0;
		String searchName=null;
		try {
			searchID = (Integer) key;
		} catch (ClassCastException e) {
			searchName=(String) key;
			e.printStackTrace();
		}
		System.out.println("EmployeeID:"+emp.getEmployeeID()+"\nEmployeeName:"+emp.getEmployeeName()+"\n\n AND \n\n Serach Key:"+searchID);
		if(searchName!=null)
		{
			System.out.println("EmployeeID:"+emp.getEmployeeID()+"\nEmployeeName:"+emp.getEmployeeName()+"\n\n AND \n\n Serach Key:"+searchName);
		}
		return 0;
	}
}
