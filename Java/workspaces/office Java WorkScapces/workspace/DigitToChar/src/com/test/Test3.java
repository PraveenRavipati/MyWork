package com.test;

import java.util.Scanner;

import com.control.MainLogic;

public class Test3 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		MainLogic ml=new MainLogic();
		System.out.println("Enter the Number:");
		int number=s.nextInt();
		ml.mainLogic(number);
	}

}
