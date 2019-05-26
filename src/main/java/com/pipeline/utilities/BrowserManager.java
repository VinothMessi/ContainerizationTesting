package com.pipeline.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserManager {

	RemoteWebDriver lbrowser;

	public RemoteWebDriver launch(String browserName, boolean flag, String hubURL) throws MalformedURLException {
		switch (browserName) {
		case "Chrome":
			ChromeOptions chOptions = new ChromeOptions();
			chOptions.setCapability("OS", Platform.LINUX);
			chOptions.setHeadless(flag);
			lbrowser = new RemoteWebDriver(new URL(hubURL), chOptions);
			break;
		case "Firefox":
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setCapability("OS", Platform.LINUX);
			ffOptions.setHeadless(flag);
			lbrowser = new RemoteWebDriver(new URL(hubURL), ffOptions);
			break;
		default:
			System.out.println("Browser type not supported");
			break;
		}
		lbrowser.manage().window().maximize();
		return lbrowser;
	}
}