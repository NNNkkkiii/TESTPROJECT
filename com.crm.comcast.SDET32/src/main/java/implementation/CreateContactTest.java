package implementation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;
import com.crm.comcast32.pomRepository.ContactInformationPage;
import com.crm.comcast32.pomRepository.ContactsPage;
import com.crm.comcast32.pomRepository.CreateNewContactsPage;
import com.crm.comcast32.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast32.pomRepository.HomePage;
import com.crm.comcast32.pomRepository.OrganizationInformationPage;
import com.crm.comcast32.pomRepository.OrganizationsPage;

public class CreateContactTest extends BaseClass 

{
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups= {"regressionTest"})
	public void createContactWithOrganisationNameTest() throws IOException, InterruptedException {

		// Generating Random number
		int randomvalue = jUtils.getRandomValue();

		// Getting data from excelSheet
		String organisationName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 2) + randomvalue;
		String firstName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 4) + randomvalue;
		String lastName = eUtils.getStringDataFromExcelSheet("Sheet2", 2, 5) + randomvalue;

		// Creating the object of Pom classes
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreateNewContactsPage newContact = new CreateNewContactsPage(driver);
		ContactInformationPage contactsInfo = new ContactInformationPage(driver);

		// Clicking on Organization Link
		HomePage home = new HomePage(driver);
		home.clickOnOrganizationLink();

		// Clicking on Organization Plus Image
		orgpage.clickOnOrganizationPlusImage();

		// Creating new organization
		createNewOrg.passValueToOrganizationTextField(organisationName);
		createNewOrg.clickOnSaveButton();

		// verification
		String actualTitle = orgInfo.verifyOrganizationNameText();
		Assert.assertTrue(actualTitle.contains(organisationName));
		System.out.println("Pass, Organization has been created");

		//if (actualTitle.contains(organisationName)) {
			//System.out.println("Pass, Organisation has been created");
		//} else
			//System.out.println("Fail, Organisation has not been created");

		home.clickOnContactsLink();
		contact.clickOnContactsPlusImage();
		newContact.passValueToFirstName(firstName);
		newContact.passValueToLastName(lastName);
		newContact.clickOnOrgLookUpImage();
		String parentWindowTitle = driver.getTitle();
		wUtils.switchToWindow(driver, parentWindowTitle);
		newContact.selectOrgFromChildWindow(organisationName);
		wUtils.switchToWindow(driver, parentWindowTitle);
		newContact.clickOnSaveButton();

		// Verification
		String actualContactName = contactsInfo.getActualContactNameText();
		Assert.assertTrue(actualContactName.contains(lastName));
		System.out.println("pass, contact has been created");

		//if (actualContactName.contains(lastName)) {
			//System.out.println("pass, contact has been created");
		//} else
			//System.out.println("fail, contact has not been created");


}
}
