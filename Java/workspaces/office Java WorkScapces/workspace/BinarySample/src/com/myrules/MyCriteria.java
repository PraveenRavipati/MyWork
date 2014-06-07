package com.myrules;

import praveen.bean.EmpBean;
import praveen.rules.Criteria;

public class MyCriteria implements Criteria{
	public int checkCondition(Object Element,Object key)
	{
		EmpBean emp=(EmpBean) Element;
		Integer searchID=0;
		String searchName=null;
		int status;
		try {
			searchID = (Integer) key;
		} catch (ClassCastException e) {
			searchName=(String) key;
			//e.printStackTrace();
		}
		if(searchID!=0)
		{
			int id=emp.EmployeeID;
			if(id==searchID)
			{
				status=0;
				return status;
			}
			else if (id>searchID) {
				status=1;
				return status;
			}
			else {
				status=-1;
				return status;
			}
		}else if(searchName!=null)
		{
			status=searchName.compareToIgnoreCase(emp.EmployeeName);
			System.out.println("status "+status);
			return status;
		}
		else
		{
			System.out.println("sorry try agin");
		}
		return 1;
	}
}
