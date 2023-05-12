package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//Declaration
		@FindBy(linkText = "Organizations")
		private WebElement OrganizationsLnk;
	 
		@FindBy(linkText = "Contacts")
		private WebElement ContactsLnk;

		@FindBy(linkText = "Opportunities")
		private WebElement opportunitiesLnk;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdministratorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement SignOutLnk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//Utilization
		public WebElement getOrganizationsLnk()
		{
			return OrganizationsLnk;
		}
		public WebElement getContactsLnk()
		{
			return ContactsLnk;
		}
		public WebElement getOpportunitiesLnk()
		{
			return opportunitiesLnk;
		}
		public WebElement getAdministratorImg()
		{
			return AdministratorImg;
		}
		public WebElement getSignoutLnk()
		{
			return SignOutLnk;
		}
		
		//Business Libraries
		/**
		 * This method will click onOrganizations link
		 */
		public void clickOnOrganizationLink()
		{
			OrganizationsLnk.click();
		}
		/**
		 * This method will click on contacts link
		 * 
		 */
		public void clickOnContactsLink()
		{
			ContactsLnk.click();
		}
		/**
		 * This method will perform sign out operation on web app
		 * @param driver
		 */
		public void logoutOfApp(WebDriver driver)
		{
			mouseHoverAction(driver,AdministratorImg);
			SignOutLnk.click();
		}

}
