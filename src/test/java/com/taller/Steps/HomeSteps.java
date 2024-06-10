package com.taller.Steps;

import com.taller.Pages.*;
import com.taller.Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomeSteps extends Base {

    HomePage home = new HomePage(returnDriver());

    @Given("^The user is on home page$")
    public void home() {
        home.validateHomePage();
    }

    @And("^I click on \"Register\" option$")
    public void clickRegister(){
        home.clickRegisterOption();
    }
}
