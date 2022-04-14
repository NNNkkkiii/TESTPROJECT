package com.crm.comcast32.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
    WebDriver driver;
	

public ContactInformationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}	
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactVerificationText;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactVerificationText() {
		return contactVerificationText;
	}
	
	public String getActualContactNameText() {
		return contactVerificationText.getText();
	}


}
