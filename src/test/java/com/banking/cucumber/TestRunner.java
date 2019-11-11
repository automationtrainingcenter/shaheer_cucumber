package com.banking.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestRunner {
	private WebDriver driver;

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/home.aspx");
		driver.manage().window().maximize();
	}

	public void login() {
		BankHomePage bankHomePageObj = new BankHomePage(driver);
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPassword("Admin");
		bankHomePageObj.clickLogin();
	}

	public void roleCreation() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		RoleDetailsPage roleDetailsPageObj = adminHomePageObj.clickRoles();
		RoleCreationPage roleCreationPageObj = roleDetailsPageObj.clickNewRole();

	}

	public void logoutAndClose() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePageObj.clickLogout();
		driver.close();
	}

	public void branchCreation() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		BranchDetailsPage branchDetailsPageObj = adminHomePageObj.clickBranches();
		BranchCreationPage branchCreationPageObj = branchDetailsPageObj.clickNewBranch();

	}

	public void empoloyeeCreation() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		EmpoloyeeDetailsPage empoloyeeDetailsPageObj = adminHomePageObj.clickEmployee();
		EmployeeCreationPage employeeCreationPageObj = empoloyeeDetailsPageObj.clickNewEmpoloyee();

	}

	public void branchCreationReset() {

	}

	public void branchCreationCancel() {

	}

	public void employeeCreationReset() {

	}

	public void employeeCreationCancel() {

	}

	public void roleCreationReset() {

	}

	public void roleCreationCancel() {

	}

	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.openBrowser();
		runner.login();
		runner.branchCreation();
		runner.roleCreation();
		runner.empoloyeeCreation();
		runner.logoutAndClose();

	}

}
