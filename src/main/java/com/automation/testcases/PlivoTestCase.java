package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appmodules.bank.PlivoFlowExecuter;
import com.automation.utils.Constant;
import com.automation.utils.Log;
import com.automation.utils.PageHandler;
import com.automation.utils.RepositoryParser;

// import org.apache.log4j.xml.DOMConfigurator;

public class PlivoTestCase {
	WebDriver driver = null;
	RepositoryParser repositoryParser;

	@BeforeClass
	public void dataFetch() {
		repositoryParser = new RepositoryParser();
		repositoryParser.loadConfigProperties();
		repositoryParser.pageElementsLoader(Constant.PLIVO_LOCATOR_REPOSITORY);
	}

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void beforeMethod(String browser, String url) throws Exception {
		try {
			// DOMConfigurator.configure("log4j.xml");
			PageHandler pageHandler = new PageHandler();
			url = repositoryParser.getPropertyValue(url);
			driver = pageHandler.openBrowser(browser, url);
		} catch (Exception e) {
			Log.error("Browser could not be opened");
		} finally {
			Assert.assertTrue(driver != null);
		}
	}

	@Test
	public void bankTestExecution() {
		try {
			PlivoFlowExecuter plivoAutomation = new PlivoFlowExecuter();
			plivoAutomation.plivoLogin(driver, "Plivo", repositoryParser);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
