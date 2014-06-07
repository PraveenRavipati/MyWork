package com.myrules;

import praveen.bean.EmpBean;
import praveen.rules.Criteria;

public class MyCriteria implements Criteria{
	public int checkCondition(Object Element,Object key)
	{
		EmpBean emp=(EmpBean) Element;
		String search=(String) key;
		System.out.println("EmployeeID:"+emp.getEmployeeID()+"\nEmployeeName:"+emp.getEmployeeName()+"\n\n AND \n\n Serach Key:");
		return 0;
	}
}
