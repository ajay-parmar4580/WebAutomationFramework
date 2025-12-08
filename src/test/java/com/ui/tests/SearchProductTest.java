package com.ui.tests;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static String SEARCH_TERM = "Printed Summer Dress";

    @BeforeMethod(description = "Valid user logged in into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("caroxem662@besenica.com","password");
    }

    @Test(description = "Verify user should be able to search product correctly",groups = {"e2e","sanity","smoke"})
    public void verifyProductSearch(){
        String title =myAccountPage.searchForAProduct(SEARCH_TERM).getSearchListingTitle();
        System.out.println(title);
    }

    @Test(description = "Verify user should be able to search product correctly and get list",groups = {"e2e","sanity","smoke"})
    public void verifyProductList(){
        boolean isSearchTermPresent= myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
        Assert.assertEquals(isSearchTermPresent, true);
    }

}
