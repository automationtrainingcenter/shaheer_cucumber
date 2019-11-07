package com.banking.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankHomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	// username
	public WebElement username() {
		WebElement uname = driver.findElement(By.id("txtuId"));
		return uname;
	}

	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement loginButton() {
		return driver.findElement(By.id("login"));
	}

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	// actions
	// fill user name
	public void fillUserName(String username) {
		wait.until(ExpectedConditions.visibilityOf(this.username())).sendKeys(username);
	}

	// fill password
	public void fillPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(this.password())).sendKeys(password);
	}

	// click login button
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(this.loginButton())).click();
	}

}
