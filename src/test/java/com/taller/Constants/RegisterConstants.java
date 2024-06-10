package com.taller.Constants;

import org.openqa.selenium.By;

public class RegisterConstants {

    public static final By FIRSTNAME_INPUT = By.name("firstName");
    public static final By LASTNAME_INPUT = By.name("lastName");
    public static final By PHONE_INPUT = By.name("phone");
    public static final By EMAIL_INPUT = By.name("userName");
    public static final By ADDRESS_INPUT = By.name("address1");
    public static final By CITY_INPUT = By.name("city");
    public static final By STATE_INPUT = By.name("state");
    public static final By POSTALCODE_INPUT = By.name("postalCode");
    public static final By USERNAME_INPUT = By.name("email");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By CONFIRM_PASSWORD_INPUT = By.name("confirmPassword");
    public static final By COUNTRY_SELECT = By.name("country");
    public static final By ENVIAR_BUTTON = By.name("submit");
    public static final By SUCCESS_MESSAGE = By.xpath("//b[contains(text(), 'Dear')]");
    public static final By SIGNIN_BUTTON = By.xpath("//a[@href='login.php']");
    public static final By DISMISS_POPUP = By.cssSelector("#dismiss-button > div > svg");
    public static final By IFRAME = By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");


}

