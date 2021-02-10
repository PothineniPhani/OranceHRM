package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.LoginPage;
import util.ExcelReader;

public class AdminPageSteps {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AdminPage adminpage;

	@Given("user is logged into Application")
	public void user_is_logged_into_application(io.cucumber.datatable.DataTable apun) {
		List<Map<String, String>> clist = apun.asMaps();
		String username = clist.get(0).get("username");
		String password = clist.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		adminpage = loginpage.adminLogin(username, password);

	}

	@Given("user is on Adminpanel")
	public void user_is_on_adminpanel() {
		adminpage.clickonAdminbtn();
	}

	@When("user clicks on userslink")
	public void user_clicks_on_userslink() {
		adminpage.clicksonUsers();
		// System.out.println("UserLinkes");
	}

	@Then("verify select btn is enabled or not")
	public void verify_select_btn_is_enabled_or_not() {
		boolean b = adminpage.searchbtnenable();
		Assert.assertTrue(b);
	}

	@Then("verify reset btn is enabled or not")
	public void verify_reset_btn_is_enabled_or_not() {
		boolean b = adminpage.resetbtnenable();
		Assert.assertTrue(b);
	}

	@Then("verify Add btn is enabled or not")
	public void verify_add_btn_is_enabled_or_not() {
		boolean b = adminpage.addbtnenable();
		Assert.assertTrue(b);
	}

	@Given("user selects userRole")
	public void user_selects_user_role() {
		adminpage.selectemprole();
	}

	@Given("user selects Status of the employee")
	public void user_selects_status_of_the_employee() {
		adminpage.selectempstatus();
	}

	@Given("user clicks on search botton")
	public void user_clicks_on_search_botton() {
		adminpage.clickonsearchbtn();
	}

	@Given("user enters {string} in username fields")
	public void user_enters_in_username_fields(String suname) {
		adminpage.enteruname(suname);
	}

	@Given("user enters {string} in EmployeeName field")
	public void user_enters_in_employee_name_field(String semployeename) {
		adminpage.enterEmname(semployeename);
	}

	@Then("verify user is {string}")
	public void verify_user_is(String vname) throws InterruptedException {
		String name = adminpage.verifyusernames();
		Assert.assertTrue(name.contains(vname));
	}

	@Given("user clicks on Add button")
	public void user_clicks_on_add_button() {
		adminpage.userclicksonAdd();
	}

	@When("user fills form from given {string} and {int}")
	public void user_fills_form_from_given_and(String sheetName, Integer rownum)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(
				"C:\\Users\\Phani\\git\\Orance_HRM\\OrangeHRM\\src\\test\\resources\\config\\orangeHRM_scenarios.xlsx",
				sheetName);

		String urole = testdata.get(rownum).get("User Role");
		String ename = testdata.get(rownum).get("Employee Name");
		String uname = testdata.get(rownum).get("Username");
		String estatus = testdata.get(rownum).get("Status");
		String epassword = testdata.get(rownum).get("Password");
		String cepassword = testdata.get(rownum).get("Confirm Password");
		adminpage.formFilling(urole, ename, uname, estatus, epassword, cepassword);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		adminpage.userclicksonsavebtn();
	}

	@Then("it shows successfull message {string}")
	public void it_shows_successfull_message(String successMessage) {
		String b = adminpage.successmessage();
		Assert.assertEquals(b, successMessage);
	}

}
