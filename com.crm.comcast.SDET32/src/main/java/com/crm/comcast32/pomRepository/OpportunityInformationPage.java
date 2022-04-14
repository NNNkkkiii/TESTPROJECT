package com.crm.comcast32.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage 
{

	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement actualOpportunityName;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getActualOpportunityName() {
		return actualOpportunityName;
	}
	
	public String getOppText() {
		return actualOpportunityName.getText();
	}

}
