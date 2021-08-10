package com.demo.testWork.base;

import com.demo.config.LogInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageFactoryBase {

    public AppiumDriver<?> appiumDriver;
    public Logger logger = LogInit.getInstance();

    public PageFactoryBase(){
        appiumDriver = AppiumInitializa.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(5)), this);
        logger.info("------------------------- " + this + " initialization success!-------------------------");
    }
}
