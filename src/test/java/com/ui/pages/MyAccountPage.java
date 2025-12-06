package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NAME_TEXT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
    private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");

    public String getUserName() {
        return getVisibleText(USER_NAME_TEXT_LOCATOR);
    }

    public SearchProductPage searchForAProduct(String product){
        enterText(SEARCH_TEXT_BOX_LOCATOR,product);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        return new SearchProductPage(getDriver());
    }

}
