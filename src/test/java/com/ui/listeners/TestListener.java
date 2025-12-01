package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utilities.BrowserUtility;
import com.utilities.ExtentReportUtility;
import com.utilities.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("=== Test Started: " + result.getMethod().getMethodName() + " ===");
		logger.info("Description: " + result.getMethod().getDescription());
		logger.info("Groups: " + Arrays.toString(result.getMethod().getGroups()));

		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().info("Test Description: " + result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());

		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		try {
			Object testClass = result.getInstance();
			BrowserUtility browserUtility = ((TestBase) testClass).getInstance();

			if (browserUtility != null && browserUtility.getDriver() != null) {
				logger.info("Capturing Screenshot for failed testcase");
				String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
				logger.info("Screenshot saved at: " + screenshotPath);

				if (screenshotPath != null && !screenshotPath.isEmpty()) {
					ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
					logger.info("Screenshot attached to extent report");
				}
			} else {
				logger.warn("Browser instance is null, cannot capture screenshot");
			}
		} catch (Exception e) {
			logger.error("Error capturing screenshot: "+e.getMessage());
			ExtentReportUtility.getTest().warning("Could not capture screenshot: "+e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
		
		if(result.getThrowable() != null) {
			logger.warn("Skip Reason: "+result.getThrowable());
			ExtentReportUtility.getTest().log(Status.SKIP, result.getThrowable().getMessage());
		}
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("==============================================");
		logger.info("Test Suite Started: "+context.getName());
		logger.info("==============================================");
		
		ExtentReportUtility.setupSparkReporter("ExtentReport.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("==============================================");
		logger.info("Test Suite Completed: "+context.getName());
		logger.info("Total Tests: "+context.getAllTestMethods().length);
		logger.info("Passed: "+context.getPassedTests().size());
		logger.info("Failed: "+context.getFailedTests().size());
		logger.info("Skipper: "+context.getSkippedTests().size());
		logger.info("==============================================");
		;
		ExtentReportUtility.flushReport();
	}
}
