package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.banking.cucumber.AdminHomePage;
import com.banking.cucumber.BankHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	private WebDriver driver;
	private BankHomePage bankHomePage;
	private CommonSteps commonSteps;

	public LoginSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = commonSteps.getDriver();
	}

	@Given("admin is in bank home page")
	public void admin_is_in_bank_home_page() {
		bankHomePage = new BankHomePage(driver);
	}

	@When("admin enters valid user name")
	public void admin_enters_valid_user_name() {
		bankHomePage.fillUserName("Admin");
	}

	@When("admin enters valid password")
	public void admin_enters_valid_password() {
		bankHomePage.fillPassword("Admin");
	}

	@When("admin click on login button")
	public void admin_click_on_login_button() {
		bankHomePage.clickLogin();
	}

	@Then("admin cas see welcome to Admin message with logout link")
	public void admin_cas_see_welcome_to_Admin_message_with_logout_link() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.logoutIsDisplayed());
	}

	@When("admin enters invalid password")
	public void admin_enters_invalid_password() {
		bankHomePage.fillPassword("adsaldfjha");
	}

	@Then("admin can see an error message saying invalid banker name or password")
	public void admin_can_see_an_error_message_saying_invalid_banker_name_or_password() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("incorrect"));
	}

	@When("admin enters invalid username")
	public void admin_enters_invalid_username() {
		bankHomePage.fillUserName("adfasfsadf");
	}

	@Then("admin can see an error message saying please fill banker and password")
	public void admin_can_see_an_error_message_saying_please_fill_banker_and_password() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("please fill"));
	}
}
