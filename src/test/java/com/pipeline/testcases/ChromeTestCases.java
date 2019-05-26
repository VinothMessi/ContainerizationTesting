package com.pipeline.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pipeline.testbase.TestBase;

import org.testng.AssertJUnit;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTestCases extends TestBase {

	RemoteWebDriver CHbrowser;

	@BeforeMethod
	public void before_Each_TestCase() throws MalformedURLException {
		CHbrowser = browserManager.launch("Chrome", false, "http://192.168.119.128:4444/wd/hub");
	}

	@Test
	public void verifyGooglePage() {
		CHbrowser.get("https://google.com");
		String pageTitle = CHbrowser.getTitle();
		AssertJUnit.assertTrue(pageTitle.equals("Google"));
	}

	@Test
	public void verifySeleniumPage() {
		CHbrowser.get("https://www.seleniumhq.org/");
		String pageTitle = CHbrowser.getTitle();
		AssertJUnit.assertTrue(pageTitle.equals("Selenium - Web Browser Automation"));
	}

	@AfterMethod
	public void after_Each_TestCase() {
		CHbrowser.quit();
	}
}