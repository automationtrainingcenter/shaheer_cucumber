package com.banking.cucumber;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.JavascriptHelper;

public class BranchCreationPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// branch name
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;

	// address
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address;

	// zipcode
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zipCode;

	// country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;

	// state
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;

	// city
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;

	// submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// constructor
	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// fill branch name
	public void fillBranchName(String branchName) {
		wait.until(ExpectedConditions.visibilityOf(this.branchName)).clear();
		this.branchName.sendKeys(branchName);

	}

	// fill address1
	public void fillAddress1(String address) {
		wait.until(ExpectedConditions.visibilityOf(this.address)).sendKeys(address);
	}

	// fill zipcode
	public void fillZipCode(String zipCode) {
		wait.until(ExpectedConditions.visibilityOf(this.zipCode)).sendKeys(String.valueOf(50030));
	}

	// select country
	public void selectCountry(String country) {
		WebElement sel = wait.until(ExpectedConditions.visibilityOf(this.country));
		Select sel1 = new Select(sel);
		sel1.selectByVisibleText(country);

	}

	// select state
	public void selectState(String state) {
		WebElement sel2 = wait.until(ExpectedConditions.visibilityOf(this.state));
		Select sel22 = new Select(sel2);
		sel22.selectByVisibleText(state);

	}

	// select city
	public void selectCity(String city) {
		WebElement sel2 = wait.until(ExpectedConditions.visibilityOf(this.city));
		Select sel22 = new Select(sel2);
		sel22.selectByVisibleText(city);

	}

	// click submit returns Alert
	public Alert clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(this.submit)).click();
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	// click reset returns this
	public BranchCreationPage clickReset() {
		wait.until(ExpectedConditions.elementToBeClickable(this.reset)).click();
		return this;
	}

	// click cancel returns BranchDetailsPage
	public BranchDetailsPage clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(this.cancel)).click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// isFormReset() which return true if form reset
	public boolean isFormReset() {
		return JavascriptHelper.getEditBoxText(driver, this.branchName).isEmpty() && JavascriptHelper.getEditBoxText(driver, this.zipCode).isEmpty();
	}
}
