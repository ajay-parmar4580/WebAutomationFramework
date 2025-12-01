package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);// initialize the instance variable driver!!
    }

    public BrowserUtility(Browser browsername, boolean isHeadless) {
        super();
        WebDriver webDriver = null;

        if (browsername == Browser.CHROME) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--no-sandbox");
            if (isHeadless) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
            } else {

                driver.set(new ChromeDriver(chromeOptions));
            }

        } else if (browsername == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("disable-gpu");
                driver.set(new EdgeDriver(edgeOptions));
            } else
                driver.set(new EdgeDriver());

        } else if (browsername == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addArguments("disable-gpu");
                driver.set(new FirefoxDriver(firefoxOptions));
            } else
                driver.set(new FirefoxDriver());
        }
    }

    public void goToWebsite(String url) {
        if (driver.get() != null)
            driver.get().get(url);// go to given url
    }

    public void maximizeWindow() {
        if (driver.get() != null)
            driver.get().manage().window().maximize();// maximize the window
    }

    public void clickOn(By locator) {
        if (driver.get() != null) {
            WebElement element = driver.get().findElement(locator);
            element.click();
        }
    }

    public void enterText(By locator, String text) {
        if (driver.get() != null) {
            WebElement element = driver.get().findElement(locator);
            element.sendKeys(text);
        }
    }

    public String getVisibleText(By locator) {
        if (driver.get() != null) {
            WebElement element = driver.get().findElement(locator);
            return element.getText();
        }
        return "";
    }

    public String takeScreenshot(String name) {
        if (driver.get() == null) {
            return "";
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = dateFormat.format(date);

        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

        //Create screenshot directory if not exist
        File screenshotDir = new File(System.getProperty("user.dir") + "//screenshots//");
        if (!screenshotDir.exists())
            screenshotDir.mkdirs();

        String path = System.getProperty("user.dir") + "//screenshots//" + name + "-" + timeStamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.remove();
            }
        }
    }

}
