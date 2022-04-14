package com.crm.comcast.SDET32BasicTest;

import java.util.ArrayList;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssertionsTest1 

{
	@Test
	public void demoTest1()
	{
		System.out.println("Step1 from demo1");
		System.out.println("Step2 from demo1");
		ArrayList a=new ArrayList();
		a.add(1);
		a.add(2);
		a.add(3);
		
		ArrayList b=new ArrayList();
		b.add(1);
		b.add(2);
		b.add(3);
		Assert.assertEquals(a, b);
		System.out.println("Step3 from demo1");
		System.out.println("Step4 from demo1");
		
	}	
		

}
