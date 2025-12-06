package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browsername == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless");
				firefoxOptions.addArguments("--window-size=1920,1080");
				firefoxOptions.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(firefoxOptions));
			} else {
				driver.set(new FirefoxDriver());
			}
		}
	}

	public void goToWebsite(String url) {
		if (getDriver() != null)
			getDriver().get(url);// go to given url
	}

	public void maximizeWindow() {
		if (getDriver() != null)
			getDriver().manage().window().maximize();// maximize the window
	}

	public void clickOn(By locator) {
		if (getDriver() != null) {
			WebElement element = WaitUtility.waitForClickable(getDriver(),locator);
			element.click();
		}
	}

	public void enterText(By locator, String text) {
		if (getDriver() != null) {
			WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
			clearText(locator);
			element.sendKeys(text);
		}
	}

	public void clearText(By locator) {
		if (getDriver() != null) {
			WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
			element.clear();
		}
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		if (getDriver() != null) {
			WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
			element.sendKeys(keyToEnter);
		}
	}

	public String getVisibleText(By locator) {
		if (getDriver() != null) {
			WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
			return element.getText();
		}
		return "";
	}

	public List<String> getAllVisibleText(By locator){
		if (getDriver() != null) {
			List<WebElement> webElementList = WaitUtility.waitForVisibleElements(getDriver(),locator);
			List<String> textList = new ArrayList<>();
			for(WebElement element: webElementList){
				textList.add(element.getText());
			}
			return textList;
		}
		return null;
	}

	public String takeScreenshot(String name) {
		if (getDriver() == null) {
			return "";
		}
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);

		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

		//String path = Paths.get(System.getProperty("user.dir"), "screenshots",name + "-" + timeStamp + ".png").toString();
		String path = "./screenshots/"+name + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quitDriver() {
		if (getDriver() != null) {
			try {
				getDriver().quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.remove();
			}
		}
	}

	public void scrollToElement(By locator){
		WebElement element = getDriver().findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}

