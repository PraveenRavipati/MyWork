package com.vl.school.bean;

import java.util.Calendar;

public class Student {
	private String SName;
	private Calendar SDOB;
	private String SAddress;
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public Calendar getSDOB() {
		return SDOB;
	}
	public void setSDOB(Calendar sDOB) {
		SDOB = sDOB;
	}
	public String getSAddress() {
		return SAddress;
	}
	public void setSAddress(String sAddress) {
		SAddress = sAddress;
	}
}
