package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
	// helper method to bring the text of a text field
	public static String getEditBoxText(WebDriver driver, WebElement editBox) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", editBox).toString();
	}

	// helper method to scroll an element into the view
	public static void scrollElementToView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	// helper method to scroll page either up or down
	public static void scrollPage(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
	}
	
	// helper method to execute any javascript code
	public static Object executeJavaScript(WebDriver driver, String script, Object... arguments) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript(script, arguments);
	}
	
}
