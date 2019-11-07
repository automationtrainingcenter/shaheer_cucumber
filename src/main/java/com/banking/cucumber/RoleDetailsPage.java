package com.banking.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoleDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// new role button
	@FindBy(how = How.ID, using = "btnRoles")
	private WebElement newRole;

	// constructor
	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// click new role button
	public RoleCreationPage clickNewRole() {
		wait.until(ExpectedConditions.elementToBeClickable(this.newRole)).click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}

}
