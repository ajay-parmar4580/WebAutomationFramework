package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtility;
import org.openqa.selenium.WebDriver;

import static com.utilities.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{
	//In this class we are going to follow Page Object Design Pattern
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);//To call the parent class constructor form child constructor
		//goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());
	}

	public HomePage(WebDriver driver){
		super(driver);
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());
	}

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[normalize-space()='Sign in']");
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

	

}
