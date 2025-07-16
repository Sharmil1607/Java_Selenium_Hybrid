package gridproject;

import org.testng.annotations.*;
import pages.*;
import utilities.*;

public class Grid_Login_TestCase_001 extends GridBrowsers {

	@BeforeMethod
	void reports() throws Exception {
		ReleventCodesReports.ExtentReport("OrangeHRM", "Login_TestCase_1");
		AventStackReport.onStart(null, "OrangeHRM");
		AventStackReport.onTestStart(null, "Login_TestCase_1");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Parameters({"OS", "Browser"})
	void scenario(String OS, String Browser) throws Exception {
		GridBrowsers.LaunchBrowser(OS, Browser);
		LoginPage.LogIn1();
		LogOutPage.LogOut();
	}

	@AfterMethod
	void browserquit() {
		ReleventCodesReports.Flush();
		AventStackReport.onFinish(null, null);
		GridBrowsers.Quit();
	}
	
}
