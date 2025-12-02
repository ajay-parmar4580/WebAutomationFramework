package com.ui.tests;

import com.constants.Browser;
import com.utilities.LambdaTestUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest){
			//For cloud test execution
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}
		else {
			//For local test execution
			logger.info("Load the homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	@AfterMethod(description="Close the Broeser and cleanUp")
	public void tearDown() {
		if(homePage!=null) {
			if(isLambdaTest)
				LambdaTestUtility.quitSession();
			else
				homePage.quitDriver();
		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}


}
