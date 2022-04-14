package com.crm.comcast.SDET32.genericUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast32.pomRepository.HomePage;
import com.crm.comcast32.pomRepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver=null;
	static WebDriver sDriver;
	
	// Creating the object of all the libraries
			public JavaUtility jUtils = new JavaUtility();
			public FileUtility fUtils = new FileUtility();
			public ExcelUtility eUtils = new ExcelUtility();
			public WebDriverUtility wUtils = new WebDriverUtility();
			
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void bsConfig()
	{
		System.out.println("===========Database Connection is Established=============");
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void bcConfig() throws IOException
	{
		//Getting data from property file
		String browser = fUtils.getDataFromPropertyFile(IPathConstant.BROWSER_KEY);
		String url = fUtils.getDataFromPropertyFile(IPathConstant.URL_KEY);
		
		//RunTime Polymorphism -Using Data from PropertyFile
	       if(browser.equals("chrome"))
	       {
	    	   driver=new ChromeDriver();
	       }else if(browser.equals("firefox"))
	       {
	    	   driver=new FirefoxDriver();
	       }else
	       {
	    	   System.out.println("driver is not present");
	       }
	       sDriver=driver;
	       driver.manage().window().maximize();
	       wUtils.waitForElement(driver);
	       
	       //Navigating to the Vtiger
	       driver.get(url);
	       
	       System.out.println("==========Browser has been Lunched=============");
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void bmConfig() throws IOException
	{
		String username = fUtils.getDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.getDataFromPropertyFile(IPathConstant.PASSWORD_KEY);
		
		LoginPage login = new LoginPage(driver);
		
		//Login to the Application
		login.loginAction(username, password);
		System.out.println("============Successfully Logged into the Applications=============");
		
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void amConfig() 
	{
		HomePage home = new HomePage(driver);
		home.logoutActions();
		
		System.out.println("============Successfully Logged out of the Applications=============");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("============Browser has been closed=============");
		
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void asConfig()
	{
		System.out.println("============Data Base Connectivity has been Closed=============");
	}
	
	
	}
