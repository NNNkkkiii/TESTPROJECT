package com.crm.comcast.SDET32BasicTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.crm.comcast.SDET32.genericUtility.ExcelUtility;
import com.crm.comcast.SDET32.genericUtility.FileUtility;
import com.crm.comcast.SDET32.genericUtility.IPathConstant;
import com.crm.comcast.SDET32.genericUtility.JavaUtility;
import com.crm.comcast32.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast32.pomRepository.HomePage;
import com.crm.comcast32.pomRepository.LoginPage;
import com.crm.comcast32.pomRepository.OrganizationInformationPage;
import com.crm.comcast32.pomRepository.OrganizationsPage;

public class CreateOrgnizationTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		WebDriver driver=null;
		
		JavaUtility jUtils = new JavaUtility();
		FileUtility fUtils = new FileUtility();
		ExcelUtility eUtils = new ExcelUtility();
		
		//Generating the random Number
		int randomValue = jUtils.getRandomValue();
		
		
		//read the data from excel sheet and initializing organization name
		
		String organizationName = eUtils.getStringDataFromExcelSheet(IPathConstant.SHEET_NAME2,1,2)+randomValue;
		
		 //read the data from property file
		String browser = fUtils.getDataFromPropertyFile(IPathConstant.BROWSER_KEY);
		String url = fUtils.getDataFromPropertyFile(IPathConstant.URL_KEY);
		String username = fUtils.getDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.getDataFromPropertyFile(IPathConstant.PASSWORD_KEY);
		
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
		       driver.manage().window().maximize();
		       driver.get(url);
		       
		     //Creating Object For Pom Classes
				LoginPage login = new LoginPage(driver);
				HomePage home = new HomePage(driver);
				OrganizationsPage orgPage = new OrganizationsPage(driver);
				OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
				CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);

		       
		       //login TO The Application
		       login.loginAction(username, password);
		       
		       //Clicking on Organization Link
		      home.clickOnOrganizationLink();
		       
		       //click on Organization Plus Image
		      orgPage.clickOnOrganizationPlusImage();
		       // create New Organization
		      createNewOrg.passValueToOrganizationTextField(organizationName);
			  createNewOrg.clickOnSaveButton();
			  
		       
			// Verification
				 String actualTitle =orgInfo.verifyOrganizationNameText();
				 Assert.assertTrue(actualTitle.contains(organizationName));
				 System.out.println("Pass: Organization has been created");
				
				//if (actualTitle.Contains(organizationName)) {
					//System.out.println("Pass: Organization has been created");
				//} else
					//System.out.println("Fail: Organization has not been created");
				
				// Logout Action
				home.logoutActions();
		       
		    			   
		   }
		       

	}

	
	


