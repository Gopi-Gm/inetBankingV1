package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()  // constructor
	{
		File src = new File("./Configuration\\config.properties"); // object for properities and config location
		try {
			FileInputStream fis = new FileInputStream(src); // FileInputStream is using reading the data, it is using for file reading
			pro = new Properties(); //intilization
			pro.load(fis); // load is a method 
		}
		catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
		
	}
	
	// these methos will read read config file data
	public String getApplicationURL()
	{
		String url= pro.getProperty("BaseURL");
		return url;
	}
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String Password= pro.getProperty("password");
		return Password;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getEdgepath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}
	public String getBrowserName()
	{
		String browserName = pro.getProperty("browsername");
		return browserName;
	}

}
