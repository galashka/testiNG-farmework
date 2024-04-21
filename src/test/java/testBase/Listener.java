package testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.Workers;

public class Listener implements ITestListener{

	public void onStart(ITestContext context) {
		
		System.out.println("Test Started.");
	}
	
	
	public void onFinish(ITestContext context) {
		
		System.out.println("Test Finished.");
	}
	
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test will start: " + result.getName());
		
		BrowserManager.test = BrowserManager.report.createTest(result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test passed: " + result.getName());
		
		BrowserManager.test.pass("Test passed: " + result.getName());
		
		String testSuccessScreenshot = Workers.captureScreenshot("passed\\" + result.getName());
		
		BrowserManager.test.addScreenCaptureFromPath(testSuccessScreenshot);
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test failed: " + result.getName());
		
		BrowserManager.test.fail("Test failed: " + result.getName());
		
		String testFailureScreenshot = Workers.captureScreenshot("failed\\" + result.getName());
		
		BrowserManager.test.addScreenCaptureFromPath(testFailureScreenshot);
	}
	
	
	
}
