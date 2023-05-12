package vtiger.Contact.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws IOException
	{	
		        Reporter.log("CreateContactWithOrganizationTest",true);
				String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
				String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();


				// Step 5: Navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();
				
				// Step 6: Click on Create Organization Look up Image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrganizationLookUpImg();
				
				// Step 7: Create organization with mandatory Fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				//Assert.fail();
				
				// Step 8: Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrganizationHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));

				// Step 9: Navigate Contacts Link
				hp.clickOnContactsLink();
				
				// Step 10: Click on create Contact Look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				// Step 11: Create contact
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
				//wUtil.takeScreenShot(driver, "Screenshot1");

				// Step 12: Validate for Contacts
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String ContactHeader = cip.getContactHeader();
				Assert.assertTrue(ContactHeader.contains(LASTNAME));		

	}
	
	@Test
	public void Demo()
	{
		System.out.println("This is Demo");
	}


}
