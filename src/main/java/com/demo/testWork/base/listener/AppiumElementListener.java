package com.demo.testWork.base.listener;

import com.demo.testWork.base.AppiumInitializa;
import com.demo.testWork.base.CustomMobileElement;
import io.appium.java_client.events.api.general.ElementEventListener;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 添加appium元素操作定制化监控
 * @Auther graham
 * @Date 2020.8.9
 */
public class AppiumElementListener implements ElementEventListener {

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        CustomMobileElement customMobileElement =new CustomMobileElement();
        customMobileElement.Screenshot(AppiumInitializa.getInstance());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Listener SPI success!");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
