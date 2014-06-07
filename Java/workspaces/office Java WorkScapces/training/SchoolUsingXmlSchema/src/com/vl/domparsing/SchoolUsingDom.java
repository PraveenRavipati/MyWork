package com.vl.domparsing;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vl.domparsing.beans.School;

public class SchoolUsingDom {
	static String filePath=null;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the file path:");
		filePath=s.next();
		SchoolUsingDom dom=new SchoolUsingDom();
		dom.searchingMethod(filePath);
		
	}
	public void docParser(){
		
	}
	public void searchingMethod(String FilePath){
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=builderFactory.newDocumentBuilder();
			Document document=builder.parse(FilePath);
			School school=new School();
			NodeList nodeList=document.getDocumentElement().getChildNodes();
			for(int i=0;i<nodeList.getLength();i++){
				System.out.println(nodeList.item(i));
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
