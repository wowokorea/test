package owenTest;

import java.util.Enumeration;
import java.util.Properties;

public class OsTest {
	public static void main(String[] args) {
		Properties props = System.getProperties(); 
		Enumeration<?> e = props.propertyNames();
		
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = props.getProperty(key);
			System.out.println(key + " : " + value);
		}
	}
}
