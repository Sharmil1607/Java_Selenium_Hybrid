package utilities;

import org.testng.*;

public class Listneres implements ITestListener {

	//we need another version of extent report there we use this listeners
	
	public void onStart(ITestContext context) {
	    System.out.println("Test Started");
	  }
	
	public void onTestSuccess(ITestResult result) {
		 System.out.println("Test Passed");
	  }
	
	public void onTestFailure(ITestResult result) {
		 System.out.println("Test Failed");
	  }
	
	public void onTestSkipped(ITestResult result) {
		 System.out.println("Test Skipped");
	  }
	
	public void onFinish(ITestContext context) {
		 System.out.println("Test Ended");
	  }
	
	
}
