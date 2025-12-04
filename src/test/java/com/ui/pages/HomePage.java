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
	private static final By LOGIN_NAV_LOCATOR = By.xpath("//span[text()='Login']//parent::li");
	private static final By BOOK_STORE_APP_LOCATOR = By.xpath("//h5[text()='Book Store Application']");	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);//To call the parent class constructor form child constructor
		//goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());
	}

	public HomePage(WebDriver driver){
		super(driver);
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() {
		scrollToElement(LOGIN_NAV_LOCATOR);
		clickOn(LOGIN_NAV_LOCATOR);
		return new LoginPage(getDriver());
	}
	
	public HomePage goToBookStoreApplication() {
		scrollToElement(BOOK_STORE_APP_LOCATOR);
		clickOn(BOOK_STORE_APP_LOCATOR);
		return this;
	}
	

}
