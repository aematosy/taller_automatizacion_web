package com.taller.listeners.validator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdValidator implements DriverEventListenerValidation {

    private static final By CLOSE_AD_BUTTON = By.xpath("//button[@id='dismiss-button']");
    private static final By AD_IFRAME1 = By.xpath("//iframe[contains(@id, 'aswift_') and not(contains(@id, 'host'))]");
    private static final By AD_IFRAME2 = By.xpath("//iframe[@id='ad_iframe']");

    @Override
    public void validate(Throwable throwable, WebDriver driver) {
        if (!isAdVisible(driver))
            return;
        closeAd(driver);
    }

    private boolean isAdVisible(WebDriver driver) {
        return driver.getCurrentUrl().contains("#google_vignette");
    }

    private void closeAd(WebDriver driver) {
        try {
            closeIFrame(driver, AD_IFRAME1);
        } catch (NoSuchFrameException e) {
            System.out.println("AD_IFRAME1 no encontrado");
        }

        try {
            closeIFrame(driver, AD_IFRAME2);
        } catch (NoSuchFrameException e) {
            System.out.println("AD_IFRAME2 no encontrado");
        }
        driver.switchTo().defaultContent();
    }

    private void closeIFrame(WebDriver driver, By iframeLocator) {
        try {
            WebElement iframe = driver.findElement(iframeLocator);
            if (!iframe.isDisplayed())
                return;
            driver.switchTo().frame(iframe);
            WebElement closeButton = driver.findElement(CLOSE_AD_BUTTON);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            closeButton.click();
        } catch (StaleElementReferenceException e) {
            // Manejar la excepción si el elemento está obsoleto
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
