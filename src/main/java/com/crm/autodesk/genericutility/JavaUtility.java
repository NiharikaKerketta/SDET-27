package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Niharika
 *
 */

public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return int data
	 * 	
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}
	
	/**
	 * it is used to generate system date and time in IST
	 * @return String
	 */
	public String getSystemDateAndTime() {
	Date date = new Date();
	return date.toString();
	}
	
	/**
	 * used to generate date in YYYY-MM-DD format
	 * @return String
	 */
	public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY= dateAndTime.split(" ")[5];
		String DD= dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		
		return finalFormat;
		
	}
}
