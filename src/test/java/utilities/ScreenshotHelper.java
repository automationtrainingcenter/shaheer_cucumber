package utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(" dd_MMM_yy HH-mm-ss");
		return df.format(date);
	}
	
	private static String getPath(String folderName, String fileName) {
		String rootFolder = System.getProperty("user.dir");
		return rootFolder + File.separator + folderName + File.separator + fileName+getTimeStamp()+".png";
	}

	// helper method to capture the screenshot
	public static String captureScreenshot(WebDriver driver, String folderName, String fileName) {
		// type cast webdriver object reference to TakesScreenshot interface reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File desImg = new File(getPath(folderName, fileName));
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", desImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desImg.getAbsolutePath();
	}
	
	// helper method for multiple screenshots
	public static void captureMultipleScreenshots(WebDriver driver, String folderName, String fileName) {
		// type cast WebDriver object reference to JavaScriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// find the scroll height
		long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
		// find the view height
		long viewHeight = (long) js.executeScript("return document.documentElement.clientHeight");
		// type cast WebDriver object reference to TakesScreenshot interface reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		// iterate until scroll height is greater than or equal to 0
		while(scrollHeight >= 0) {
			captureScreenshot(driver, folderName, fileName);
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", viewHeight);
			scrollHeight -= viewHeight;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	// helper method for  alert screenshot
	public static void alertScreenCapture(String folderName, String fileName) {
		// create Robot class object
		try {
			Robot r = new Robot();
			Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(size);
			BufferedImage bi = r.createScreenCapture(rect);
			ImageIO.write(bi, "png", new File(getPath(folderName, fileName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
