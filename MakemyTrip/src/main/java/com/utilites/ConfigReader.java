package com.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	
	public  ConfigReader()  {
		try {
	prop= new Properties();
	File src = new File("./src/main/resources/config/config.properties");
	
	FileInputStream fis = new FileInputStream(src);
	prop.load(fis);}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		
		String browser = prop.getProperty("browser");
		return browser;
		
	}
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getPwsd() {
		String pwd=prop.getProperty("password");
		return pwd;
	}



	
}