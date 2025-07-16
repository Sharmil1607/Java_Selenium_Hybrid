package utilities;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.*;

public class Browsers extends AventStackReport {
	
	public static final String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static Logger logger;

	public static void LaunchBrowser(String Browser) throws Exception {
		
		if (p == null) {
	        reader(); // This ensures the properties file is loaded
	    }
		
		logger = LogManager.getLogger(); //this.getClass() - get the name of the class in log file

		if (Browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Test.log(LogStatus.INFO, "Chrome Browser Started Successfully");
			test.info("Chrome Browser Started Successfully");
			logger.info("Chrome Browser Started Successfully");
			System.out.println("Chrome Browser Started Successfully");
		}

		else if (Browser.equalsIgnoreCase("HChrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--Window-size=1280,800");
			driver = new ChromeDriver(options);			
			Test.log(LogStatus.INFO, "Headless Chrome Browser Started Successfully");
			test.info("Headless Chrome Browser Started Successfully");
			logger.info("Headless Chrome Browser Started Successfully");
			System.out.println("Headless Chrome Browser Started Successfully");
		}
		
		else if (Browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Test.log(LogStatus.INFO, "Firefox Browser Started Successfully");
			test.info("Firefox Browser Started Successfully");
			logger.info("Firefox Browser Started Successfully");
			System.out.println("Firefox Browser Started Successfully");
		} 
		
		else if (Browser.equalsIgnoreCase("HFirefox")) {

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--Window-size=1280,800");
			driver = new FirefoxDriver(options);
			Test.log(LogStatus.INFO, "Headless Firefox Browser Started Successfully");
			test.info("Headless Firefox Browser Started Successfully");
			logger.info("Headless Firefox Browser Started Successfully");
			System.out.println("Headless Firefox Browser Started Successfully");
		} 
		
		else if (Browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			Test.log(LogStatus.INFO,"Edge Browser Started Successfully");
			test.info("Edge Browser Started Successfully");
			logger.info("Edge Browser Started Successfully");
			System.out.println("Edge Browser Started Successfully");
		}  

		else if (Browser.equalsIgnoreCase("HEdge")) {
			
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			options.addArguments("--Window-size=1280,800");
			driver = new EdgeDriver(options);
			Test.log(LogStatus.INFO,"Headless Edge Browser Started Successfully");
			test.info("Headless Edge Browser Started Successfully");
			logger.info("Headless Edge Browser Started Successfully");
			System.out.println("Headless Edge Browser Started Successfully");
		}  

		else {
			Test.log(LogStatus.FAIL, "Browser Name is Wrong");
			test.fail("Browser Name is Wrong");
			logger.info("Browser Name is Wrong");
			System.out.println("Browser Name is Wrong");
		}
		
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.get(p.getProperty("Url")); //to use values from config.properties
		Thread.sleep(3000);
		
		String URL = driver.getCurrentUrl();
		Test.log(LogStatus.INFO, "URL:- " + URL);
		test.info("URL:- " + URL);
		logger.info("URL:- " + URL);
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	public static void Quit(){
		driver.quit();
		Test.log(LogStatus.FAIL, "Browser Quit Scuccessfully");
		test.fail("Browser Quit Scuccessfully");
		logger.info("Browser Quit Scuccessfully");
		System.out.println("Browser Quit Scuccessfully");
	}

}
