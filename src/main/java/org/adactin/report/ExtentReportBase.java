package org.adactin.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportBase {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest createTest;
	public static String extentReportFile = System.getProperty("user.dir") + "/Report/ExtentReport.html";

	public static ExtentReports getInstance() {
		if (extent == null) {
			extent = createInstance();
		}

		return extent;
	}

	public static ExtentReports createInstance() {
 
		spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setDocumentTitle("Adactin Test Report");
		spark.config().setReportName("Extent Report");
		spark.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Task name","TestNG DataProvider" );
		extent.setSystemInfo("No. of Data","3" );
		extent.setSystemInfo("Tester","Madhu mitha R" );
		return extent;
	}
	
	public static void createTest(String TestName) {
		createTest = extent.createTest(TestName);
	}
	
	public static void flushReport() {
		extent.flush();
	}
	

}


