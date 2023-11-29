package com.hms.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	public String readdatafrompropertyfile(String key) throws Throwable 
	{
		
		FileInputStream fis = new  FileInputStream(IPathConstant.FilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String res = pobj.getProperty(key);
		return res;
		
	}

}
