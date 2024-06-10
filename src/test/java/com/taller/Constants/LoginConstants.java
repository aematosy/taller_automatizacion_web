package com.taller.Constants;

import org.openqa.selenium.By;

public class LoginConstants {

    public static final By USERNAME_INPUT = By.name("userName");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By SUBMIT_BUTTON = By.name("submit");
    public static final By SUCCESS_MESSAGE = By.xpath("//h3[contains(text(),'Successfully')]");

}

