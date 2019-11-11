package com.banking.cucumber;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeCreationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	// emp name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement empName;

	// login pass
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement loginPass;

	// role
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement role;

	// branch
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement branch;

	// submit
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement submit;
	// reset
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement cancel;

	// constructor
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// fill emp name
	public void fillEmpName(String Anupriya) {
		wait.until(ExpectedConditions.visibilityOf(this.empName)).sendKeys(Anupriya);

	}

	// fill login pass
	public void fillLoginPass(String password) {
		wait.until(ExpectedConditions.visibilityOf(this.loginPass)).sendKeys(password);
	}

	// select role
	public void selectRole(String role) {
		WebElement se13 = wait.until(ExpectedConditions.visibilityOf(this.role));
		Select sel33 = new Select(se13);
		sel33.selectByVisibleText(role);
	}

	// select branch
	public void selectBranch(String branch) {
		WebElement se13 = wait.until(ExpectedConditions.visibilityOf(this.branch));
		Select sel33 = new Select(se13);
		sel33.selectByVisibleText(branch);
	}

	// click submit returns Alert
	public Alert clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(this.submit)).click();
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	// click reset returns this
	public EmployeeCreationPage clickReset() {
		wait.until(ExpectedConditions.elementToBeClickable(this.reset)).click();
		return this;
	}

	// click cancel returns EmployeeDetailsPage
	public EmpoloyeeDetailsPage clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(this.cancel)).click();
		return PageFactory.initElements(driver, EmpoloyeeDetailsPage.class);
	}

}
