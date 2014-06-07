package com.sekhar.programs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class FileRead1 
{
	public static void main(String args[])
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		try
		{
			System.out.println("please enter the file name");
			String fname=br.readLine().trim();
			FileInputStream fis=new FileInputStream(fname);
			int size=fis.available();
			byte ba[]=new byte[size];
			fis.read(ba);
			String data=new String(ba);
			char[] chars = data.toCharArray();
			/*for(int i=0;i<size;i++)
				System.out.print(chars[i]);
			fis.close();*/
			int cd=0;
			int i=0;
			int k=3;
			while(i<size)
			{
				if((i>0)&&(i<(size-1)))
				{
					if((chars[i]==';')&&(chars[i+1]!='\n')){
						System.out.print(chars[i]);
						System.out.println();
						i++;
					}
					else if (chars[i]=='\'') {
						while(i<size)
						{
							i++;
							if(chars[i]=='\'')
								i=i+1;				
								break;
						}
					}
					else if (chars[i]=='\"') {
						
						while(i<size)
						{
							i++;
							if(chars[i]=='\"'){
								i=i+1;						
								break;
							}
						}
					}
					else if ((chars[i]=='\\')&&(chars[i+1]=='*')) {
						
						while(i<size)
						{
							i++;
							if(chars[i]=='\'')
								i=i+1;				
								break;
						}
					}
					else if((chars[i]=='\n'))
					{
						if((chars[i+1]=='{'))
						{
							System.out.print(" {\n");
							i=i+2;
						}else if (chars[i-1]=='{') {
							System.out.println();
							i++;
						}
						else if (chars[i+1]==' ') {
							while(i<size)
							{
								i++;
								if(chars[i]!=' ')
									i=i+1;				
									break;
							}
						}
					}
					else if ((chars[i]=='{')&&(chars[i+1]!='\n')) {
						System.out.println(chars[i]);
						i++;
					}
					else if ((chars[i]=='}')) {
						
						if (chars[i+1]==' ') {
							System.out.print(chars[i]);
							while(i<size)
							{
								i++;
								//System.out.println("in");
								if(chars[i]!=' ')
									i=i+1;				
									break;
							}
							System.out.println();
						}
					else if(chars[i+1]!='\n'){
							System.out.println(chars[i]);
							i++;
						}else if (chars[i-1]!='\n') {
							//System.out.println();
							System.out.print(chars[i]);
							i++;
						}
						else if (chars[i+1]==' ') {
							while(i<size)
							{
								i++;
								if(chars[i]!=' ')
									i=i+1;				
									break;
							}
						}
					}
					else{
						System.out.print(chars[i]);
						i++;
					}
				}else{
					System.out.print(chars[i]);
					i++;
				}
				
				
				
				
				
				/*if(chars[i]=='{')
				{
					if(cd!=0)
					{
						for(int t=1;t<=cd*k;t++)
							System.out.print(" ");
					}						
					System.out.print(chars[i]);
					cd++;
					for(int t=1;t<=cd*k;t++)
						System.out.print(" ");
					i++;}
				else if(chars[i]=='}')
				{
					if(cd!=0)
					{
						cd--;
						for(int t=1;t<=cd*k;t++)
							System.out.print(" ");
					}
					System.out.print(chars[i]);
					for(int t=1;t<=cd*k;t++)
						System.out.print(" ");
					i++;
				}
				else if(chars[i]==' '|| chars[i]==')'||chars[i]=='(')
				{
					System.out.print(chars[i]);
					i++;
				}
				else if(chars[i]==';'|| chars[i]=='\n')
				{
					System.out.print(chars[i]);
					if(cd!=0){
						for(int t=1;t<=cd*k;t++)
							System.out.print(" ");
					}
					i++;
				}
				else if(chars[i]=='\n')
				 * {
					System.out.println();
					if(cd!=0){
						for(int t=1;t<=cd*k;t++)
							System.out.print(" ");
					}
					i++;
				}
				else
				{
					System.out.print(chars[i]);
					i++;
				}*/
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}