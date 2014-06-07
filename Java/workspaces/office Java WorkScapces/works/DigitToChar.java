package com.digit;

import java.util.Scanner;


public class DigitToChar {
	private String Number[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eightteen","NineTeen","","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};
	/* This Method Counts the Number of Digits*/
	public int digitCount(int number)
	{
		int count=0;
		while(number>0)
		{
			count++;
			number=number/10;
		}
		return count;
	}
	public void mainLogic(int number)
	{
		int reqiuredDigit;
		if(((digitCount(number))==0)||((digitCount(number))>9))
		{
			System.out.println("Sorry try again");
			System.out.println("Enter The digit in between 1 to 9");
		}else if(((digitCount(number))==8)||((digitCount(number))==9))
		{
			reqiuredDigit=number/10000000;
			printWord(reqiuredDigit, "crores");
			number=number%10000000;
			mainLogic(number);
		}else if(((digitCount(number))==7)||(digitCount(number))==6)
		{
			reqiuredDigit=number/100000;
			printWord(reqiuredDigit, "Lakhs");
			number=number%100000;
			mainLogic(number);
		}else if(((digitCount(number))==5)||((digitCount(number))==4))
		{
			reqiuredDigit=number/1000;
			printWord(reqiuredDigit, "Thousand");
			number=number%1000;
			mainLogic(number);
		}else if((digitCount(number))==3)
		{
			reqiuredDigit=number/100;
			printWord(reqiuredDigit, "Hundread And");
			number=number%100;
			mainLogic(number);
		}else if(((digitCount(number))==2)||((digitCount(number))==1))
		{
			printWord(number, " ");
		}
	}
	public void printWord(int reqiuredDigit,String string)
	{
		int tensDigit;
		int unitDigit;
		String word;
		if(reqiuredDigit<20)
		{
			word=belowTwenty(reqiuredDigit);
			System.out.print(word+" ");
			System.out.print(" "+string+" ");
		}
		else {
			tensDigit=reqiuredDigit/10;
			unitDigit=reqiuredDigit%10;
			tensDigit=tensDigit+20;
			word=belowTwenty(tensDigit);
			System.out.print(word+" ");
			word=belowTwenty(unitDigit);
			System.out.print(word+" ");
			System.out.print(" "+string+" ");
		}
	}
	public String belowTwenty(int index)
	{
		
		String word="";
		word=Number[index];
		return word;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		DigitToChar dt=new DigitToChar();
		System.out.println("Enter the Number:");
		int number=s.nextInt();
		dt.mainLogic(number);
	}

}
