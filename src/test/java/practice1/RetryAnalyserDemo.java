package practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {

	@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyserImplementation.class )
	public void retryAnalyserDemoTest()
	{
		System.out.println("Retry Analyser");
		Assert.fail();
	}
}
