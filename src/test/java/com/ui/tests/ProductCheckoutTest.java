package com.ui.tests;

import com.constants.Size;
import com.ui.pages.SearchProductPage;
import com.utilities.FakerUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class ProductCheckoutTest extends TestBase{

    private static String SEARCH_TERM = "Printed Summer Dress";
    private SearchProductPage searchProductPage;

    @BeforeMethod(description = "Valid user logged in into the application")
    public void setup(){
        searchProductPage = homePage.goToLoginPage().doLoginWith("caroxem662@besenica.com","password").searchForAProduct(SEARCH_TERM);
    }

    @Test(description = "Verify user is able to checkout product",groups = {"e2e","sanity"},
    retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
    public void verifyProductCheckout(){
        searchProductPage.clickOnTheProductAt(0).changeSize(Size.M).addProductToCart().proceedToCheckout();
    }
}
