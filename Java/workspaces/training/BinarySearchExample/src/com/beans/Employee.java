package com.beans;
    public class Employee implements Comparable<Employee>{
     
    public Employee() {
     
     }
     
    public Employee(String empName) {
     this.empName = empName;
     }
    public Employee(int empId)
    {
    	this.empId=empId;
    }
    public Employee(int empId,String empName)
    {
    	this.empId=empId;
    	this.empName=empName;
    }
     
    private int empId;
    private String empName;
     
    public String getEmpName() {
    return empName;
     }
    public void setEmpName(String empName) {
     this.empName = empName;
     }
     
    public int compareTo(Employee o) {
    return this.empName.compareTo(o.getEmpName());
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


}
