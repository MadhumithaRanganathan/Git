package org.adactin.listener;

import org.adactin.report.ExtentReportBase;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestNGListener implements ITestNGListener {
	
	public void onstart(ITestContext context) {
		ExtentReportBase.getInstance();
	}

	public void onTestStart(ITestResult result) {
		
		ExtentReportBase.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		String s = "";
		Object[] parameters = result.getParameters();
		for (Object object : parameters) {
			s = s+" " +object.toString();
		}
		ExtentReportBase.createTest.log(Status.PASS, s);
	}

	public void onTestFailure(ITestResult result) {
		ExtentReportBase.createTest.log(Status.FAIL, "Test case is Passed");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentReportBase.createTest.log(Status.SKIP, "Test case is Passed");
	}

	


}



