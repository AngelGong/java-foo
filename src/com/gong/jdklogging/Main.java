package com.gong.jdklogging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		LogManager logManager = LogManager.getLogManager();
		try {
			InputStream stream = new FileInputStream(new File("./log/mylogging.properties"));
			logManager.readConfiguration(stream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(logManager.getProperty("handlers"));
		
		Logger logger = Logger.getLogger("");
		for(int i = 0;i<100;i++)
		{
			logger.info(i+"this is a test");
		}
	}
	
	
}
