package com.privalia.Steps;

import com.privalia.Pages.*;
import com.privalia.Utils.Base;
import com.privalia.Utils.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeSteps extends Base {

    HomePage home = new HomePage(returnDriver());

    @Given("^The user is on home page$")
    public void home() {
        home.navegarWeb();
    }

    @And("^I click on \"Register\" option$")
    public void clickRegister() throws InterruptedException {
        home.clickRegisterOption();
    }
}
