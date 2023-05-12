package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation for the ITListerner Interface of TestNG
 */
	

public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	String methodName =result.getMethod().getMethodName();
	//System.out.println(methodName+"==Test script execution started===");
 
	test = report.createTest(methodName);
	test.log(Status.INFO, methodName+"==Test script execution started===");
	
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	String methodName = result.getMethod().getMethodName();
	//System.out.println(methodName+"===Test script PASSED===");

	test.log(Status.PASS, methodName+"===PASS===");
}

public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	String methodName = result.getMethod().getMethodName();
	//System.out.println(methodName+"===Test script FAILED===");
	//System.out.println(result.getThrowable());
	
	test.log(Status.FAIL, methodName+"===FAIL===");
	test.log(Status.INFO, result.getThrowable());
	WebDriverUtility wUtil = new WebDriverUtility();
	
	String screenShotName = methodName+"_"+new JavaUtility().getSystemDateInFormat();
	
	try {
		String path =wUtil.takeScreenShot(BaseClass.sDriver,screenShotName);
		test.addScreenCaptureFromPath(path); //go the screenshot location and it will attach the report
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	String methodName = result.getMethod().getMethodName();
	//System.out.println(methodName+"===Test script SKIPPED===");
	//System.out.println(result.getThrowable());
	
	test.log(Status.SKIP, methodName+"===SKIP===");
	test.log(Status.INFO, result.getThrowable());
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
}

public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub

}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.println("===Execution Started===");
	
	//Extent Report Configuration
																				//Report-05 Apr 2023-10-23-45.html
	ExtentSparkReporter htmlreporter = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
	htmlreporter.config().setDocumentTitle("Vtiger Execution Report");
	htmlreporter.config().setTheme(Theme.DARK);
	htmlreporter.config().setReportName("Automation Excecution Report");
	
	report = new ExtentReports();
	report.attachReporter(htmlreporter);
	report.setSystemInfo("Base URL", "http://localhost:8888");
	report.setSystemInfo("Base Browser", "FireFox");
	report.setSystemInfo("Base Platform", "Windows");
	report.setSystemInfo("Reporter-Name", "Aishwarya");
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.println("===Execution Finished===");
	report.flush(); //generate the report
}


}
