package com.taller.Utils;

import java.util.Properties;
import com.taller.listeners.validator.AdValidator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	private static WebDriver driver;
	private Properties prop;
	private Base driverBase;
	private AdValidator adValidator;

	@Before
	public void setup() throws Throwable {
		prop = Reader.getAllProperties();
		driverBase = new Base();
		driver = driverBase.loadDriver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

		adValidator = new AdValidator();
		adValidator.validate(null, driver);

	}

	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		String valorDriver = "" + driver;
		if (valorDriver.contains("null")) {
			driverBase = new Base();
			driver = driverBase.loadDriver("null");
		}
		try {
			String screenName = scenario.getName().replaceAll(" ", "_");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenName);
		} finally {
			Reader.cleanUp();
			driver.quit();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		// This method runs before each test method
	}

	@AfterMethod
	public void afterMethod() {
		// This method runs after each test method
	}

	@BeforeStep
	public void beforeStep() {
		// This method runs before each step in scenario
	}
}

