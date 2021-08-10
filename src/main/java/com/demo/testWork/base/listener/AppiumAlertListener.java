package com.demo.testWork.base.listener;

import io.appium.java_client.events.api.general.AlertEventListener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * 添加alert自定义监控
 * @Auther graham
 * @Date 2020.8.9
 */
public class AppiumAlertListener implements AlertEventListener {
    @Override
    public void beforeAlertAccept(WebDriver webDriver, Alert alert) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver, Alert alert) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver, Alert alert) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver, Alert alert) {

    }

    @Override
    public void beforeAlertSendKeys(WebDriver webDriver, Alert alert, String s) {

    }

    @Override
    public void afterAlertSendKeys(WebDriver webDriver, Alert alert, String s) {

    }
}
