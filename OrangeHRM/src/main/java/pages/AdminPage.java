package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	private WebDriver driver;
	private By adminbtn = By.xpath("//b[contains(text(),'Admin')]");
	private By usermanagement = By.cssSelector("a#menu_admin_UserManagement");
	private By userslink = By.cssSelector("a#menu_admin_viewSystemUsers");
	private By searchbtn = By.xpath("//input[@id='searchBtn']");
	private By resetbtn = By.xpath("//input[@id='resetBtn']");
	private By Addbtn = By.xpath("//input[@id='btnAdd']");

	private By userrole = By.xpath("//select[@id='searchSystemUser_userType']");
	private By userStatus = By.xpath("//select[@id='searchSystemUser_status']");
	private By usrname = By.xpath("//input[@id='searchSystemUser_userName']");
	private By empname = By.xpath("//input[@id='searchSystemUser_employeeName_empName']");
	private By verifyname = By.xpath("//div[@id='tableWrapper']//table//tbody//td//a[contains(text(),'Alice Duval')]");
	private By savebtn = By.xpath("//input[@id='btnSave']");
	private By successBtn = By.xpath("//div[@id='successBodyEdit']");
	private By euserRole = By.xpath("//select[@id='systemUser_userType']");
	private By empnames = By.xpath("//input[@id='systemUser_employeeName_empName']");
	private By eusername = By.xpath("//input[@id='systemUser_userName']");
	private By estatus = By.xpath("//select[@id='systemUser_status']");
	private By epassword = By.xpath("//input[@id='systemUser_password']");
	private By ecpassword = By.xpath("//input[@id='systemUser_confirmPassword']");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonAdminbtn() {
		driver.findElement(adminbtn).click();
	}

	public void clicksonUsers() {
		WebElement user = driver.findElement(usermanagement);
		new Actions(driver).moveToElement(user).build().perform();
		driver.findElement(userslink).click();
	}

	public boolean searchbtnenable() {
		return driver.findElement(searchbtn).isEnabled();
	}

	public boolean resetbtnenable() {
		return driver.findElement(resetbtn).isEnabled();
	}

	public boolean addbtnenable() {
		return driver.findElement(Addbtn).isEnabled();
	}

	public void clickonsearchbtn() {
		driver.findElement(searchbtn).click();
	}

	public void enteruname(String uname) {
		driver.findElement(usrname).sendKeys(uname);

	}

	public void enterEmname(String Empname) {
		driver.findElement(empname).sendKeys(Empname);
	}

	public void selectemprole() {
		WebElement webelement = driver.findElement(userrole);
		Select s = new Select(webelement);
		s.selectByIndex(1);
	}

	public void selectempstatus() {
		WebElement statuemp = driver.findElement(userStatus);
		Select s = new Select(statuemp);
		s.selectByIndex(0);
	}

	public String verifyusernames() throws InterruptedException {
		driver.wait(2000);
		return driver.findElement(verifyname).getText();
	}

	public void userclicksonAdd() {
		driver.findElement(Addbtn).click();
	}

	public void userclicksonsavebtn() {
		driver.findElement(savebtn);
	}

	public String successmessage() {
		return driver.findElement(successBtn).getText();
	}

	public void formFilling(String userRole, String EmployeeName, String Username, String Status, String password,
			String confrmPassword) {
		Select select = new Select(driver.findElement(euserRole));
		select.selectByVisibleText(userRole);
		driver.findElement(empnames).sendKeys(EmployeeName);
		driver.findElement(eusername).sendKeys(Username);
		Select s1 = new Select(driver.findElement(estatus));
		s1.selectByVisibleText(Status);
		driver.findElement(epassword).sendKeys(password);
		driver.findElement(ecpassword).sendKeys(confrmPassword);
	}

}
