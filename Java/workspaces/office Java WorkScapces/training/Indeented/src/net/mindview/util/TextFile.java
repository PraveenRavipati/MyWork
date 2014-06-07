package net.mindview.util;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	// Read a file as a single string:
	public static String read(String fileName) {
		int n=0;
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
					System.out.println(s.length());
			/*		for(int i=0,m=0;i<s.length();i++)
					{
						if(s.charAt(i)=='{')
						{
							
							n=n+1;
							m=n;
							//System.out.println("m:"+m);
							do
							{
								sb.append('-');
								m=m-1;
								System.out.println("m:"+m);
							}while(m>0);
						}
						if(s.charAt(i)=='}')
						{
							n=n-1;
							m=n;
							do
							{
								m=m-1;
								sb.append('-');
							}while(m>0);
						}
					}*/
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	// Write a single file in one method call:
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Read a file, split by any regular expression:
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		// Regular expression split() often leaves an empty
		// String at the first position:
		if (get(0).equals(""))
			remove(0);
	}

	// Normally read by lines:
	public TextFile(String fileName) {
		this(fileName, "\n");
	}

	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				for (String item : this)
					out.println(item);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Simple test:
	public static void main(String[] args) {
		String file = read("/home/praveen/Desktop/TextFile.java");
		write("/home/praveen/Desktop/test1.java", file);
		TextFile text = new TextFile("/home/praveen/Desktop/test1.java");
		text.write("/home/praveen/Desktop/test1.java");
		
	}
}