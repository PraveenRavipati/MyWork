package com.vl.parsing.sax.purchaseorder.testclasses;

import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.vl.parsing.sax.purchaseorder.beans.PurchaseOrder;
import com.vl.parsing.sax.purchaseorder.handler.POHandler;

public class Test {

	public static void main(String[] args) throws MalformedInputException {
		System.out.println("Main Started");
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		try {
			SAXParser saxParser=saxParserFactory.newSAXParser();
			POHandler handler=new POHandler();
			saxParser.parse(new File("/home/praveen/Desktop/xml/dtd/perchaseOrder.xml"), handler);
			PurchaseOrder purchaseOrder=handler.getOrder();
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
		System.out.println("Main Ended");
	}
}
