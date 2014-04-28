package com.vlabs.employee.bean;

import java.util.Date;

public class EmployeeRecord {
	private int EmployeeId;
	private String EmployeeStatus;
	private Date EmployeeEntryDate;

	public int getId() {
		return EmployeeId;
	}

	public void setId(int EmployeeId) {
		this.EmployeeId = EmployeeId;
	}

	public String isStatus() {
		return EmployeeStatus;
	}

	public void setStatus(String EmployeeStatus) {
		this.EmployeeStatus = EmployeeStatus;
	}

	public String getStatus() {
		return EmployeeStatus;
	}

	public Date getD() {
		return EmployeeEntryDate;
	}

	public void setD(Date EmployeeEntryDate) {
		this.EmployeeEntryDate = EmployeeEntryDate;
	}

	public EmployeeRecord(int EmployeeId, String EmployeeStatus, Date EmployeeEntryDate) {
		this.EmployeeId = EmployeeId;
		this.EmployeeStatus = EmployeeStatus;
		this.EmployeeEntryDate = EmployeeEntryDate;
	}

	@SuppressWarnings("deprecation")
	public boolean compareTo(Date date) {
		// System.out.println("The current employee details date:"+this.d.getDate()+" month:"+this.d.getMonth()+" year:"+this.d.getYear());
		// System.out.println("\n The required date details date:"+date.getDate()+" month:"+date.getMonth()+" Year"+date.getYear());
		boolean status = false;
		if ((date.getDate()) == (this.EmployeeEntryDate.getDate())
				&& ((date.getMonth()) == (this.EmployeeEntryDate.getMonth()))
				&& ((date.getYear()) == (this.EmployeeEntryDate.getYear() + 1900))) {
			status = true;
			return status;
		}
		else if (((date.getHours())>=(this.EmployeeEntryDate.getHours()))&&((date.getMinutes())>=(this.EmployeeEntryDate.getMinutes()))&&(this.EmployeeStatus.equalsIgnoreCase("in"))) {
			status=true;
			return status;
		}
		return status;
	}
	
}
