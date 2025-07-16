package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import utilities.*;


public class LoginPage extends GridBrowsers {

	public static final String UserName = "//*[@name='username']";
	public static final String Password = "//*[@name='password']";
	public static final String LogIn_Button = "//*[@type='submit']";
	
	public final static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
	public static void LogIn(String UserName1, String Password1) throws Exception{
		try{
			driver.findElement(By.xpath(UserName)).sendKeys(UserName1);
			Test.log(LogStatus.PASS, "User enter UserName as " + UserName1);
			test.pass("User enter UserName as " + UserName1);
			logger.info("User enter UserName as " + UserName1);
			Thread.sleep(500);
			
			driver.findElement(By.xpath(Password)).sendKeys(Password1);
			Test.log(LogStatus.PASS, "User enter Password as " + Password1);
			test.pass("User enter Password as " + Password1);
			logger.info("User enter Password as " + Password1);
			Thread.sleep(500);
			
			ReportScreenshot();
			AventStackReportScreenshot();
			
			driver.findElement(By.xpath(LogIn_Button)).click();
			Test.log(LogStatus.PASS, "User click LogIn Button");
			test.pass("User click LogIn Button");
			logger.info("User click LogIn Button");
			Thread.sleep(3000);
			
			Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
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
	
	public static void LogIn1() throws Exception{
		try{
			driver.findElement(By.xpath(UserName)).sendKeys(p.getProperty("Username1"));
			Thread.sleep(500);
			Test.log(LogStatus.PASS, "User enter UserName as " + p.getProperty("Username1"));
			test.pass("User enter UserName as " + p.getProperty("Username1"));
			logger.info("User enter UserName as " + p.getProperty("Username1"));
			
			driver.findElement(By.xpath(Password)).sendKeys(p.getProperty("Password1"));
			Thread.sleep(500);
			Test.log(LogStatus.PASS, "User enter Password as " + p.getProperty("Password1"));
			test.pass("User enter Password as " + p.getProperty("Password1"));
			logger.info("User enter Password as " + p.getProperty("Password1"));
			ReportScreenshot();
			AventStackReportScreenshot();
			
			driver.findElement(By.xpath(LogIn_Button)).click();
			Test.log(LogStatus.PASS, "User click LogIn Button");
			test.pass("User click LogIn Button");
			logger.info("User click LogIn Button");
			Thread.sleep(3000);
			
			Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
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
