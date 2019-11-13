package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
	 protected WebDriver driver;

	/*
	 * this method accepts folder name which is a folder in your project root folder and 
	 * driver name, returns path of the driver executable file irrespective of the OS
	 */
	private String getDriverPath(String folderName, String driverName) {
		String os = System.getProperty("os.name").toLowerCase();
		String rootFolder = System.getProperty("user.dir");
		String driverPath;
		if (os.contains("win")) {
			driverPath = rootFolder + File.separator + folderName + File.separator + driverName + ".exe";
		} else {
			driverPath = rootFolder + File.separator + folderName + File.separator + driverName;
		}
		return driverPath;
	}


	// launch browser
	public void openBrowser(String browserName, String url) {
		browserName = browserName.toLowerCase();
		if (browserName.equals("chrome")) {
//			setSystemProperty("chromedriver", "drivers");
			System.setProperty("webdriver.chrome.driver", getDriverPath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", getDriverPath("drivers", "geckodriver"));
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	// close browser
	public void closeBrowser() {
		if(driver.getWindowHandles().size()>1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
