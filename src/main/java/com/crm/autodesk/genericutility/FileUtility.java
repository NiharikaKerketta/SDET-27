package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Niharika
 *
 */
public class FileUtility {
	/**
	 * it is used to read data from commonData.properties file base on the key which is passed as an argument
	 * @throws Throwable 
	 * 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fp = new FileInputStream("./data/commonData.properties");
		Properties p = new Properties();
		p.load(fp);
		String value = p.getProperty(key);
		return value;
		
	}
}
