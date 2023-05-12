package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void practice()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true, true);
		System.out.println("step3");
		System.out.println("step4");
		
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step1 - practice");
		System.out.println("step2 - practice");
		
		sa.assertEquals("A", "b");
		System.out.println("step3 - practice");
		
		sa.assertTrue(false);
		
		System.out.println("step4 - practice");
		sa.assertAll();
	}

}
