package com.ui.tests;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;

    @BeforeMethod(description = "Valid user logged in into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("caroxem662@besenica.com","password");
    }

    @Test(description = "Verify user should be able to search product correctly",groups = {"e2e","sanity","smoke"})
    public void verifyProductSearch(){
        String title =myAccountPage.searchForAProduct("Printed Summer Dress").getSearchListingTitle();
        System.out.println(title);
    }

    @Test(description = "Verify user should be able to search product correctly and get list",groups = {"e2e","sanity","smoke"})
    public void verifyProductList(){
        String title = String.valueOf(myAccountPage.searchForAProduct("Printed Summer Dress").getAllProductNames());
        System.out.println(title);
    }

}
