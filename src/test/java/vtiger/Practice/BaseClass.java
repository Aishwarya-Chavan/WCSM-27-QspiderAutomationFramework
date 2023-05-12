package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	@BeforeSuite
	public void bsconfig()
	{
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void asconfig()
	{
		System.out.println("After Suite");
	}
	@BeforeClass
	public void bcconfig()
	{
		System.out.println("Before Class");
	}
	@AfterClass
	public void aconfig()
	{
		System.out.println("After Class");
	}
	@BeforeMethod
	public void bmconfig()
	{
		System.out.println("Before Method");
	}
	@AfterMethod
	public void amconfig()
	{
		System.out.println("After Method");
	}
	@Test
	public void test()
	{
		System.out.println("Test");
	}

}
