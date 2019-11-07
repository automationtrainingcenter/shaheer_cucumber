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

	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.openBrowser();
		runner.login();
		runner.roleCreation();
		runner.logoutAndClose();
	}

}
