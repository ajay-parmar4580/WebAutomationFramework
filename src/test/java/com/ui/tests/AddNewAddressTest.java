package com.ui.tests;

import com.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;

@Listeners({com.ui.listeners.TestListener.class})
public class AddNewAddressTest extends TestBase{
    private MyAccountPage myAccountPage;
    private AddressPOJO addressPOJO;
    @BeforeMethod(description = "Valid user logged in into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("caroxem662@besenica.com","password");
        addressPOJO = FakerUtility.getAddressDetails();
    }

    @Test(description = "Verify add address functionality",groups = {"e2e","sanity"})
    public void addNewAddressTest() {
        String newAddress = myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
        Assert.assertEquals(newAddress,addressPOJO.getAddressAlias().toUpperCase());
    }

}
