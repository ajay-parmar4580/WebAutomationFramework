package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{
	

	@Test(description = "Verify User is able to login from json data",groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
	public void loginTestJson(User user)
	{	
		assertEquals(homePage.goToBookStoreApplication().goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "ajayparmar1087");
	}
	
	@Test(description = "Verify User is able to login from csv data",groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider")
	public void loginTestCSV(User user)
	{	
		assertEquals(homePage.goToBookStoreApplication().goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "ajayparmar1087");
	}
	
	@Test(description = "Verify User is able to login from excel data",groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginTestExcel(User user)
	{	
		assertEquals(homePage.goToBookStoreApplication().goToLoginPage()
				.doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "ajayparmar1087");
	}

}
