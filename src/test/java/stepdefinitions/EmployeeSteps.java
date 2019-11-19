package stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.banking.cucumber.AdminHomePage;
import com.banking.cucumber.EmployeeCreationPage;
import com.banking.cucumber.EmpoloyeeDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import pojo.Employee;
import utilities.GenericHelper;

public class EmployeeSteps {
	private WebDriver driver;
	private CommonSteps commonSteps;
	private EmpoloyeeDetailsPage employeeDetailsPage;
	private EmployeeCreationPage employeeCreationPage;

	public EmployeeSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = commonSteps.getDriver();
	}

	@Given("admin click employee button in admin home page")
	public void admin_click_employee_button_in_admin_home_page() {
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		employeeDetailsPage = adminHomePage.clickEmployee();
	}

	@Given("admin click on new employee button in employee details page")
	public void admin_click_on_new_employee_button_in_employee_details_page() {
		employeeCreationPage = employeeDetailsPage.clickNewEmpoloyee();
	}

	@When("admin clicks reset button after filling data")
	public void admin_clicks_reset_button_after_filling_data(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> rows = dataTable.asMaps();
		for (Map<String, String> row : rows) {
			employeeCreationPage.fillEmpName(row.get("empName"));
			employeeCreationPage.fillLoginPass(row.get("loginPass"));
			employeeCreationPage.selectRole(row.get("role"));
			employeeCreationPage.selectBranch(row.get("branch"));
			employeeCreationPage.clickReset();
			Thread.sleep(2000);

		}
	}

	@When("admin clicks reset button after filling data from JSON file")
	public void admin_clicks_reset_button_after_filling_data_from_JSON_file() {
		Gson gson = new Gson();
		FileInputStream fis;
		try {
			fis = new FileInputStream(GenericHelper.getFilePath("resources", "employeeData.json"));
			InputStreamReader ireader = new InputStreamReader(fis);
			Employee[] emploies = gson.fromJson(ireader, Employee[].class);
			for (Employee employee : emploies) {
				employeeCreationPage.fillEmpName(employee.getEmp_name());
				employeeCreationPage.fillLoginPass(employee.getLogin_pass());
				employeeCreationPage.selectRole(employee.getRole());
				employeeCreationPage.selectBranch(employee.getBranch());
				employeeCreationPage.clickReset();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("admin click reset buttion after filling data from excel file")
	public void admin_click_reset_buttion_after_filling_data_from_excel_file(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Excel> excel = dataTable.asList(Excel.class);
		Excel excelFile = excel.get(0);
		List<List<String>> excelData = excelFile.getExcelData();
		for (List<String> row : excelData) {
			employeeCreationPage.fillEmpName(row.get(0));
			employeeCreationPage.fillLoginPass(row.get(1));
			employeeCreationPage.selectRole(row.get(2));
			employeeCreationPage.selectBranch(row.get(3));
			employeeCreationPage.clickReset();
			Thread.sleep(2000);
		}
	}
}
