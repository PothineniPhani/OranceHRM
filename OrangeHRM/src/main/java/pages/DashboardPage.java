package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	private WebDriver driver;
	private By dashboardlist = By.cssSelector("div#dashboard-quick-launch-panel-container span");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getdashboardquicklanch() {
		return driver.findElements(dashboardlist).size();
	}

	public String getdashboardTitle() {
		return driver.getTitle();
	}

	public List<String> getdashboardqlanchList() {
		List<String> qlanchlist = new ArrayList<>();
		List<WebElement> qlanch = driver.findElements(dashboardlist);
		for (WebElement e : qlanch) {
			String Text = e.getText();
			qlanchlist.add(Text);
		}
		return qlanchlist;
	}

}
