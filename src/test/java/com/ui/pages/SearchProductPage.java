package com.ui.pages;

import com.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchProductPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_HEADER = By.xpath("//span[@class='lighter']");
    private static final By PRODUCT_NAME_LIST = By.xpath("//h5[@itemprop='name']//a");

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchListingTitle(){
        return getVisibleText(PRODUCT_LISTING_HEADER);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
    	List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
    	List<String> productList = getAllVisibleText(PRODUCT_NAME_LIST);
        return productList.stream().anyMatch(name->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
    }


}
