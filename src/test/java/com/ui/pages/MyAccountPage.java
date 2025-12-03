package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By USER_NAME_TEXT_LOCATOR = By.id("userName-value");
	
	public String getUserName() {
		return getVisibleText(USER_NAME_TEXT_LOCATOR);
	}

}
