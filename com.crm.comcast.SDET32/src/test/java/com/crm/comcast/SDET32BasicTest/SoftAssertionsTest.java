package com.crm.comcast.SDET32BasicTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class SoftAssertionsTest 
{
	@Test
	public void demoTest1()
	{
		System.out.println("Step1 from demo1");
		System.out.println("Step2 from demo1");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("Message for assertions","A", "B");
		System.out.println("Step3 from demo1");
		System.out.println("Step4 from demo1");
		soft.assertAll();
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
