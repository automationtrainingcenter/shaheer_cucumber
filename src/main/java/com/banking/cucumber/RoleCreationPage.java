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

public class RoleCreationPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// role name
	@FindBy(how = How.ID, using = "txtRname")
	private WebElement roleName;

	// role type
	@FindBy(how = How.ID, using = "lstRtypeN")
	private WebElement roleType;

	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// constructor
	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// fill role name
	public void fillRoleName(String Anupriya) {
		wait.until(ExpectedConditions.visibilityOf(this.roleName)).sendKeys(Anupriya);
	}

	// select role type
	public void selectRoleType(String roleType) {
		WebElement sel = wait.until(ExpectedConditions.visibilityOf(this.roleType));
		Select sel1 = new Select(sel);
		sel1.selectByVisibleText(roleType);

	}

	// click submit returns Alert
	public Alert clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(this.submit)).click();
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	// click reset returns this
	public  RoleCreationPage clickReset() {
		wait.until(ExpectedConditions.elementToBeClickable(this.reset)).click();
		return this;
	}

	// click cancel returns RoleDetailsPage
	public RoleDetailsPage clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(this.cancel)).click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
}
