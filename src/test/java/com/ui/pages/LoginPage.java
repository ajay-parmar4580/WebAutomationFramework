package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By USERNAME_LOCATOR = By.id("userName");
	private static final By PASSWORD_LOCATOR = By.id("password");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("login");
	
	public MyAccountPage doLoginWith(String email, String password) {
		enterText(USERNAME_LOCATOR, email);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());
	}


}
