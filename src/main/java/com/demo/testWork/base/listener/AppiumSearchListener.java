package com.demo.testWork.base.listener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.events.api.general.SearchingEventListener;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

public class AppiumSearchListener implements SearchingEventListener {
    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }
}
