package com.automation.utils;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pageobjects.common.PageElement;

public class PageHandler {

	protected WebDriver driver;
	protected static Actions action;
	protected RepositoryParser repositoryParser;
	protected String pageName;
	public static String mobileNumber;

	public WebElement findElement(PageElement pageObject) {
		WebElement element = null;
		String locatorType = pageObject.getLocatorType();
		String locatorValue = pageObject.getLocatorValue();
		try {
			switch (locatorType) {
			case "id":
				element = driver.findElement(By.id(locatorValue));
				break;
			case "name":
				element = driver.findElement(By.name(locatorValue));
				break;
			case "className":
				element = driver.findElement(By.className(locatorValue));
				break;
			case "tagName":
				element = driver.findElement(By.tagName(locatorValue));
				break;
			case "linkTest":
				element = driver.findElement(By.linkText(locatorValue));
				break;
			case "partialLinkTest":
				element = driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "cssSelector":
				element = driver.findElement(By.cssSelector(locatorValue));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(locatorValue));
				break;
			default:
				break;
			}
			// Log.info(pageObject.getName() + " element was found in " +
			// driver.getTitle());
		} catch (Exception e) {
			System.out.println(pageObject.getName() + " element could not be found in " + driver.getTitle());
			throw (e);
		}

		Assert.assertTrue(element != null, "element cannot be null");
		return element;
	}

	public WebElement findElement(String objectName) {

		PageElement pageObject = repositoryParser.getPageObject(pageName, objectName);
		return findElement(pageObject);
	}

	public List<WebElement> findElements(String objectName) {

		PageElement pageObject = repositoryParser.getPageObject(pageName, objectName);
		return findElements(pageObject);

	}

	public List<WebElement> findElements(PageElement pageObject) {
		List<WebElement> elements = null;
		String locatorType = pageObject.getLocatorType();
		String locatorValue = pageObject.getLocatorValue();

		try {
			switch (locatorType) {
			case "id":
				elements = driver.findElements(By.id(locatorValue));
				break;
			case "name":
				elements = driver.findElements(By.name(locatorValue));
				break;
			case "className":
				elements = driver.findElements(By.className(locatorValue));
				break;
			case "tagName":
				elements = driver.findElements(By.tagName(locatorValue));
				break;
			case "linkTest":
				elements = driver.findElements(By.linkText(locatorValue));
				break;
			case "partialLinkTest":
				elements = driver.findElements(By.partialLinkText(locatorValue));
				break;
			case "cssSelector":
				elements = driver.findElements(By.cssSelector(locatorValue));
				break;
			case "xpath":
				elements = driver.findElements(By.xpath(locatorValue));
				break;
			default:
				break;
			}
			// Log.info(pageObject.getName() + " elements were found in " +
			// driver.getTitle());
		} catch (Exception e) {
			System.out.println(pageObject.getName() + " elements could not be found in " + driver.getTitle());
			throw (e);
		}

		Assert.assertTrue(elements != null, "elements cannot be null");

		return elements;
	}

	public WebElement findElement(WebElement webElement, PageElement pageObject) {
		WebElement element = null;
		String locatorType = pageObject.getLocatorType();
		String locatorValue = pageObject.getLocatorValue();
		try {
			switch (locatorType) {
			case "id":
				element = webElement.findElement(By.id(locatorValue));
				break;
			case "name":
				element = webElement.findElement(By.name(locatorValue));
				break;
			case "className":
				element = webElement.findElement(By.className(locatorValue));
				break;
			case "tagName":
				element = webElement.findElement(By.tagName(locatorValue));
				break;
			case "linkTest":
				element = webElement.findElement(By.linkText(locatorValue));
				break;
			case "partialLinkTest":
				element = webElement.findElement(By.partialLinkText(locatorValue));
				break;
			case "cssSelector":
				element = webElement.findElement(By.cssSelector(locatorValue));
				break;
			case "xpath":
				element = webElement.findElement(By.xpath(locatorValue));
				break;
			default:
				break;
			}
			// Log.info(pageObject.getName() + " element was found in " +
			// driver.getTitle());
		} catch (Exception e) {
			System.out.println(pageObject.getName() + " element could not be found");
			throw (e);
		}

		Assert.assertTrue(element != null, "element cannot be null");
		return element;
	}

	public WebElement findElement(WebElement webElement, String pageName, String objectName) {

		PageElement pageObject = repositoryParser.getPageObject(pageName, objectName);
		return findElement(webElement, pageObject);

	}

	public List<WebElement> findElements(WebElement webElement, String pageName, String objectName) {

		PageElement pageObject = repositoryParser.getPageObject(pageName, objectName);
		return findElements(webElement, pageObject);

	}

	public List<WebElement> findElements(WebElement webElement, PageElement pageObject) {
		List<WebElement> elements = null;
		String locatorType = pageObject.getLocatorType();
		String locatorValue = pageObject.getLocatorValue();

		try {
			switch (locatorType) {
			case "id":
				elements = webElement.findElements(By.id(locatorValue));
				break;
			case "name":
				elements = webElement.findElements(By.name(locatorValue));
				break;
			case "className":
				elements = webElement.findElements(By.className(locatorValue));
				break;
			case "tagName":
				elements = webElement.findElements(By.tagName(locatorValue));
				break;
			case "linkTest":
				elements = webElement.findElements(By.linkText(locatorValue));
				break;
			case "partialLinkTest":
				elements = webElement.findElements(By.partialLinkText(locatorValue));
				break;
			case "cssSelector":
				elements = webElement.findElements(By.cssSelector(locatorValue));
				break;
			case "xpath":
				elements = webElement.findElements(By.xpath(locatorValue));
				break;
			default:
				break;
			}
			// Log.info(pageObject.getName() + " elements were found in " +
			// driver.getTitle());
		} catch (Exception e) {
			System.out.println(pageObject.getName() + " elements could not be found");
			throw (e);
		}

		Assert.assertTrue(elements != null, "elements cannot be null");

		return elements;
	}

	public static void javaScriptExecuterClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
	}

	public void maximizeScreen(WebDriver driver) {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point position = new Point(0, 0);
		driver.manage().window().setPosition(position);
		Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(maximizedScreenSize);
	}

	public WebDriver openBrowser(String browserName, String Url) {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constant.MAC_FIREFOXDRIVER_PATH);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/shprata/Shiv/workspaceShiv/number-test_ass/quickfuseapps/Driver/Chrome/macchromedriver");
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--disable-extensions");
			driver = new ChromeDriver();
		}

		maximizeScreen(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.get(Url);
		System.out.println("Driver launched.");
		return driver;
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.SCREENSHOTS_PATH + sTestCaseName + ".jpg"));
		} catch (Exception e) {
			Log.error(sTestCaseName,
					"Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
							+ e.getMessage());
			throw new Exception();
		}
	}

	public WebElement getElement(String element) {
		return findElement(element);
	}

	// public static void selectFromDropDown(WebElement options, String value) {
	// Select dropDown = new Select(options);
	// dropDown.selectByVisibleText(value);
	// }

	public static void navigateToURL(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public static PageElement modifyPageElement(RepositoryParser repositoryParser, String pageName, String objectName,
			String... modificationStrings) {
		PageElement element = repositoryParser.getPageObject(pageName, objectName);
		PageElement modifiedElement = new PageElement(element);
		String locatorValue = modifiedElement.getLocatorValue();

		for (String modification : modificationStrings) {
			locatorValue = StringUtils.replaceOnce(locatorValue, "toModify", modification);
		}
		modifiedElement.setLocatorValue(locatorValue);
		return modifiedElement;
	}

	public static void setImplicitWait() {
		try {
			Thread.sleep(Constant.IMPLICIT_WAIT_TIME_IN_MILLIS);
		} catch (InterruptedException ie) {
		}
	}

	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException ie) {
		}
	}

	public static void actionSendData(WebDriver driver, WebElement element, String data) throws Exception {
		Actions act = new Actions(driver);
		Thread.sleep(3 * 1000);
		act.moveToElement(element).sendKeys(data).build().perform();

	}

	public static void dragDown(WebDriver driver, WebElement element, String data) {
		// Actions act = new Actions(driver);
		action.dragAndDropBy(element, 135, 40).build().perform();
	}

	// overide
	public static void dragDown(WebDriver driver, WebElement from, WebElement to, String data) {
		// Actions act = new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
	}

	public static String getRandomNumber() {
		int random = 1000000000 + (int) (Math.random() * 100000);
		mobileNumber = "" + random;
		return mobileNumber;
	}

}
