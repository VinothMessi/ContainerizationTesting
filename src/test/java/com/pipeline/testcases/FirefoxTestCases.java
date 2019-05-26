package com.pipeline.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pipeline.testbase.TestBase;

import org.testng.AssertJUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxTestCases extends TestBase {

	RemoteWebDriver browser;

	@BeforeMethod
	public void before_Each_TestCase() throws MalformedURLException {
		browser = browserManager.launch("Firefox", false, "http://localhost:4444/wd/hub");
	}

	@Test
	public void verifyGooglePage() {
		browser.get("https://google.com");
		String pageTitle = browser.getTitle();
		AssertJUnit.assertTrue(pageTitle.equals("Google"));
	}

	@Test
	public void verifySeleniumPage() {
		browser.get("https://www.seleniumhq.org/");
		String pageTitle = browser.getTitle();
		AssertJUnit.assertTrue(pageTitle.equals("Selenium - Web Browser Automation"));
	}

	@AfterMethod
	public void after_Each_TestCase() {
		browser.quit();
	}
}