package com.banking.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	// home button
	@FindBy(xpath = "//a[@href = 'adminflow.aspx']")
	private WebElement home;

	// change password
	@FindBy(how = How.CSS, using = "a[href='change_password.aspx']")
	private WebElement changePass;

	// logout
	@FindBy(how = How.CSS, using = "a[href='http://primusbank.qedgetech.com']")
	private WebElement logout;

	// branches
	@FindBy(how = How.CSS, using = "a[href='admin_banker_master.aspx']")
	private WebElement branches;

	// roles
	@FindBy(how = How.CSS, using = "a[href='Admin_Roles_details.aspx']")
	private WebElement roles;

	// employees
	@FindBy(how = How.CSS, using = "a[href='Admin_Emp_details.aspx']")
	private WebElement employees;

	// users
	@FindBy(how = How.CSS, using = "a[href='userdetails.aspx']")
	private WebElement users;

	// constructor
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// click home button
	public AdminHomePage clickHome() {
		wait.until(ExpectedConditions.elementToBeClickable(this.home)).click();
		return this;
	}

	// click logout button
	public BankHomePage clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(this.logout)).click();
		return PageFactory.initElements(driver, BankHomePage.class);
	}

	// click changepassword button
//	public void clickChangePassword() {
//		wait.until(ExpectedConditions.elementToBeClickable(this.changePass)).click();
//	}

	// click branches button
	public BranchDetailsPage clickBranches() {
		wait.until(ExpectedConditions.elementToBeClickable(this.branches)).click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// click roles button
	public RoleDetailsPage clickRoles() {
		wait.until(ExpectedConditions.elementToBeClickable(this.roles)).click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click employee button
	public EmpoloyeeDetailsPage clickEmployee() {
		wait.until(ExpectedConditions.elementToBeClickable(this.employees)).click();
		return PageFactory.initElements(driver, EmpoloyeeDetailsPage.class);
	}

	// click users button
	public void clickUsers() {
		wait.until(ExpectedConditions.elementToBeClickable(this.users)).click();
	}
	
	// verify admin home page is dispalyed or  not
	public boolean logoutIsDisplayed() {
		return this.logout.isDisplayed();
	}

}
