package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	Properties pro=null;
	Utils(){
	pro=new Properties();
	try {
		pro.load(new FileInputStream(new File("ApiProperties.properties")));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
protected String propertyValue(String property){
	
	return pro.getProperty(property);
}
	
	
}
