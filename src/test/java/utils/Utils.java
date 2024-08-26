package utils;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

public class Utils {
	
public static String readValue(String key) {
		
		String value="";
		try (InputStream input = new FileInputStream("./src/test/resources/data/conf.properties")) {
			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value = prop.getProperty(key);

		} catch (Exception e) {
			
		}
		return value;
	}

}
