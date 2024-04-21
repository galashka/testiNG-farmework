package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	private static Properties myProps;

	public static void readProps(String filePath) {
		
		try {
			
			FileInputStream fis = new FileInputStream(filePath);
			myProps = new Properties();
			myProps.load(fis);
			fis.close();
			
		}catch(FileNotFoundException myException) {
			
			myException.printStackTrace();
			
		}catch(IOException myException){
			
			myException.printStackTrace();
		}
	}
	
	public static String getProps(String key){
		
		return myProps.getProperty(key);
	}
}
