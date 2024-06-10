package com.taller.Steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.taller.Pages.LoginPage;
import com.taller.Utils.Base;
import io.cucumber.datatable.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.taller.Utils.Excel;
import com.taller.Utils.Reader;
import com.taller.Utils.CucumberNewUtil;
import freemarker.core.ParseException;
 
public class LoginSteps extends Base {

	LoginPage login = new LoginPage(returnDriver());


	

}
