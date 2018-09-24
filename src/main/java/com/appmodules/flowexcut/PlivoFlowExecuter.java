package com.appmodules.flowexcut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.automation.utils.Log;
import com.automation.utils.PageHandler;
import com.automation.utils.RepositoryParser;
import com.pageobjects.elements.PlivoElement;

public class PlivoFlowExecuter {

	static Logger log = LogManager.getLogger(PlivoFlowExecuter.class.getName());
	public static Actions action;
	public static WebDriver driver;
	public static String mobileNumber;

	public void plivoLogin(WebDriver driver, String pageName, RepositoryParser repositoryParser) {

		Actions act = new Actions(driver);
		try {
			PlivoElement plivo = new PlivoElement(driver, pageName, repositoryParser);

			WebElement createApp = plivo.createApp();
			createApp.click();

			WebElement startAppButton = plivo.startApp();
			startAppButton.click();

			WebElement newPage = plivo.addNewPage();
			newPage.click();

			try {
				WebElement newPageTextbox = plivo.newPageName();
				newPageTextbox.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='Shivtest';", newPageTextbox);
			} catch (Exception e) {

			}

			WebElement createPageButton = plivo.createPageButton();
			createPageButton.click();

			WebElement messageTab = plivo.messageTab();
			messageTab.click();

			WebElement element = plivo.sendSMS();
			element.click();

			WebElement wb = driver.findElement(By.xpath("//div[@id='tabs-2']//div[@class='mod-rail mod-south']/div"));
			// WebElement sms = plivo.sendSMS(); // where your canvas element is
			Actions builder = new Actions(driver);
			Action drawAction = builder.moveToElement(wb, 6, 50) // start point
					.click().moveByOffset(100, 60) // second point
					.doubleClick().build();
			drawAction.perform();

			WebElement phoneNumber = plivo.phoneNumber();
			phoneNumber.sendKeys(PageHandler.getRandomNumber());
			// Passing

		} catch (Exception e) {
			Log.error("Flow break" + e);
		}
	}
}
