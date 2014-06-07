package com.control;

import com.util.DigitCount;
import com.util.PrintWord;

public class MainLogic2 {
	public void mainLogic(int number)
	{
		int reqiuredDigit;
		PrintWord pw=new PrintWord();
		DigitCount dt=new DigitCount();
		if(((dt.digitCount(number))==0)||((dt.digitCount(number))>9))
		{
			System.out.println("the number should be 1 to 9 digits");
			System.out.println("sorry try again....!");
		}
		if(((dt.digitCount(number))==8)||((dt.digitCount(number))==9))
		{
			reqiuredDigit=number/10000000;
			pw.printWord(reqiuredDigit, "crores");
			number=number%10000000;
		}
		if(((dt.digitCount(number))==7)||(dt.digitCount(number))==6)
		{
			reqiuredDigit=number/100000;
			pw.printWord(reqiuredDigit, "Lakhs");
			number=number%100000;
		}
		if(((dt.digitCount(number))==5)||((dt.digitCount(number))==4))
		{
			reqiuredDigit=number/1000;
			pw.printWord(reqiuredDigit, "Thousand");
			number=number%1000;
		}
		if((dt.digitCount(number))==3)
		{
			reqiuredDigit=number/100;
			pw.printWord(reqiuredDigit, "Hundread And");
			number=number%100;
	
		}
		if(((dt.digitCount(number))==2)||((dt.digitCount(number))==1))
		{
			pw.printWord(number, " ");

		}
	}

}
