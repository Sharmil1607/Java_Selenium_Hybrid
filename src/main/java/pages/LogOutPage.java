package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.Browsers;

public class LogOutPage extends Browsers {

	public static final String LogOut_Icon = "//*[@class='oxd-userdropdown-name']";
	public static final String LogOut_Button = "//*[text()='Logout']";
	
	public static void LogOut() throws Exception{
		try{
			Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			
			driver.findElement(By.xpath(LogOut_Icon)).click();
			Test.log(LogStatus.PASS, "User click LogOut Icon");
			test.pass("User click LogOut Icon");
			logger.info("User click LogIn Button");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(LogOut_Button)).click();
			Test.log(LogStatus.PASS, "User click LogOut Button");
			test.pass("User click LogOut Button");
			logger.info("User click LogIn Button");
			Thread.sleep(3000);
			
			ReportScreenshot();
			AventStackReportScreenshot();
			
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
		catch(Exception e){
			Test.log(LogStatus.FAIL, "Login Failed" + Test.addScreenCapture(CaptureScreen ()));
			test.fail("Login Failed");
			AventStackReportScreenshot();
			logger.info("Login Failed");
			Assert.fail();
			driver.quit();
		}
		finally {
			TakeSnap();
		}
	}
	
}
