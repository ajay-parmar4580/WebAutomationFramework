package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private static final By PWD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	public MyAccountPage doLoginWith(String email, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		enterText(PWD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());
	}


}
