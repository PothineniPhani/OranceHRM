package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;

	@Before(order = 0)
	public void getPropertie() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browsername);
	}

	@After(order = 0)
	public void quitbrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void teardown(Scenario sc) {
		if (sc.isFailed()) {
			// take screenshot
			String screenshotname = sc.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenshotname);
		}
	}

}
