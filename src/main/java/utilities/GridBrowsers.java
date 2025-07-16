package utilities;

import java.net.URL;
import java.time.Duration;
import org.apache.logging.log4j.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;
import com.relevantcodes.extentreports.LogStatus;

public class GridBrowsers extends AventStackReport {

	public static final String huburl = "http://192.168.0.103:4444/wd/hub";
	public static final String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static Logger logger;

	
	public static void LaunchBrowser(String OS, String Browser) throws Exception {

		if (p == null) {
			reader(); // This ensures the properties file is loaded
		}

		logger = LogManager.getLogger(); //this.getClass() - get the name of the class in log file

		if(p.getProperty("Execution_Env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();

			if(OS.equalsIgnoreCase("Windows")) {
				cap.setPlatform(Platform.WIN11);
				Test.log(LogStatus.INFO, "Running in Windows OS");
				test.info("Running in Windows OS");
			}
			else if(OS.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
				Test.log(LogStatus.INFO, "Running in Mac OS");
				test.info("Running in Mac OS");
			}
			else if(OS.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
				Test.log(LogStatus.INFO, "Running in Linux OS");
				test.info("Running in Linux OS");
			}
			else {
				System.out.println("No Matching OS");
				return;
			}

			if(Browser.equalsIgnoreCase("Chrome")) {
				cap.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL(huburl), cap);
				driver.manage().window().maximize();
				Test.log(LogStatus.INFO, "Chrome Browser Started Successfully");
				test.info("Chrome Browser Started Successfully");
				logger.info("Chrome Browser Started Successfully");
				System.out.println("Chrome Browser Started Successfully");
			}
			else if(Browser.equalsIgnoreCase("Firefox")){
				cap.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(huburl), cap);
				Test.log(LogStatus.INFO, "Headless Chrome Browser Started Successfully");
				test.info("Headless Chrome Browser Started Successfully");
				logger.info("Headless Chrome Browser Started Successfully");
				System.out.println("Headless Chrome Browser Started Successfully");
			}
			else if(Browser.equalsIgnoreCase("Edge")) {
				cap.setBrowserName("MicrosoftEdge");
				driver = new RemoteWebDriver(new URL(huburl), cap);
				driver.manage().window().maximize();
				Test.log(LogStatus.INFO,"Edge Browser Started Successfully");
				test.info("Edge Browser Started Successfully");
				logger.info("Edge Browser Started Successfully");
				System.out.println("Edge Browser Started Successfully");
			}
			else {
				System.out.println("No Matching Browser");
				return;
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
		
		else {
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
	}

	public static void Quit(){
		driver.quit();
		Test.log(LogStatus.FAIL, "Browser Quit Scuccessfully");
		test.fail("Browser Quit Scuccessfully");
		logger.info("Browser Quit Scuccessfully");
		System.out.println("Browser Quit Scuccessfully");
	}

}
