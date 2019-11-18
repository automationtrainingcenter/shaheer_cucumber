package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.banking.cucumber.AdminHomePage;
import com.banking.cucumber.BranchCreationPage;
import com.banking.cucumber.BranchDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class BranchSteps {
	private WebDriver driver;
	private CommonSteps commonSteps;
	private BranchDetailsPage branchDetailsPage;
	private BranchCreationPage branchCreationPage;

	public BranchSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = this.commonSteps.getDriver();
	}

	@Given("admin click branches button in admin home page")
	public void admin_click_branches_button_in_admin_home_page() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
	}

	@Given("admin click on new branch button in branch details page")
	public void admin_click_on_new_branch_button_in_branch_details_page() {
		branchCreationPage = branchDetailsPage.clickNewBranch();
	}

	@When("admin fills branch name as {string}")
	public void admin_fills_branch_name_as(String string) {
		branchCreationPage.fillBranchName(string);
	}

	@When("admin fills address{int} as {string}")
	public void admin_fills_address_as(Integer int1, String string) {
		branchCreationPage.fillAddress1(string);
	}

	@When("admin fills zipcode as {string}")
	public void admin_fills_zipcode_as(String string) {
		branchCreationPage.fillZipCode(string);
	}

	@When("admin selects country as {string}")
	public void admin_selects_country_as(String string) {
		branchCreationPage.selectCountry(string);
	}

	@When("admin selects state as {string}")
	public void admin_selects_state_as(String string) {
		branchCreationPage.selectState(string);
	}

	@When("admin selects city as {string}")
	public void admin_selects_city_as(String string) {
		branchCreationPage.selectCity(string);
	}

	@When("admin clicks on reset button in branch creation page")
	public void admin_clicks_on_reset_button_in_branch_creation_page() {
		branchCreationPage = branchCreationPage.clickReset();
	}

	@Then("admin can see an empty branch creation form")
	public void admin_can_see_an_empty_branch_creation_form() {
		Assert.assertTrue(branchCreationPage.isFormReset());
	}

	@When("admin fills branch creation form with valid data")
	public void admin_fills_branch_creation_form_with_valid_data(DataTable dataTable) throws InterruptedException {
		// for single row of data without heading use List<String>
		// for single row of data with heading use Map<String, String> here key is
		// heading and fields are values
		// for multiple rows of data without heading use List<List<String>>
		// for multiple rows of data with heading use List<Map<String, String>>
		List<String> fields = dataTable.asList();
		branchCreationPage.fillBranchName(fields.get(0));
		branchCreationPage.fillAddress1(fields.get(1));
		branchCreationPage.fillZipCode(fields.get(2));
		branchCreationPage.selectCountry(fields.get(3));
		branchCreationPage.selectState(fields.get(4));
		branchCreationPage.selectCity(fields.get(5));
		Thread.sleep(3000);
	}

	@When("admin fills branch name with invalid data so that it will display an error message")
	public void admin_fills_branch_name_with_invalid_data_so_that_it_will_display_an_error_message(
			DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<Map<String, String>> dataRows = dataTable.asMaps();
		for (Map<String, String> dataRow : dataRows) {
			branchCreationPage.fillBranchName(dataRow.get("branchName")+Keys.TAB);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(alert.getText());
			alert.accept();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
