package com.crm.comcast32.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{      
	   WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organizationsPlusImage;
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	public WebElement getOrganizationsPlusImage() 
	{
		return organizationsPlusImage;
	}
	
	public void clickOnOrganizationPlusImage()
	{
		organizationsPlusImage.click();
	}

	
	
	

}
