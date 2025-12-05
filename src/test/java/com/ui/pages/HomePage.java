package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtility;
import org.openqa.selenium.WebDriver;

import static com.utilities.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LINK_LOCATOR = By.className("login");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		// goToWebsite(readProperty(QA,"URL"));//To call the parent class constructor
		// from child class constructor
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());
		maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readEnvURL(QA).getUrl());

	}

	public LoginPage goToLoginPage() { // page function
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());

	}

}
