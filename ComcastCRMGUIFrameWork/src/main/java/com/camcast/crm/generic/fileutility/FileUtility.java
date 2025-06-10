package com.camcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromProperties(String key) throws IOException {
	FileInputStream fisP = new FileInputStream("./configAppData/CommonData.properties");
	Properties pObj=new Properties();
	pObj.load(fisP);
	String value=pObj.getProperty(key);
		return value;
		
	}
	

}
