package com.crm.comcast32.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{    WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButtonEdit;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButtonEdit() {
		return loginButtonEdit;
	}
	
	public void loginAction(String username,String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButtonEdit.click();
		
	}

	
}
