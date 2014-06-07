package com.vl.parsing.sax.examples;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDTDHandler extends DefaultHandler{
	@Override
	public void notationDecl(String name, String publicId, String systemId)
			throws SAXException {
		// TODO Auto-generated method stub
		super.notationDecl(name, publicId, systemId);
	}
	@Override
	public void unparsedEntityDecl(String name, String publicId,
			String systemId, String notationName) throws SAXException {
		// TODO Auto-generated method stub
		super.unparsedEntityDecl(name, publicId, systemId, notationName);
	}
	public List<Employee> getEmpList() {
		// TODO Auto-generated method stub
		return null;
	}
}
