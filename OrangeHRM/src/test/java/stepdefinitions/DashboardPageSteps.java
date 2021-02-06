package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardPageSteps {
	public LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private DashboardPage dashboardpage;	

	@Given("the user is logged in the application")
	public void the_user_is_logged_in_the_application(io.cucumber.datatable.DataTable uspasw) {
		List<Map<String, String>> clist = uspasw.asMaps();
		String username = clist.get(0).get("username");
		String password = clist.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		dashboardpage = loginpage.doLogin(username, password);

	}
	@Given("user is on Dashboard page")
	public void user_is_on_dashboard_page() {
		dashboardpage.getdashboardTitle();
		}
		
	@Then("page dashboardtitle should be {string}")
	public void page_dashboardtitle_should_be(String dbt) {
	   String dbtitle=dashboardpage.getdashboardTitle();
	   Assert.assertTrue(dbtitle.contains(dbt));
	}
	
	
	@Then("user gets quicklanch section")
	public void user_gets_quicklanch_section(io.cucumber.datatable.DataTable dashboardtable) {
		List<String> expecteddashboardlist = dashboardtable.asList();
		System.out.println("Expected Dashboard Quick Lanch :" + expecteddashboardlist);
		List<String> actualList = dashboardpage.getdashboardqlanchList();
		System.out.println("Actula List :" + actualList);

		Assert.assertTrue(expecteddashboardlist.containsAll(actualList));
	}

	@Then("quicklauch section should be {int}")
	public void quicklauch_section_should_be(Integer actualqcount) {
		Assert.assertTrue(dashboardpage.getdashboardquicklanch() == actualqcount);
	}
	
}
