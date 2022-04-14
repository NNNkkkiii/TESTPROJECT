package implementation;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;
import com.crm.comcast.SDET32.genericUtility.ExcelUtility;
import com.crm.comcast.SDET32.genericUtility.FileUtility;
import com.crm.comcast.SDET32.genericUtility.JavaUtility;
import com.crm.comcast.SDET32.genericUtility.WebDriverUtility;
import com.crm.comcast32.pomRepository.ContactInformationPage;
import com.crm.comcast32.pomRepository.ContactsPage;
import com.crm.comcast32.pomRepository.CreateNewContactsPage;
import com.crm.comcast32.pomRepository.CreateNewOpportunityPage;
import com.crm.comcast32.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast32.pomRepository.HomePage;
import com.crm.comcast32.pomRepository.OpportunitiesPage;
import com.crm.comcast32.pomRepository.OpportunityInformationPage;
import com.crm.comcast32.pomRepository.OrganizationInformationPage;
import com.crm.comcast32.pomRepository.OrganizationsPage;

public class CreateOpportunityTest extends BaseClass {
	

	/**
	 * this class contains create opportunity with contact name and organization name
	 * @throws IOException
	 * @throws InterruptedException 
	 */

	@Test(groups= {"regressionTest"})
	public void createOpportunityTest() throws IOException, InterruptedException
	{
		

		// generating random number
		int randomvalue = jUtils.getRandomValue();

		// getting date
		String calDate = jUtils.getSystemDateInYYYY_MM_DDFormate();
		
         // getting the data from excel sheet
		String organisationName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 2) + randomvalue;
		String firstName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 4) + randomvalue;
		String lastName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 5) + randomvalue;
		String opportunityName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 3) + randomvalue;
		String salesStage = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 8);
		String salutationType = eUtils.getStringDataFromExcelSheet("Sheet2", 2,9);
		
		
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreateNewContactsPage newContact = new CreateNewContactsPage(driver);
		ContactInformationPage contactsInfo = new ContactInformationPage(driver);
		OpportunitiesPage oppPage = new OpportunitiesPage(driver);
		CreateNewOpportunityPage createOpp = new CreateNewOpportunityPage(driver);
		OpportunityInformationPage oppInfo = new OpportunityInformationPage(driver);
		
		//Clicking on Organization Link
		HomePage home = new HomePage(driver);
		home.clickOnOrganizationLink();
		
		//Clicking on Organization plusImage
		orgPage.clickOnOrganizationPlusImage();
		
		
		//Creating New Organization
		createNewOrg.passValueToOrganizationTextField(organisationName);
		createNewOrg.clickOnSaveButton();

		
		// verification

		String actualTitle= orgInfo.verifyOrganizationNameText();
		Assert.assertTrue(actualTitle.contains(organisationName));
		System.out.println("Pass, Organisation has been created");
		//System.out.println(actualTitle);

		//if (actualTitle.contains(organisationName)) {
			//System.out.println("Pass, Organisation has been created");
		//} else
			//System.out.println("Fail, Organisation has not been created");

		// creating contacts
		home.clickOnContactsLink();
		contact.clickOnContactsPlusImage();
		newContact.handleSalutationDropDown(salutationType);
		newContact.passValueToFirstName(firstName);
		newContact.passValueToLastName(lastName);
		newContact.clickOnOrgLookUpImage();
		String parenWindowTitle = driver.getTitle();
		wUtils.switchToWindow(driver, parenWindowTitle);
		newContact.selectOrgFromChildWindow(organisationName);
		wUtils.switchToWindow(driver, parenWindowTitle);
		newContact.clickOnSaveButton();
		
		

		// verification
		String actualContactName = contactsInfo.getActualContactNameText();
		Assert.assertTrue(actualContactName.contains(lastName));
		System.out.println("pass, contact has been created");
		//if (actualContactName.contains(lastName)) {
			//System.out.println("pass, contact has been created");
		//} else
			//System.out.println("fail, contact has not been created");
		//Creating New Opportunity
		home.clickOnOpportunitiesLink();
		
		oppPage.clickOnOpportunitiesPlusImage();
		
		createOpp.sendValuesToOpportunityName(opportunityName);
		createOpp.clickOnThePlusButton();
		
		String parenWindowOpportunity = driver.getTitle();
		wUtils.switchToWindow(driver, parenWindowOpportunity);
		createOpp.handleOppChildBrowser(organisationName);
		wUtils.switchToWindow(driver, parenWindowOpportunity);
		
		//Passing the date
		createOpp.passValueToTheClosingDate(calDate);
		
		//Passing the sales stage
		
		createOpp.handleSalesStageDropdown(salesStage);
		
		//Click on the Save Button
		createOpp.clickOnSaveButton();
		
		//Verifications
		 String actualOpportunityName=oppInfo.getOppText();
		 Assert.assertTrue(actualOpportunityName.contains(opportunityName));
		 System.out.println("Pass, Opportunity has been created");
		
		//if (actualOpportunityName.contains(opportunityName)) {
			//System.out.println("Pass, Opportunity has been created");
		//} else
			//System.out.println("Fail, Opportunity has not been created");

	
		

	}

}
