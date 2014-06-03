package com.gong.jdklogging;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class MyStreamHandler extends StreamHandler{
	
	public MyStreamHandler()
	{
		super(getStream(), new SimpleFormatter());
	}
	
	private static OutputStream getStream()
	{
		OutputStream ostream = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String logName = format.format(Calendar.getInstance().getTime());
		File file = new File("./log/"+logName+".log");
		try {
			while(!file.exists()) file.createNewFile();
			ostream = new FileOutputStream(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ostream;
	}
}
