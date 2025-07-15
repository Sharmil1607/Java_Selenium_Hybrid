package utilities;

import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import com.relevantcodes.extentreports.*;


public class ReleventCodesReports {

	public static WebDriver driver;
	public static ExtentReports Extent;
	public static ExtentTest Test;
	
	public static Properties p;
	
	public static void reader() throws Exception {
		//To Load config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
	}

	public static void ExtentReport (String ProjectName, String ClassName) {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date d = new Date();
		String date= dateFormat.format(d);

		File folder=new File (date);		 
		folder.mkdir();

		String Path = "D:\\TESTING\\AutomationProjects\\Hybrid\\ReleventCodes\\" + folder + "\\" + ProjectName + ".html";

		Extent = new ExtentReports(Path, false);
		Test = Extent.startTest(ClassName);
		Extent.loadConfig(new File("./config.xml"));
	}

	public static void Flush() {

		Extent.endTest(Test);
		Extent.flush();	
	}

	public static String CaptureScreen() throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date d = new Date();
		String date= dateFormat.format(d);

		File folder=new File (date);		 
		folder.mkdir();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File des = new File("D:\\TESTING\\AutomationProjects\\Hybrid\\ReleventCodes\\" + folder + "\\" + FileName );

		String pathlocation = des.getAbsolutePath();

		FileUtils.copyFile(src, des);

		return pathlocation;
	}

	public static void ReportScreenshot() throws Exception {

		Test.log(LogStatus.INFO, Test.addScreenCapture(CaptureScreen ()));
	}

	//To the the Screenshot
	public static void TakeSnap() {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date d = new Date();
		String date= dateFormat.format(d);

		File folder=new File (date);		 
		folder.mkdir();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:\\TESTING\\AutomationProjects\\Hybrid\\Screenshots\\" + folder + "\\" + FileName));
		} 

		catch (IOException e) {
			System.out.println("Snapshot Failed");
		}
	}
	
}
