package com.crm.comcast.SDET32BasicTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;
@Listeners(com.crm.comcast.SDET32.genericUtility.ListnerImplmentationClass.class)
public class DemoTest extends BaseClass
{
	@Test
	public void demoTest()
	{
		System.out.println("===============Step1===========");
		//Assert.fail();
		System.out.println("===============Step2===========");
	}

}
