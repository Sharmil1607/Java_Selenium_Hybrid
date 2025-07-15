package firstproject;

import org.testng.annotations.*;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.*;

//@Listeners(utilities.AventStackReport.class)
public class Login_TestCase_1 extends Browsers {

	@BeforeMethod
	void reports() throws Exception {
		ReleventCodesReports.ExtentReport("OrangeHRM", "Login_TestCase_1");
		AventStackReport.onStart(null, "OrangeHRM");
		AventStackReport.onTestStart(null, "Login_TestCase_1");
	}
	
	@Test(dataProvider = "dp1", retryAnalyzer = RetryAnalyzer.class)
	void scenario(String Browser, String UserName, String Password) throws Exception {
		Browsers.LaunchBrowser(Browser);
		LoginPage.LogIn(UserName, Password);
		LogOutPage.LogOut();
	}

	@AfterMethod
	void browserquit() {
		ReleventCodesReports.Flush();
		AventStackReport.onFinish(null, null);
		Browsers.Quit();
	}

	@DataProvider(name = "dp1")
	public Object[][] dp1() throws Exception {
		return ExcelData.GetSheet("Login", "Case1");
	}

}
