package com.snapfish.fileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.snapfish.fileReading.bean.EmployeeRecord;

public class MyFileReader {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"/home/praveen/Desktop/training/EmployeeRecordsFilter/src/com/vlabs/employee/bean/Myinputfile"));
			List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
			EmployeeRecord eRecord = null;
			String str;
			StringTokenizer sTokenizer=null;
			while ((str = in.readLine()) != null) {
				sTokenizer=new StringTokenizer(str, ",");
				String st[]=new String[3];
				int i=0;
				while(sTokenizer.hasMoreTokens())
				{
					st[i]=sTokenizer.nextToken();
					i++;
				}
					if (st[0]!=null) {
						int id = Integer.parseInt(st[0]);
						String status = st[1];
						long time=Date.parse(st[2]);
						Date date = new Date(time);
//						System.out.println(date);
						eRecord = new EmployeeRecord(id, status, date);
						list.add(eRecord);
					}
			
			}
			/*java.util.Iterator<EmployeeRecord> itr=list.iterator();
			System.out.println(list.size());
			while (itr.hasNext()) {
				EmployeeRecord employeeRecord = (EmployeeRecord) itr.next();
				System.out.println("The EmployeeId "+employeeRecord.getId()+" EmployeeStatus "+employeeRecord.getStatus()+" EmployeeTime "+employeeRecord.getD());
				
			}*/
			
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}

}
