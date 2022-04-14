package com.crm.comcast.SDET32BasicTest;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssertionsTest 
{
	@Test
	public void demoTest1()
	{
		System.out.println("Step1 from demo1");
		System.out.println("Step2 from demo1");
		Assert.assertEquals(true, false);
		System.out.println("Step3 from demo1");
		System.out.println("Step4 from demo1");
	}
	@Test
	public void demoTest2()
	{
		System.out.println("Step1 from demo2");
		System.out.println("Step2 from demo2");
		
		System.out.println("Step3 from demo2");
		System.out.println("Step4 from demo2");
	}

}
