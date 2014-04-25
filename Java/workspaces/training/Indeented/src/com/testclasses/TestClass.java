package com.testclasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {
	static String text="praveen\nsrinu\traghava\nvendra";
    public static void main(String[] args) {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter The File Path");
    	String file=s.next();
        try {
          //File file = new File("example.txt");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(text);
          output.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }
    }
}