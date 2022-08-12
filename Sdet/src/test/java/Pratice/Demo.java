package Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo 
{
	@Test(retryAnalyzer = comcast.vtiger.genericUtility.ReTryImpClass.class)
	public void modifyContact()
	{
		Assert.assertEquals(false, true);
		System.out.println("modified contact");
	}

	@Test(retryAnalyzer = comcast.vtiger.genericUtility.ReTryImpClass.class)
	public void createContact()
	{
		System.out.println("contact created");
	}
}
