package com.test;

import java.util.Scanner;

import com.logic.MainLogic;

public class test1 {
	/* This program takes two number checks them prime or not and their difference is 2 or not*/
	public static void main(String[] args) {
		System.out.println("Enter The Two Numbers");
		Scanner s=new Scanner(System.in);
		int first=s.nextInt();
		int second=s.nextInt();
		MainLogic ml=new MainLogic();
		ml.mainLogic(first, second);
	}

}