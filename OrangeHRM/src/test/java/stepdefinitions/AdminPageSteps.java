package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.LoginPage;

public class AdminPageSteps {
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private AdminPage adminpage;

	@Given("user is logged into Application")
	public void user_is_logged_into_application(io.cucumber.datatable.DataTable apun) {
		List<Map<String, String>> clist = apun.asMaps();
		String username = clist.get(0).get("username");
		String password = clist.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		loginpage.adminLogin(username, password);

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
		System.out.println("Search Box");

	}

}
