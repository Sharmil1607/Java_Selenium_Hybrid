package firstproject;

import org.testng.annotations.*;
import pages.*;
import utilities.*;

public class Login_TestCase_2 {

	@BeforeMethod
	void reports() throws Exception {
		ReleventCodesReports.ExtentReport("OrangeHRM", "Login_TestCase_2");
		AventStackReport.onStart(null, "OrangeHRM");
		AventStackReport.onTestStart(null, "Login_TestCase_2");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	void scenario() throws Exception {		
		Browsers.LaunchBrowser("firefox");
		LoginPage.LogIn1();
		LogOutPage.LogOut();
	}

	@AfterMethod
	void browserquit() {
		ReleventCodesReports.Flush();
		AventStackReport.onFinish(null, null);
		Browsers.Quit();
	}
	
}
