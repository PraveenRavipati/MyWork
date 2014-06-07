package com.sample;

public class Sample {
	private String Number[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eightteen","NineTeen","","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};
	public String getNumber(int index)
	{
		String word="";
		word=Number[index];
		return word;
	}
	public static void main(String args[]) {
		Sample s=new Sample();
		for(int i=0;i<30;i++)
		{
			System.out.println("the number"+i+"is"+s.getNumber(i));
		}
	}
	
}
