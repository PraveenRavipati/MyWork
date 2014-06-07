package com.vl.parsing.sax.examples;
import java.io.File;
import java.util.List;
 
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
 
 
public class XMLParserSAX {
 
    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
    	saxParserFactory.setValidating(true);
    	saxParserFactory.setNamespaceAware(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader reader=saxParser.getXMLReader();
        reader.setErrorHandler(new SimpleErrorHandler());
        MyHandler handler = new MyHandler();
//        MyDTDHandler handler=new MyDTDHandler();
//        reader.parse(new InputSource("/home/praveen/Downloads/wokspaces/training/Parsing/src/com/vl/parsing/sax/examples/employee.xml"), handler);
//        saxParser.parse(new File("/home/praveen/Downloads/wokspaces/training/Parsing/src/com/vl/parsing/sax/examples/employee.xml"), handler);
        reader.setContentHandler(handler);
//        reader.setDTDHandler(handler);
        reader.parse(new InputSource("/home/praveen/Downloads/wokspaces/training/Parsing/src/com/vl/parsing/sax/examples/employeein.xml"));
        //Get Employees list
        List<Employee> empList = handler.getEmpList();
        //print employee information
        for(Employee emp : empList)
            System.out.println(emp);
    } 
    catch (SAXParseException e) {
    	 e.printStackTrace();
	}
    catch (Exception e) {
    	 e.printStackTrace();
    }
 
    }
 
}