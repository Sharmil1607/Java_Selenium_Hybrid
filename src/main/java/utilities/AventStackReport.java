package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import tech.grasshopper.reporter.ExtentPDFReporter;

public class AventStackReport extends ReleventCodesReports implements ITestListener{

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static ExtentPDFReporter pdf;

//	public static void pdfextentreport(String ProjectName) throws Exception	{
//		
//		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//		Date d = new Date();
//		String date= dateFormat.format(d);
//		File folder=new File (date);
//		folder.mkdir();
//		String Path = "D:\\TESTING\\AutomationProjects\\Hybrid_SQL\\AventStack\\" + folder + "\\" + ProjectName +".html";
//		String PdfPath = "D:\\TESTING\\AutomationProjects\\Hybrid_SQL\\AventStack\\" + folder + "\\"+ ProjectName + ".pdf";
//		
//		extent = new ExtentReports();
//		spark = new ExtentSparkReporter(Path);
//		pdf = new ExtentPDFReporter(PdfPath);
//		pdf.config().setTitle("OrangeHRM");
//		pdf.config().setReportName("OrangeHRM Automation Testing");
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("OrangeHRM Automation Testing");
//		extent.attachReporter(spark);
//		extent.attachReporter(pdf);
//	}
//	
//	public static void pdfreport(String ClassName)	{
//		
//		test = extent.createTest(ClassName);
//	}
//	
//	public static void pdfflush()	{
//		
//		extent.flush();
//	}

	public static String CaptureScreen() throws Exception{

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date d = new Date();
		String date= dateFormat.format(d);

		File folder=new File (date);		 
		folder.mkdir();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File des = new File("D:\\TESTING\\AutomationProjects\\Hybrid\\AventStack\\" + folder + "\\" + FileName );

		String pathlocation = des.getAbsolutePath();

		FileUtils.copyFile(src, des);

		return pathlocation;
	}

	public static void AventStackReportScreenshot() throws Exception {

		test.addScreenCaptureFromPath(CaptureScreen());
	}
	
	public static void onStart(ITestContext context, String ProjectName) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date d = new Date();
		String date= dateFormat.format(d);
		File folder=new File (date);
		folder.mkdir();
		String Path = "D:\\TESTING\\AutomationProjects\\Hybrid\\AventStack\\" + folder + "\\" + ProjectName +".html";
		String PdfPath = "D:\\TESTING\\AutomationProjects\\Hybrid\\AventStack\\" + folder + "\\"+ ProjectName + ".pdf";
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(Path);
		pdf = new ExtentPDFReporter(PdfPath);
		pdf.config().setTitle("OrangeHRM");
		pdf.config().setReportName("OrangeHRM Automation Testing");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("OrangeHRM Automation Testing");
		extent.attachReporter(spark);
		extent.attachReporter(pdf);
	  }
	
	public static void onTestStart(ITestContext context, String ClassName) {
		test = extent.createTest(ClassName);
	}
	
	public void onTestSuccess(ITestResult result, String ClassName) {
		//test = extent.createTest(ClassName);
		test.log(Status.PASS, "Test Case is Passed : " + result.getName());
	  }
	
	public void onTestFailure(ITestResult result, String ClassName) {
		//test = extent.createTest(ClassName);
		test.log(Status.PASS, "Test Case is Passed : " + result.getName());
	  }
	
	public void onTestSkipped(ITestResult result, String ClassName) {
		//test = extent.createTest(ClassName);
		test.log(Status.PASS, "Test Case is Passed : " + result.getName());
	  }
	
	public static void onFinish(ITestContext context, String value) {
		extent.flush();
	  }
	
}
