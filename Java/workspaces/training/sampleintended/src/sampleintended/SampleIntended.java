package sampleintended;

import java.io.FileInputStream;
import java.util.Scanner;

public class SampleIntended {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter The Path of The File");
			String filePath = s.next();
			FileInputStream inputStream = new FileInputStream("foo.txt");

		//	String everything = IOUtils.toString(inputStream);

		} catch (Exception e) {

		}
	}

}
