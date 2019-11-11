package com.banking.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpoloyeeDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// new employee button
	@FindBy(how = How.ID, using = "BtnNew")
	private WebElement newEmployee;

	// constructor
	public EmpoloyeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// click new employee return EmployeeCreationPage
	public EmployeeCreationPage clickNewEmpoloyee() {
		wait.until(ExpectedConditions.elementToBeClickable(this.newEmployee)).click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}
}
