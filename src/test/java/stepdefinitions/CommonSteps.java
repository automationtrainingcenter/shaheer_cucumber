package stepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.BrowserHelper;

public class CommonSteps extends BrowserHelper {

	private static boolean initilaized = false;

	@Before
	public void launch() {
		if (!initilaized) {
			openBrowser("chrome", "http://primusbank.qedgetech.com/");
			initilaized = true;
		}
	}

	@After
	public void close() {
		closeBrowser();
		initilaized = false;
	}

	// return driver instance
	public WebDriver getDriver() {
		return this.driver;
	}
}
