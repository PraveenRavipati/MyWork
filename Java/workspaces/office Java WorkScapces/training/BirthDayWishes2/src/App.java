import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;
 
public class App {
  public static void main(String[] args) {
 
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input=null;
 
	try {
		input =new FileInputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes2/src/com/vl/mainthings/wishes/wishes.properties");
		output = new FileOutputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes2/src/com/vl/mainthings/wishes/wishes.properties");
		Date d=new Date(System.currentTimeMillis());
		// set the properties value
		prop.load(input);
		prop.setProperty("raghava", "localhost,"+d);
		prop.setProperty("roa", "mkyong");
		prop.setProperty("sriniavas", "password");
		
 
		// save properties to project root folder
		prop.store(output, null);
 
	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}
class sample
{
	String name;
	int ID;
}
