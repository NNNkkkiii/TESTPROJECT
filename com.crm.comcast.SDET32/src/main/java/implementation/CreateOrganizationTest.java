package implementation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;
import com.crm.comcast32.pomRepository.CreateNewOrganizationPage;
import com.crm.comcast32.pomRepository.HomePage;
import com.crm.comcast32.pomRepository.OrganizationInformationPage;
import com.crm.comcast32.pomRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	/**
	 * this class contains create Organization-no data dependency
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test(groups= {"smokeTest"})
	public void createOrganizationTest() throws EncryptedDocumentException, IOException
	{
		
				// Generating Random number
				int randomvalue = jUtils.getRandomValue();

				// Getting data from excelSheet and Initializing the organization name
				String organisationName = eUtils.getStringDataFromExcelSheet("Sheet2", 1, 2) + randomvalue;
				
				// Creating the object of Pom classes
				OrganizationsPage orgPage = new OrganizationsPage(driver);
				CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
				OrganizationInformationPage orgInfPage = new OrganizationInformationPage(driver);

				// Clicking on Organization Link
				HomePage home = new HomePage(driver);
				home.clickOnOrganizationLink();
				
				// Clicking on Organization Plus Image
				orgPage.clickOnOrganizationPlusImage();

				// Creating new organization
				createNewOrg.passValueToOrganizationTextField(organisationName);
				createNewOrg.clickOnSaveButton();

				// verification
				String actualTitle = orgInfPage.verifyOrganizationNameText();
				Assert.assertTrue(actualTitle.contains(organisationName));
				System.out.println("Pass, Organisation has been created");

				//if (actualTitle.contains(organisationName)) {
					//System.out.println("Pass, Organisation has been created");
				//} else
					//System.out.println("Fail, Organisation has not been created");

	}
	@Test(groups="RegionalRegression")
	public void demoTest()
	{
		System.out.println("This is demo test");
	}

}

