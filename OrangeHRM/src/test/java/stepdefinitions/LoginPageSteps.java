package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}
	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		String title = loginpage.getLoginpageTitle();
		System.out.println("Login page Title is ::" + title);
	}
	@Then("page title should be {string}")
	public void page_title_should_be(String loginpageTitle) {
		String title = loginpage.getLoginpageTitle();
		Assert.assertTrue(title.contains(loginpageTitle));
	}
	@Then("forget password link should be displayed")
	public void forget_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isforgetpasswordlistexist());
	}
	@When("user enters username {string}")
	public void user_enters_username(String un) {
		loginpage.enterusername(un);
	}
	@When("user enters password {string}")
	public void user_enters_password(String ps) {
		loginpage.enterpassword(ps);
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clickonlogin();
	}
	@Then("Logo should be displayed")
	public void Logo_should_be_displayed() {
		loginpage.logoisdisplayed();
	}

}
