package indentation.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Indentation extends ArrayList<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("\n\nEnter The Path of the File to Read");
		String readfilepath = s.next();
		String file = readFile(readfilepath);
		System.out.println("\n\nEnter The Path of the File To Write");
		String writefilepath = s.next();
		writeFile(writefilepath, file);
		Indentation indentation = new Indentation(writefilepath);
		indentation.writeFile(writefilepath);

	}

	public Indentation(String fileName, String splitter) {
		super(Arrays.asList(readFile(fileName).split(splitter)));
		// Regular expression split() often leaves an empty
		// String at the first position:
		if (get(0).equals(""))
			remove(0);
	}

	public Indentation(String fileName) {
		this(fileName, "\n");
	}

	public static String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sp = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));
			try {
				int n=0;
				String s;
				int cd=0;
				while ((s = in.readLine()) != null) {
				/*	sb.append(s);
					sb.append("");*/
					int i=0;
					while(i<s.length())
					{
						if((i==0)&&(sp!=null))
						{
							sb.insert(i, sp);
						}else if (s.charAt(i)=='{') {
							n=cd++;
							while(n!=0)
							{
								n--;
								sp.append("\t");
							}
							sb.append(sp);
							sb.append(s);
							sb.append("\n");
							i++;
						}else if (s.charAt(i)=='}') {
							n=cd--;
							while(n!=0)
							{
								n--;
								sp.append("\t");
							}
							sb.append(sp);
							sb.append(s);
							sb.append("\n");
							i++;
						}
						else {
							sb.append(sp);
							sb.append(s);
							sb.append("\n");
							i++;
						}
					}
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	public static void writeFile(String writefilepath, String file) {
		try {
			PrintWriter out = new PrintWriter(
					new File(writefilepath).getAbsoluteFile());
			try {
				out.print(file);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public void writeFile(String writefilepath) {
		try {
			PrintWriter out = new PrintWriter(
					new File(writefilepath).getAbsoluteFile());
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

}
