package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdminPage {
	private WebDriver driver;
	private By adminbtn = By.xpath("//b[contains(text(),'Admin')]");
	private By usermanagement = By.cssSelector("a#menu_admin_UserManagement");
	private By userslink = By.cssSelector("a#menu_admin_viewSystemUsers");
	private By searchbtn = By.xpath("//input[@id='searchBtn']");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonAdminbtn() {
		driver.findElement(adminbtn).click();
	}

	public void clicksonUsers() {
		WebElement user = driver.findElement(usermanagement);
		// Actions action=new Actions().moveToElement(user).build().perform();
		new Actions(driver).moveToElement(user).build().perform();
		driver.findElement(userslink).click();
	}

	public boolean searchbtnenable() {
		return driver.findElement(searchbtn).isEnabled();
	}

}
