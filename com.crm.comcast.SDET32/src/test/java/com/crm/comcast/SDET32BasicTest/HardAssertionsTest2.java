package com.crm.comcast.SDET32BasicTest;

import java.util.ArrayList;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssertionsTest2 
{
	@Test
	public void demoTest1()
	{
		System.out.println("Step1 from demo1");
		System.out.println("Step2 from demo1");
		int[]a= {1,2,3};
		int[]b= {1,2,3};
		
		Assert.assertEquals(a[1],b[1]);
		System.out.println("Step3 from demo1");
		System.out.println("Step4 from demo1");
	}

}
