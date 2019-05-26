package com.pipeline.testbase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.pipeline.utilities.BrowserManager;
import com.pipeline.utilities.ConfigReader;

public class TestBase {

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	protected String configFilePath = PROJECT_PATH + "/src/main/resources/";

	protected ConfigReader config;
	protected BrowserManager browserManager;
	protected String hubUrl;
	protected String browserFlag;

	@BeforeSuite
	public void beforeTestSuite() {
		config = new ConfigReader(configFilePath, "config.properties");
	}

	@BeforeClass
	public void beforeTestClasses() {
		browserManager = new BrowserManager();
	}

}