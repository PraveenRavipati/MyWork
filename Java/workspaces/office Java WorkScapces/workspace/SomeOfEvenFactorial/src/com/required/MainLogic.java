package com.required;

import com.util.Factorial;

public class MainLogic {
	/*method for even  series and adding them*/
	public int sericeLogic(int upto)
	{
		Factorial f=new Factorial();
		int sum=0;
		for(int i=0;i<=upto;i=i+2)
		{
			System.out.println(i+":"+f.factorialValue(i));
			sum=sum+f.factorialValue(i);
		}
		return sum;
	}

}
