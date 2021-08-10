package com.demo.testWork.base.listener;

import io.appium.java_client.events.api.general.ListensToException;
import org.openqa.selenium.WebDriver;

public class AppiumListensToException implements ListensToException {
    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
