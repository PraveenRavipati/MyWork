package com.vl.mainthings.wishes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.TimeZone;
public class BirthDayWishes {
	public static void main(String[] args) {
		System.out.println("Main Started");
		List<ProBean> list;
		WishTimer wt=new  WishTimer();
		Scanner s=new Scanner(System.in);
		PropertiesReader pr=new PropertiesReader();
		list=pr.propReader();
		MyThreadLocal.set(list);
		boolean condition=true;
		while (condition) {
			int option=0;
			System.out.println("\t\tMenu");
			System.out.println("\t1)add to properties file");
			System.out.println("\t2)wait for wishes");
			System.out.println("\t3)Display list");
			System.out.println("\t4)Exit");
			System.out.print("\n\toption:");
			option=s.nextInt();
			if(option==1){
				try {
					pr.prpertiesFileCreator();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (option==2) {
				wt.wishes();
			}
			else if (option==3) {
				pr.displayAll();
			}
			else if (option==4) {
				condition=false;
				System.exit(0);
			}
			else {
				System.out.println("wrong option....try again!");
			}
		}
		try {
			pr.prpertiesFileCreator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Ended");
	}
}
class ProBean{
	private String Name;
	private String Wish;
	private Date d;
	public ProBean( String Name,String Wish,Date d) {
		this.Name=Name;
		this.Wish=Wish;
		this.d=d;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getWish() {
		return Wish;
	}
	public void setWish(String wish) {
		Wish = wish;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}

}
class MyThreadLocal
{
	public static final ThreadLocal<List<ProBean>> MY_THREAD_LOCAL=new ThreadLocal<List<ProBean>>();
	public static void set(List<ProBean> list)
	{
		MY_THREAD_LOCAL.set(list);
	}
	public static List<ProBean> get()
	{
		return MY_THREAD_LOCAL.get();
	}
	public static void unset()
	{
		MY_THREAD_LOCAL.remove();
	}
}
class PropertiesReader{
	Properties prop = new Properties();
	ProBean b=null;
	InputStream input = null;
	OutputStream output=null;
	public List<ProBean> propReader()
	{
		List<ProBean> list=new ArrayList<ProBean>();
		try {
			input = new FileInputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes2/src/com/vl/mainthings/wishes/Wish2.properties");
			prop.load(input);

			Enumeration enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value[] = prop.getProperty(key).split(",");
				String sDate=value[0];
				System.out.println(sDate);
				long date=Date.parse(sDate);
				Date d=new Date(date);
				String wish=value[1];
				//				System.out.println("Key:"+key + " values  date:" + d+" wish:"+wish);
				b=new ProBean(key, wish, d);
				list.add(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void prpertiesFileCreator() throws IOException,FileNotFoundException
	{
		List<ProBean> list=MyThreadLocal.get();

		output = new FileOutputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes2/src/com/vl/mainthings/wishes/Wish2.properties");
		StringBuilder br=null;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Wish details:");
		System.out.println("Enter the Wish:");
		String wish=s.nextLine();
		System.out.print("Enter the Name:");
		String name=s.next();
		System.out.println("\nEnter the date:");
		System.out.println("Enter seconds:");
		int second=s.nextInt();
		System.out.println("Enter Minutes:");
		int minutes=s.nextInt();
		System.out.println("Enter the Hours");
		int hours=s.nextInt();
		System.out.println("Enter day:");
		int date=s.nextInt();
		System.out.println("Enter Month:");
		int month=s.nextInt();
		System.out.println("Enter Year:");
		int year=s.nextInt();
		Date d=new Date();
		d.setDate(date);
		d.setHours(hours);
		d.setMinutes(minutes);
		d.setMonth(month);
		d.setSeconds(second);
		d.setYear(year);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+05:30"));
		b=new ProBean(name, wish, d);
		list.add(b);
		Iterator<ProBean> lIterator=list.iterator();
		while (lIterator.hasNext()) {
			ProBean proBean = (ProBean) lIterator.next();
			br=new StringBuilder();
			br.append(proBean.getD());
			br.append(",");
			br.append(proBean.getWish());
			String b=br.toString();
			System.out.println(b);
			prop.setProperty(proBean.getName(), proBean.getD()+","+proBean.getWish());
		}
		prop.store(output, "null");
	}
	public void displayAll()
	{
		List<ProBean> list=MyThreadLocal.get();
		Iterator<ProBean> it=list.iterator();
		if(list.size()==0){
			System.out.println("on wishes are theres");
		}
		else {
			System.out.println("The Wishes are");
			System.out.println("Name        wish         date");
			while (it.hasNext()) {
				ProBean p=it.next();
				System.out.println(p.getName()+" "+p.getWish()+" "+p.getD());
			}
		}
	}
}
class WishTimer{
	public void timeSort(){
		List<ProBean> list=MyThreadLocal.get();
		Collections.sort(list, new Compare());


	}
	public void wishes(){
		timeSort();
		displayWish();
	}
	public void displayWish()
	{
		List<ProBean> list=MyThreadLocal.get();
		Iterator<ProBean> itr2=list.iterator();
		int count=0;
		while (itr2.hasNext()) {
			ProBean pq = (ProBean) itr2.next();
			Date d=new Date(System.currentTimeMillis());
			Date d2=pq.getD();
			int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);

			d2.setYear(year);
			long time=(pq.getD().getTime()-d.getTime());
			if(time>0)
			{
				count++;
				synchronized (this) {
					try {
						System.out.println("\n\n\n\t\twaiting......!");
						this.wait(time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(pq.getName()+" "+pq.getWish());
				}
			}
			else {
				continue;
			}
		}
		if (count>0) {
			System.out.println("completed....!");
		} else {
			System.out.println("\n\non wishes are there...!\n\n");
		}
	}
}
class Compare implements Comparator<ProBean>{

	@SuppressWarnings("deprecation")
	@Override
	public int compare(ProBean p1, ProBean p2) {
		int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);
		Date d1=(Date) p1.getD().clone();
		d1.setYear(year);
		Date d2=(Date) p2.getD().clone();
		d2.setYear(year);
		return d1.compareTo(d2);
	}
}
