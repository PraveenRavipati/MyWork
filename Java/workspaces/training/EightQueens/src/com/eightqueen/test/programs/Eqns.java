package com.eightqueen.test.programs;

public class Eqns {
	static int m[]=new int[8];
	int count=0;

	public static void main(String[] args) {
		Eqns eqns=new Eqns();
//		eqns.display();
		int x=0;
		while(x>=0)
		{
//			System.out.println("in while");
			while((m[x]<8)&&(!eqns.isSafe(x)))
			{
				m[x]++;
//				System.out.println("m:"+m[x]);
			}
			if (m[x]>7) {
				m[x]=0;
				x--;
				if(x<0){
					System.out.println("Thank Q");
				}else {
					m[x]=m[x]+1;
				}
				
			}
			else {
				if(x==7)
				{
					eqns.display();
					m[x]++;
				}
				else {
					x++;
					m[x]=0;
				}
			}
			
		}
		
	}
	boolean isSafe(int x)
	{
		for(int i=0;i<x;i++)
		{
			if(m[i]==m[x]||((Math.abs(m[i]-m[x]))==(Math.abs(i-x))))
			{
				return false;
			}
		}
		return true;
	}
	void display()
	{
		count++;
		System.out.println("Solution "+count);
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(m[i]==j)
				{
					System.out.print(" ("+i+","+j+")");
				}
			}
			
		}
		System.out.println();
	}
	/*void display()
	{
		for(int i=0;i<8;i++)
		{
			System.out.println("m: at index"+(i+1)+" is "+m[i]);
		}
	}
*/
}
