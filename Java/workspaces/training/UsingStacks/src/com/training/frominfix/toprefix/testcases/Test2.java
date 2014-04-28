package com.training.frominfix.toprefix.testcases;

public class Test2 {

	public static void main(String[] args) {
		String sample="/-+*";
		for(int i=0;i<sample.length();i++)
		{
			for(int j=0;j<sample.length();j++)
			{
				if(sample.charAt(i)==sample.charAt(j))
				{
					System.out.println(sample.charAt(i)+" is Equals to "+sample.charAt(j));
				}
				else if (sample.charAt(i)>sample.charAt(j)) {
					System.out.println(sample.charAt(i)+" is Grater than "+sample.charAt(j));
				}
				else {
					System.out.println(sample.charAt(i)+" is less than "+sample.charAt(j));
				}
			}
		}
	}

}
