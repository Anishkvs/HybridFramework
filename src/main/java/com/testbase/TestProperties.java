package com.testbase;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Object_repository.properties");
		OR.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("userName_ID"));
	}
	
}
