package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	// ByLocators

	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By forgetpasswordlink = By.xpath("//a[contains(text(),'Forgot your password?')]");
	private By logo = By.cssSelector("body:nth-child(2) > div:nth-child(1)");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginpageTitle() {
		return driver.getTitle();
	}

	public boolean isforgetpasswordlistexist() {
		return driver.findElement(forgetpasswordlink).isDisplayed();
	}

	public void enterusername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void enterpassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickonlogin() {
		driver.findElement(loginBtn).click();
	}

	public boolean logoisdisplayed() {
		return driver.findElement(logo).isDisplayed();
	}

	public DashboardPage doLogin(String un, String pswd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(loginBtn).click();
		return new DashboardPage(driver);
	}
	
	public AdminPage adminLogin(String un,String pwd)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AdminPage(driver);
	}
	
	
}
