package com.crm.comcast32.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;

public class DemoRetryTest extends BaseClass
{
	@Test(retryAnalyzer=com.crm.comcast.SDET32.genericUtility.RetryAnalyserImplementationClass.class)
	public void demoTest()
	{
		System.out.println("================Step1=============");
		Assert.fail();
		System.out.println("================Step1=============");
	}

}
