package com.test;

import java.util.Scanner;

import com.control.MainLogic2;

public class Test4 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		MainLogic2 ml=new MainLogic2();
		System.out.println("Enter the Number:");
		int number=s.nextInt();
		ml.mainLogic(number);
	}

}
