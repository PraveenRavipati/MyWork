package inh.func.inhableclasses;

import inh.func.exceoptions.MyAgeException;

public class AgeMethods {
	public void AgeFinder(int age) throws MyAgeException
	{
		   if(age < 0)
		      throw new MyAgeException(age);
		   else
		      System.out.println("Your age is :"+age);
		   }
	}

