package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgTest extends BaseClass{
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();

		@Test(dataProvider = "OrgWithIndustry")
		//@Test(groups = "RegressionSuite")
		public void createOrgTest(String ORG, String INDUSTRY) throws IOException {
			
			String ORGNAME = ORG+jUtil.getRandomNumber();
			
			// Step 5: Navigate to Organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();

			
			// Step 6: Click on Create Organization Look up Image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrganizationLookUpImg();
			
	 		// Step 7: Create organization with mandatory Fields
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrgnization(ORGNAME, INDUSTRY);
			
			// Step 8: Validate for Organization
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
		}

		@DataProvider(name = "OrgWithIndustry")
		public Object[][] getData() throws EncryptedDocumentException, IOException 
		{
			Object[][] data = eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
			return data;
		}


}
