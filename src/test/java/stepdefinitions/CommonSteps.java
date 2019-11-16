package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class CommonSteps extends BrowserHelper {

	private static boolean initilaized = false;

	@Before
	public void launch() {
		if (!initilaized) {
			openBrowser("chrome", "http://primusbank.qedgetech.com/");
			initilaized = true;
		}
	}

	@AfterStep
	public void afterStepEvent(Scenario scenario) {
		if (scenario.isFailed()) {
			String imgPath = ScreenshotHelper.captureScreenshot(driver, "screenshots", scenario.getName());
			File imgFile = new File(imgPath);
			try {
				scenario.embed(Files.toByteArray(imgFile), "image/png");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
//			byte[] img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(img, "image/png");
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
