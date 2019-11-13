package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.banking.cucumber.AdminHomePage;
import com.banking.cucumber.BankHomePage;
import com.banking.cucumber.RoleCreationPage;
import com.banking.cucumber.RoleDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleSteps {
	private WebDriver driver;
	private CommonSteps commonSteps;
	private RoleDetailsPage roleDetailsPage;
	private RoleCreationPage roleCreationPage;
	private Alert alert;
	
	public RoleSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = commonSteps.getDriver();
	}

	@Given("admin do login with valid credentials")
	public void admin_do_login_with_valid_credentials() {
		BankHomePage bankHomePage = new BankHomePage(driver);
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLogin();
	}

	@Given("admin click roles button in admin home page")
	public void admin_click_roles_button_in_admin_home_page() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		roleDetailsPage = adminHomePage.clickRoles();
	}

	@Given("admin click on new role button in role details page")
	public void admin_click_on_new_role_button_in_role_details_page() {
		roleCreationPage = roleDetailsPage.clickNewRole();
	}

	@When("admin enters role name as {string}")
	public void admin_enters_role_name_as(String string) {
		roleCreationPage.fillRoleName(string);
	}

	@When("admin selects role type as {string}")
	public void admin_selects_role_type_as(String string) {
		roleCreationPage.selectRoleType(string);
	}

	@When("admin clicks on submit button")
	public void admin_clicks_on_submit_button() {
		alert = roleCreationPage.clickSubmit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("admin can see role created successfully with some id message")
	public void admin_can_see_role_created_successfully_with_some_id_message() {
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("new role"));
	}
}
