package com.crm.comcast32.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class failedDemoTest 
{
	@Test(retryAnalyzer=com.crm.comcast.SDET32.genericUtility.RetryAnalyserImplementationClass.class)
	public void faileddemoTest()
	{
		System.out.println("================Step1=============");
		Assert.fail();
		System.out.println("================Step1=============");
	}

}
