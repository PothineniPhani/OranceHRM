package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\features" }, glue = { "stepdefinitions", "appHooks" }, plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/","rerun:rerun/failed_scenarios. txt" }, publish = true, monochrome = true,tags="@Login or @Admin")
public class MyTestRunner {

}
