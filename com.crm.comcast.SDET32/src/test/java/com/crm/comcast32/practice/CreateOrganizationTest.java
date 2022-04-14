package com.crm.comcast32.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrganizationTest 
{
	@Test(priority = -1)
	public void createOrganizationTest()
	{
		Assert.fail();
		System.out.println("Organization has been Created");
		System.out.println("==============================");
	}
	@Test(priority = 0,dependsOnMethods= "createOrganizationTest")
	public void CreateContactWithOrgnizationNameTest()
	{
		System.out.println("Organization has been Created");
		System.out.println("Contact has been Created");
		System.out.println("CreateContactWithOrganization has been Created");
		System.out.println("================================================");
	}
	@Test(priority = 3,dependsOnMethods= "CreateContactWithOrgnizationNameTest")
	public void CreateOpportunityWithOrgAndContactInfo()
	{
		System.out.println("Organization has been Created");
		System.out.println("Contact has been Created");
		System.out.println("Opportunity has been Created");
		
	}

}
