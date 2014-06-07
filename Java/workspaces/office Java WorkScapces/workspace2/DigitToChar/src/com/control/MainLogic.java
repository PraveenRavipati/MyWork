package com.control;

import com.util.DigitCount;
import com.util.NoToWords;

public class MainLogic {
	public void mainLogic(int number)
	{
		int reqiuredDigit;
		int tensDigit;
		int unitDigit;
		NoToWords ntw=new NoToWords();
		
		DigitCount dt=new DigitCount();
		if((dt.digitCount(number))==0)
		{
			System.out.println("sorry try again....!");
		}
		if((dt.digitCount(number))>=8)
		{
			reqiuredDigit=number/10000000;
			if(reqiuredDigit<20)
			{
				ntw.belowTwenty(reqiuredDigit);
				System.out.print(" Crores ");
			}
			number=number%10000000;
		}
		if(((dt.digitCount(number))==7)||(dt.digitCount(number))==6)
		{
			reqiuredDigit=number/100000;
			if(reqiuredDigit<20)
			{
				ntw.belowTwenty(reqiuredDigit);
				System.out.print(" Lakhs ");
			}
			else {
				tensDigit=reqiuredDigit/10;
				unitDigit=reqiuredDigit%10;
				tensDigit=tensDigit*10;
				ntw.belowTwenty(tensDigit);
				ntw.belowTwenty(unitDigit);
				System.out.print(" Lakhs ");
			}
			number=number%100000;
		}
		if(((dt.digitCount(number))==5)||((dt.digitCount(number))==4))
		{
			reqiuredDigit=number/1000;
			if(reqiuredDigit<20)
			{
				ntw.belowTwenty(reqiuredDigit);
				System.out.print(" Thousand ");
			}
			else {
				tensDigit=reqiuredDigit/10;
				unitDigit=reqiuredDigit%10;
				tensDigit=tensDigit*10;
				ntw.belowTwenty(tensDigit);
				ntw.belowTwenty(unitDigit);
				System.out.print(" Thousand ");
			}

			number=number%1000;
		}
		if((dt.digitCount(number))==3)
		{
			reqiuredDigit=number/100;
			if((reqiuredDigit<10)&&(reqiuredDigit!=0))
			{
				ntw.belowTwenty(reqiuredDigit);
				System.out.print(" Hundread And ");
			}

			number=number%100;
	
		}
		if(((dt.digitCount(number))==2)||((dt.digitCount(number))==1))
		{
			if(number<20)
			{
				ntw.belowTwenty(number);
			}
			else {
				tensDigit=number/10;
				unitDigit=number%10;
				tensDigit=tensDigit*10;
				ntw.belowTwenty(tensDigit);
				ntw.belowTwenty(unitDigit);
				
			}

		}
	}

}
