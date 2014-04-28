package com.tests;

public class Testclass1 {

	public static void main(String[] args) {
		//char ch='à';
		//System.out.println(Character.SURROGATE);
		String st = "!\"##$%%&&'(())*+,--../0123456789:;<=>?@@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^^__abcdefghijklmnopqrstuvwxyz{}~";
		for(int i=0; i<st.length(); i++){
			char ch = st.charAt(i);
			System.out.println(ch + " "+ Character.isLetter(ch));
		}
	}

}
