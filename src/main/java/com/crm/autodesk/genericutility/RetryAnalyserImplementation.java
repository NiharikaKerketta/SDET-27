package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iRetryAnalyser
 * @author Niharika
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count =0;
	int retrycount = 2;
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

}
