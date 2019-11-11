package com.banking.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BranchDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// new branch
	@FindBy(how = How.ID, using = "BtnNewBR")
	private WebElement newBranch;

	// constructor
	public BranchDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

	}

	// click new branch button returns BranchCreationPage
	public BranchCreationPage clickNewBranch() {
		wait.until(ExpectedConditions.elementToBeClickable(this.newBranch)).click();
		return PageFactory.initElements(driver, BranchCreationPage.class);

	}

}
