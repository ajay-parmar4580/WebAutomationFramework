package com.ui.pages;

import com.constants.Size;
import com.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {
    private static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//div[@id='uniform-group_1']");
    private static final By COLOR_BLUE_LOCATOR = By.xpath("//a[@title='Blue']");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@title='Proceed to checkout']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectDynamicDropdown(SIZE_DROPDOWN_LOCATOR,size.toString());
        clickOn(COLOR_BLUE_LOCATOR);
        //selectDropDownByVisibleText(SIZE_DROPDOWN_LOCATOR,size.toString());
        return this;
    }

    public ProductDetailPage addProductToCart(){
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return this;
    }

    public CheckoutPage proceedToCheckout(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON);
        return new CheckoutPage(getDriver());
    }



}
