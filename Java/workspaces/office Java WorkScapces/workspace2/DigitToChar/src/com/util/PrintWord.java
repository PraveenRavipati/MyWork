package com.util;

public class PrintWord {
	public void printWord(int reqiuredDigit,String string)
	{
		int tensDigit;
		int unitDigit;
		NoToWords ntw=new NoToWords();
		if(reqiuredDigit<20)
		{
			ntw.belowTwenty(reqiuredDigit);
			System.out.print(" "+string+" ");
		}
		else {
			tensDigit=reqiuredDigit/10;
			unitDigit=reqiuredDigit%10;
			tensDigit=tensDigit*10;
			ntw.belowTwenty(tensDigit);
			ntw.belowTwenty(unitDigit);
			System.out.print(" "+string+" ");
		}
	}

}
