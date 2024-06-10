package com.taller.listeners;

import com.taller.listeners.validator.AdValidator;
import com.taller.listeners.validator.DriverEventListenerValidation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;
import java.util.List;

public class DriverValidatorListener extends AbstractWebDriverEventListener {

    List <DriverEventListenerValidation> validators;
    boolean isValidating = false;

    public DriverValidatorListener() {
        validators = Arrays.asList( new AdValidator() );
    }

    public DriverValidatorListener( DriverEventListenerValidation... validators ) {
        this.validators = Arrays.asList( validators );
    }

    @Override
    public void onException( Throwable throwable, WebDriver driver ) {
        if (isValidating)
            return;
        isValidating = true;
        for ( DriverEventListenerValidation validator : validators ) {
            validator.validate( throwable, driver );
        }
        isValidating = false;
    }

}
