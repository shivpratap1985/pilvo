package com.appmodules.bank;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.automation.utils.PageHandler;
import com.automation.utils.RepositoryParser;
import com.pageobjects.elements.PlivoElement;

public class PlivoFlowExecuter {
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

			WebElement newPageTextbox = plivo.newPageName();
			newPageTextbox.sendKeys("Test_Shiv");

			WebElement createPageButton = plivo.createPageButton();
			createPageButton.click();

			WebElement messageTab = plivo.messageTab();
			messageTab.click();

			WebElement element = plivo.sendSMS();
			element.click();

			WebElement sms = plivo.sendSMS(); // where your canvas element is
			Actions builder = new Actions(driver);
			Action drawAction = builder.moveToElement(sms, 50, 50) // start point
					.click().moveByOffset(100, 60) // second point
					.doubleClick().build();
			drawAction.perform();

			WebElement phoneNumber = plivo.phoneNumber();
			phoneNumber.sendKeys(PageHandler.getRandomNumber());
			// Passing

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
