package com.gong.commons_logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;

public class Main {
	public static void main(String[] args) {
		
		log4jLoggerTest();
	}
	
	public static void log4jLoggerTest()
	{
		Log log = LogFactory.getLog(Main.class);
		log.info("log4j common-logging");
	}
	
	public static void jdk14loggerTest()
	{
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
		
		
		LogFactory factory = LogFactory.getFactory();
		String[] attNames = factory.getAttributeNames();
		System.out.println(attNames.length);
		Jdk14Logger log = (Jdk14Logger) factory.getInstance(Jdk14Logger.class);
		System.out.println(log.getClass().getName());
		
		for(int i = 0;i < 100;i++)
		{
			log.error(i+"this is a test");
		}
	}
}
