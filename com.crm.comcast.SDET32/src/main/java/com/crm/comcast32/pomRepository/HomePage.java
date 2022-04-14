package com.crm.comcast32.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{      WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationsLinks;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLinks;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLinks;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLinks;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLinks;
	
	@FindBy(linkText="More")
	private WebElement MoreLinks;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLinks;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationsLinks() {
		return organizationsLinks;
	}

	public WebElement getContactsLinks() {
		return ContactsLinks;
	}

	public WebElement getOpportunitiesLinks() {
		return OpportunitiesLinks;
	}

	public WebElement getProductsLinks() {
		return ProductsLinks;
	}

	public WebElement getLeadsLinks() {
		return LeadsLinks;
	}

	public WebElement getMoreLinks() {
		return MoreLinks;
	}

	public WebElement getLogoutImage() {
		return logoutImage;
	}

	public WebElement getSignOutLinks() {
		return signOutLinks;
	}
	public void clickOnOrganizationLink()
	{
		organizationsLinks.click();
	}
	public void logoutActions()
	{
		Actions action = new Actions(driver);
		action.moveToElement(logoutImage).perform();
		signOutLinks.click();
	}

	public void clickOnContactsLink() {
		ContactsLinks.click();
		
	}

	public void clickOnOpportunitiesLink() {
		OpportunitiesLinks.click();
		
	}
	
	

}
