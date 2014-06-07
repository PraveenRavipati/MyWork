package com.vl.parsing.sax.examples;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("warning "+e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("error "+e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("fatalError "+e.getMessage());
    }
}