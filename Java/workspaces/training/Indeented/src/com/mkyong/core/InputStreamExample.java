package com.mkyong.core;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class InputStreamExample {
    public static void main(String[] args) {
 
	InputStream inputStream = null;
	BufferedReader br = null;
 
	try {
		// read this file into InputStream
		inputStream = new FileInputStream("/Users/mkyong/Downloads/file.js");
 
		br = new BufferedReader(new InputStreamReader(inputStream));
 
		StringBuilder sb = new StringBuilder();
 
		String line;
			while ((line = br.readLine()) != null) {
			sb.append(line);
		}
 
		System.out.println(sb.toString());
		System.out.println("\nDone!");
 
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }
}