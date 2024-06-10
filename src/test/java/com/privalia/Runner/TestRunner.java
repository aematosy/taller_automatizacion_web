package com.privalia.Runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "com.privalia",
		tags = "@register_login",
		plugin = {"pretty",
				  "summary",
				  "html:target/cucumber-reports/html-report.html",
				  "json:target/cucumber-reports/cucumber.json",
				  "junit:target/cucumber-reports/cucumber.xml",
				  "timeline:target/cucumber-timeline",
				  "rerun:target/failedrerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome = false,
		dryRun = false,
		publish = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeMethod(alwaysRun = true)
	public void test() {
	}

	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
