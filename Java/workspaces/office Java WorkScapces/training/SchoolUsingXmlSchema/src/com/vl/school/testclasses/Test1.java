package com.vl.school.testclasses;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.vl.handlers.MyErrorHandler;
import com.vl.handlers.SaxHandler;

public class Test1 {
	public static void main(String[] args) {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try {
			SAXParser parser=factory.newSAXParser();
			SaxHandler handler=new SaxHandler();
			XMLReader reader=parser.getXMLReader();
			reader.setErrorHandler(new MyErrorHandler());
			reader.setContentHandler(handler);
			reader.parse(new InputSource("/home/praveen/Downloads/wokspaces/training/SchoolUsingXml/xml/School.xml"));
			handler.display();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
