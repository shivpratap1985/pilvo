package com.pageobjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utils.PageHandler;
import com.automation.utils.RepositoryParser;

public class PlivoElement extends PageHandler {

	public PlivoElement(WebDriver driver, String pageName, RepositoryParser repositoryParser) {
		this.driver = driver;
		this.repositoryParser = repositoryParser;
		this.pageName = pageName;
	}

	public WebElement createApp() {
		return findElement("createApp");
	}

	public WebElement startApp() {
		return findElement("startApp");
	}

	public WebElement addNewPage() {
		WebElement element = findElement("addNewPage");
		return element;
	}

	public WebElement newPageName() {
		return findElement("NewPageName");
	}

	public WebElement createPageButton() {
		return findElement("createPageButton");
	}

	public WebElement messageTab() {
		return findElement("messageTab");
	}

	public WebElement sendSMS() {
		return findElement("sendSMS");
	}

	public WebElement phoneNumber() {
		return findElement("phoneNumber");
	}

	public WebElement textmessage() {
		return findElement("textmessage");
	}

}
