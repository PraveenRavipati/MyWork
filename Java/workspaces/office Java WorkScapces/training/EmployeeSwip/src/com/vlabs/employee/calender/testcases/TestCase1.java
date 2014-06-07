package com.vlabs.employee.calender.testcases;

import java.util.Calendar;
import java.util.Date;


public class TestCase1 {

	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		@SuppressWarnings("deprecation")
		long d=Date.parse("Thu Apr 10 11:54:41 CDT 2014");
		Date date=new Date(d);
		System.out.println("date:"+date);
		System.out.println("The Ccalender:"+calendar);
	}

}
