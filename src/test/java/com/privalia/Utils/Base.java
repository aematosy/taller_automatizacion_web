package com.privalia.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Base {

	public static final int TIME_OUT = 30;
	public static final int TIME_EXPECTED_CONDITIONS = 10;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver loadDriver(String browser) {

		switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup(); // Configura el ChromeDriver
				ChromeOptions chromeOptions = new ChromeOptions();
				configureOptions(chromeOptions);
				driver.set(new ChromeDriver(chromeOptions));
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup(); // Configura el GeckoDriver para Firefox
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				configureOptions(firefoxOptions);
				driver.set(new FirefoxDriver(firefoxOptions));
				break;

			case "edge":
				WebDriverManager.edgedriver().setup(); // Configura el EdgeDriver
				EdgeOptions edgeOptions = new EdgeOptions();
				configureOptions(edgeOptions);
				driver.set(new EdgeDriver(edgeOptions));
				break;

			case "null":
				WebDriverManager.chromedriver().setup(); // Configura el ChromeDriver en modo headless
				ChromeOptions headlessOptions = new ChromeOptions();
				headlessOptions.addArguments("--headless");
				configureOptions(headlessOptions);
				driver.set(new ChromeDriver(headlessOptions));
				break;

			default:
				System.out.println("Undefined Browser");
				return null;
		}

		WebDriver webDriver = returnDriver();
		configureDriver(webDriver);
		return webDriver;
	}

	// Método para configurar las opciones de Chrome
	private void configureOptions(ChromeOptions options) {
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("user-agent=t35t1t3r4;BOT/v1");
		options.addArguments("--disable-gpu");
		options.addArguments("enable-features=NetworkServiceInProcess");
		options.addArguments("--disable-browser-side-navigation");
	}

	// Método para configurar las opciones de Firefox
	private void configureOptions(FirefoxOptions options) {
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("user-agent=t35t1t3r4;BOT/v1");
		options.addArguments("--disable-gpu");
		options.addArguments("enable-features=NetworkServiceInProcess");
		options.addArguments("--disable-browser-side-navigation");
	}

	// Método para configurar las opciones de Edge
	private void configureOptions(EdgeOptions options) {
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("user-agent=t35t1t3r4;BOT/v1");
		options.addArguments("--disable-gpu");
		options.addArguments("enable-features=NetworkServiceInProcess");
		options.addArguments("--disable-browser-side-navigation");
	}

	// Método para configurar el WebDriver con configuraciones comunes
	private void configureDriver(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIME_OUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_EXPECTED_CONDITIONS));
	}

	// Método para obtener el WebDriver actual
	public static synchronized WebDriver returnDriver() {
		return driver.get();
	}
}
