package com.intended.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IntendingFile {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		try {
			String path = null;
			System.out.print("\nEnter The Path of the File:");
			path = s.next();
			FileInputStream readfile = new FileInputStream(path);
			int len = readfile.available();
			byte ba[] = new byte[len];
			readfile.read(ba);
			String data = new String(ba);
			char[] chars = data.toCharArray();
			for (int i = 0; i < len; i++) {
				if ((chars[i] == ';') && (chars[i + 1] != '\n')) {
					System.out.print(chars[i]);
					System.out.print("\n");
				}
				else if ((chars[i]=='\n')&&(chars[i+1]=='{')) {
					System.out.print(" "+chars[i+1]+"\n");
				}else {
					System.out.print(chars[i]);
				}
				
			}
			readfile.close();
		} catch (Exception e) {
			
		}
	}
}