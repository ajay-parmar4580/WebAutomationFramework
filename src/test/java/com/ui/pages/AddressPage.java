package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utilities.BrowserUtility;

public class AddressPage extends BrowserUtility{

    private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
    private static final By ADDRESS_LINE1_TEXTBOX_LOCATOR = By.id("address1");
    private static final By ADDRESS_LINE2_TEXTBOX_LOCATOR = By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
    private static final By POSTALCODE_TEXTBOX_LOCATOR = By.id("postcode");
    private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.id("phone");
    private static final By MOBILEPHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
    private static final By ADDITIONALINFO_TEXTBOX_LOCATOR =By.id("other");
    private static final By ADDRESSTITLE_TEXTBOX_LOCATOR = By.id("alias");

    private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//div[@id='uniform-id_state']");

    private static final By SAVEADDRESS_BUTTON = By.id("submitAddress");

    private static final By ADDRESS_HEADING_TEXT = By.xpath("//h3[@class='page-subheading']");


    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public String saveAddress(AddressPOJO addressPOJO) {
        enterText(COMPANY_TEXTBOX_LOCATOR, addressPOJO.getCompanyName());
        enterText(ADDRESS_LINE1_TEXTBOX_LOCATOR, addressPOJO.getAddressLine1());
        enterText(ADDRESS_LINE2_TEXTBOX_LOCATOR, addressPOJO.getAddressLine2());
        enterText(CITY_TEXTBOX_LOCATOR, addressPOJO.getCity());
        enterText(POSTALCODE_TEXTBOX_LOCATOR, addressPOJO.getPostCode());
        enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPOJO.getHomePhone());
        enterText(MOBILEPHONE_TEXTBOX_LOCATOR, addressPOJO.getMobilePhone());
        enterText(ADDITIONALINFO_TEXTBOX_LOCATOR, addressPOJO.getOtherInformation());
        enterText(ADDRESSTITLE_TEXTBOX_LOCATOR, addressPOJO.getAddressAlias());
        selectDynamicDropdown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
        clickOn(SAVEADDRESS_BUTTON);
        return getVisibleText(ADDRESS_HEADING_TEXT);
    }

}
