package inh.func.inhableclasses;

import inh.func.exceoptions.MyAgeAndNameException;
import inh.func.exceoptions.MyAgeException;

public class NameMethods extends AgeMethods {
	@Override
	public void AgeFinder(int age){
		
		if (age < 0 || age > 110) {
			//throw new MyAgeException(age);
			System.out.println("the age is not satisfied");
		} else {
			System.out.println("the age is Satisfied");
		}
	}

	public void NameFinder(String Name) throws MyAgeAndNameException {
		if(Name.length()>12)
		{
			throw new MyAgeAndNameException(Name);
		}
		else {
			System.out.println(Name.length());
			System.out.println("The Name is satisfied");
		}
	}
}
