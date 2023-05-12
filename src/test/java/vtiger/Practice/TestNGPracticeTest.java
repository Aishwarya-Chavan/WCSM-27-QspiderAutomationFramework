package vtiger.Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test(priority = 1,invocationCount =3)
	public void createUserTest()
	{
		System.out.println("User created");
		Reporter.log("User Created",true);
	}
	
	@Test(priority = 0)
	public void modifyUserTest()
	{
		System.out.println("User Modified");
		Reporter.log("User modified",true);
	}
	
	@Test(priority = 2)
	public void deleteUserTest()
	{
		System.out.println("User Deleted");
		Reporter.log("User deleted",true);
	}

}
