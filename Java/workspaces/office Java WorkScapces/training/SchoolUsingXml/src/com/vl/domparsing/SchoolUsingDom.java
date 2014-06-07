package com.vl.domparsing;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vl.domparsing.beans.Class;
import com.vl.domparsing.beans.Classes;
import com.vl.domparsing.beans.Details;
import com.vl.domparsing.beans.School;
import com.vl.domparsing.beans.Staff;
import com.vl.domparsing.beans.Student;
import com.vl.domparsing.beans.Teacher;

public class SchoolUsingDom {
	static String filePath=null;
	private Details details; 
	private Staff staff;
	private Teacher teacher;
	private Classes classes;
	private Class class1;
	private Student student;
	private School school;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the file path:");
		filePath=s.next();
		SchoolUsingDom dom=new SchoolUsingDom();
		dom.searchingMethod(filePath);
		dom.display();

	}
	public void display(){
		List<Teacher> list;
		List<Class> classList;
		List<Student> stuList;
		System.out.println("School Name:"+school.getDetails().getSchoolName());
		System.out.println("School Address:"+school.getDetails().getAddress());
		System.out.println("staff");
		list=school.getStaff().getTeachers();
		for(Teacher t:list){
			System.out.println("Teacher Name:"+t.getName());
			System.out.println("Responsible for:"+t.getClassResponesable());
		}
		classList=school.getClasses().getClasses();
		for(Class c:classList){
			System.out.println("class Name:"+c.getClassName());
			stuList=c.getStudents();
			for(Student s:stuList){
				System.out.println("Student Name:"+s.getSName());
				System.out.println("Student DOB:"+s.getSDOB());
				System.out.println("student Address:"+s.getSAddress());
			}
		}
	}
	public void searchingMethod(String FilePath){
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=builderFactory.newDocumentBuilder();
			Document document=builder.parse(FilePath);
			school=new School();
			NodeList nodeList=document.getDocumentElement().getChildNodes();
			for(int i=0;i<nodeList.getLength();i++){
				Element element=(Element) nodeList.item(i);
				if(element.getNodeName().equalsIgnoreCase("Details"))
				{
					details=new Details();
					NodeList detailsList=element.getChildNodes();
					for(int j=0;j<detailsList.getLength();j++)
					{
						Element deElement=(Element) detailsList.item(j);
						if(deElement.getNodeName().equalsIgnoreCase("SchoolName")){
							details.setSchoolName(deElement.getLastChild().getNodeValue());
						}
						else if (deElement.getNodeName().equalsIgnoreCase("Address")) {
							details.setAddress(deElement.getLastChild().getNodeValue());
						}
					}
					school.setDetails(details);
				}
				else if (element.getNodeName().equalsIgnoreCase("Staff")) {
					staff=new Staff();
					NodeList staffList=element.getChildNodes();
					for(int j=0;j<staffList.getLength();j++){
						Element staffElement=(Element) staffList.item(j);
						if(staffElement.getNodeName().equalsIgnoreCase("Teacher")){
							teacher=new Teacher();
							NodeList teacherList=staffElement.getChildNodes();
							for(int k=0;k<teacherList.getLength();k++){
								Element tElement=(Element) teacherList.item(k);
								if(tElement.getNodeName().equalsIgnoreCase("Name")){
									teacher.setName(tElement.getLastChild().getNodeValue());
								}
								else if (tElement.getNodeName().equalsIgnoreCase("ClassResponesable")) {
									teacher.setClassResponesable(tElement.getLastChild().getNodeValue());
								}
							}
							staff.addTeachers(teacher);
						}
					}
					school.setStaff(staff);
				}
				else if (element.getNodeName().equalsIgnoreCase("Classes")) {
					classes=new Classes();
					NodeList classesList=element.getChildNodes();
					for(int j=0;j<classesList.getLength();j++){
						Element classesElement=(Element) classesList.item(j);
						if(classesElement.getNodeName().equalsIgnoreCase("Class")){
							class1=new Class();
							NodeList classList=classesElement.getChildNodes();
							for(int k=0;k<classList.getLength();k++){
								Element classElement=(Element) classList.item(k);
								if(classElement.getNodeName().equalsIgnoreCase("ClassName")){
									class1.setClassName(classElement.getLastChild().getNodeValue());
								}
								else if (classElement.getNodeName().equalsIgnoreCase("Students")) {
									NodeList studentsList=classElement.getChildNodes();
									for(int l=0;l<studentsList.getLength();l++){
										Element studentsElement=(Element) studentsList.item(l);
										if(studentsElement.getNodeName().equalsIgnoreCase("Student")){
											student=new Student();
											NodeList stList=studentsElement.getChildNodes();
											for(int m=0;m<stList.getLength();m++){
												Element stElement=(Element) stList.item(m);
												if(stElement.getNodeName().equalsIgnoreCase("SName")){
													student.setSName(stElement.getLastChild().getNodeValue());
												}
												else if (stElement.getNodeName().equalsIgnoreCase("SDOB")) {
													int year = 0,month=0,day=0;
													NodeList dList=stElement.getChildNodes();
													for(int n=0;n<dList.getLength();n++){
														Element dateElement=(Element) dList.item(n);
														if(dateElement.getNodeName().equalsIgnoreCase("year")){
															year=(Integer.parseInt(dateElement.getLastChild().getNodeValue())-1900);
														}
														else if (dateElement.getNodeName().equalsIgnoreCase("month")) {
															month=(Integer.parseInt(dateElement.getLastChild().getNodeValue())-1);
														}
														else if (dateElement.getNodeName().equalsIgnoreCase("date")) {
															day=Integer.parseInt(dateElement.getLastChild().getNodeValue());
														}
													}
													Date d=new Date(year, month, day);
													student.setSDOB(d);
												}
												else if (stElement.getNodeName().equalsIgnoreCase("SAddress")) {
													student.setSAddress(stElement.getLastChild().getNodeValue());
												}
											}
											class1.addStudent(student);
										}
									}
								}
							}
							classes.addClass(class1);
						}
					}
					school.setClasses(classes);
				}

			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}

}
