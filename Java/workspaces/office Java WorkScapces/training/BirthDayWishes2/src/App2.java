import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
 
public class App2 {
  public static void main(String[] args) {
 
	Properties prop = new Properties();
	InputStream input = null;
 
	try {
 
		input = new FileInputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes2/src/com/vl/mainthings/wishes/Wish2.properties");
 
		// load a properties file
		prop.load(input);
		System.out.println(prop.size());
		// get the property value and print it out
		System.out.println(prop.getProperty("Raghava"));
		String val[]=prop.getProperty("Raghava").split(",");
		String str=val[0];
		System.out.println(str);
		long time=Date.parse(str);
		System.out.println(time);
		
 
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
  }
}