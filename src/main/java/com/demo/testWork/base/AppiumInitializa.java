package com.demo.testWork.base;

import com.demo.config.LogInit;
import com.demo.config.MobileConfig;
import com.demo.config.MobileSettings;
import com.demo.config.ProjectSettings;
import com.demo.frameWork.AppiumServer;
import com.demo.testWork.base.listener.AppiumElementListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.Listener;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumInitializa {

    private static AppiumDriver<?> appiumDriver = null;
    private static Properties projectSettings = ProjectSettings.getInstance();
    private static Properties mobileSettings = MobileSettings.getInstance();
    public static Logger logger = LogInit.getInstance();

    public static AppiumDriver<?> getInstance() {
        if (AppiumServer.appiumService == null || !AppiumServer.appiumService.isRunning()) {
            if (Boolean.parseBoolean(projectSettings.getProperty("appiumServer"))) {
                new AppiumServer().startAppiumService();
            }
        } else {
            logger.info("-------------------------Appium server node already started!-------------------------");
        }

        if (appiumDriver == null) {
            List<Listener> listeners = new ArrayList<>();
            listeners.add(new AppiumElementListener());
//            listeners.add(new AppiumSearchListener());
            appiumDriver = appiumInitializa(listeners);
//            appiumDriver = appiumInitializa();
        }
        return appiumDriver;
    }

    private AppiumInitializa() {}

    /**
     * 普通版初始化appium
     */
    private static AppiumDriver<?> appiumInitializa() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL appiumServerUrl = null;
        String deviceSystem = mobileSettings.getProperty("testDevice");
        String url = "http://" + projectSettings.getProperty("appiumIp") + ":"+projectSettings.getProperty("appiumPort") + "/wd/hub";

        //公有基础配置
        desiredCapabilities.setCapability("deviceName", MobileConfig.DEVICE_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("platformName", MobileConfig.PLATFORM_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("version", MobileConfig.VERSION.getConfig(deviceSystem));
        desiredCapabilities.setCapability("udid", MobileConfig.UDID.getConfig(deviceSystem));
        desiredCapabilities.setCapability("automationName", MobileConfig.AUTOMATION_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("app", MobileConfig.APP_PATH.getConfig(deviceSystem));

        //设备特性配置
        if(deviceSystem.equals("ios")){
            desiredCapabilities.setCapability("bundleId", MobileConfig.BUNDLE_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeOrgId", MobileConfig.XCODE_ORG_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeSigningId", MobileConfig.XCODE_SIGNING_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("startIWDP", true);
            desiredCapabilities.setCapability("locationServicesEnabled", true);
        }else if(deviceSystem.equals("android")){
            desiredCapabilities.setCapability("appPackage", MobileConfig.APP_PACKAGE.getConfig(deviceSystem));
            desiredCapabilities.setCapability("appActivity", MobileConfig.APP_ACTIVITY.getConfig(deviceSystem));
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("noSign", true);
        }else {
        }

        //全局安装配置
//        desiredCapabilities.setCapability("fastReset", true);
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("noReset,", true);
        desiredCapabilities.setCapability("newCommandTimeout", 600);

        try {
            appiumServerUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(deviceSystem.equals("ios")){
            appiumDriver = new IOSDriver<>(appiumServerUrl, desiredCapabilities);
        }else if(deviceSystem.equals("android")){
            appiumDriver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);
        }else {
            appiumDriver = new AppiumDriver<>(appiumServerUrl, desiredCapabilities);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("-------------------------Appium driver already initialized!-------------------------");
        return appiumDriver;
    }

    /**
     * 普通版初始化appium
     */
    private static AppiumDriver<?> appiumInitializa(List<Listener> listeners) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL appiumServerUrl = null;
        String deviceSystem = mobileSettings.getProperty("testDevice");
        String url = "http://" + projectSettings.getProperty("appiumIp") + ":"+projectSettings.getProperty("appiumPort") + "/wd/hub";

        //公有基础配置
        desiredCapabilities.setCapability("deviceName", MobileConfig.DEVICE_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("platformName", MobileConfig.PLATFORM_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("version", MobileConfig.VERSION.getConfig(deviceSystem));
        desiredCapabilities.setCapability("udid", MobileConfig.UDID.getConfig(deviceSystem));
        desiredCapabilities.setCapability("automationName", MobileConfig.AUTOMATION_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("app", MobileConfig.APP_PATH.getConfig(deviceSystem));

        //设备特性配置
        if(deviceSystem.equals("ios")){
            desiredCapabilities.setCapability("bundleId", MobileConfig.BUNDLE_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeOrgId", MobileConfig.XCODE_ORG_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeSigningId", MobileConfig.XCODE_SIGNING_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("startIWDP", true);
            desiredCapabilities.setCapability("locationServicesEnabled", true);
        }else if(deviceSystem.equals("android")){
            desiredCapabilities.setCapability("appPackage", MobileConfig.APP_PACKAGE.getConfig(deviceSystem));
            desiredCapabilities.setCapability("appActivity", MobileConfig.APP_ACTIVITY.getConfig(deviceSystem));
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("noSign", true);
        }else {
        }

        //全局安装配置
//        desiredCapabilities.setCapability("fastReset", true);
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("noReset,", true);
        desiredCapabilities.setCapability("newCommandTimeout", 600);

        try {
            appiumServerUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(deviceSystem.equals("ios")){
            appiumDriver = new IOSDriver<>(appiumServerUrl, desiredCapabilities);
        }else if(deviceSystem.equals("android")){
            appiumDriver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);
        }else {
            appiumDriver = new AppiumDriver<>(appiumServerUrl, desiredCapabilities);
        }

        //给driver注册自定义监听类
        appiumDriver = EventFiringWebDriverFactory.getEventFiringWebDriver(appiumDriver, listeners);

        //隐式等待
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("-------------------------Appium driver already initialized!-------------------------");
        return appiumDriver;
    }

    /**
     * 普通版初始化appium
     * @param deviceSystem
     * @return
     */
    private AppiumDriver appiumInitializa(String deviceSystem) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL appiumServerUrl = null;
        AppiumDriver appiumDriver;
        String url = "http://" + projectSettings.getProperty("appiumIp") + ":"+projectSettings.getProperty("appiumPort") + "/wd/hub";

        //公有基础配置
        desiredCapabilities.setCapability("deviceName", MobileConfig.DEVICE_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("platformName", MobileConfig.PLATFORM_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("version", MobileConfig.VERSION.getConfig(deviceSystem));
        desiredCapabilities.setCapability("udid", MobileConfig.UDID.getConfig(deviceSystem));
        desiredCapabilities.setCapability("automationName", MobileConfig.AUTOMATION_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("app", MobileConfig.APP_PATH.getConfig(deviceSystem));

        //设备特性配置
        if(deviceSystem.equals("ios")){
            desiredCapabilities.setCapability("bundleId", MobileConfig.BUNDLE_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeOrgId", MobileConfig.XCODE_ORG_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeSigningId", MobileConfig.XCODE_SIGNING_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("startIWDP", true);
            desiredCapabilities.setCapability("locationServicesEnabled", true);
        }else if(deviceSystem.equals("android")){
            desiredCapabilities.setCapability("appPackage", MobileConfig.APP_PACKAGE.getConfig(deviceSystem));
            desiredCapabilities.setCapability("appActivity", MobileConfig.APP_ACTIVITY.getConfig(deviceSystem));
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("noSign", true);
        }else {
        }

        //全局安装配置
//        desiredCapabilities.setCapability("fastReset", true);
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("noReset,", true);
        desiredCapabilities.setCapability("newCommandTimeout", 600);

        try {
            appiumServerUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(deviceSystem.equals("ios")){
            appiumDriver = new IOSDriver(appiumServerUrl, desiredCapabilities);
        }else if(deviceSystem.equals("android")){
            appiumDriver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
        }else {
            appiumDriver = new AppiumDriver(appiumServerUrl, desiredCapabilities);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }

    /**
     * AI版初始化appium
     * @param deviceSystem
     * @param ai
     * @return
     */
    private AppiumDriver appiumInitializa(String deviceSystem, String ai) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL appiumServerUrl = null;
        AppiumDriver appiumDriver;
        String url = "http://" + projectSettings.getProperty("appiumIp") + ":"+projectSettings.getProperty("appiumPort") + "/wd/hub";

        //公有基础配置
        desiredCapabilities.setCapability("deviceName", MobileConfig.DEVICE_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("platformName", MobileConfig.PLATFORM_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("version", MobileConfig.VERSION.getConfig(deviceSystem));
        desiredCapabilities.setCapability("udid", MobileConfig.UDID.getConfig(deviceSystem));
        desiredCapabilities.setCapability("automaationName", MobileConfig.AUTOMATION_NAME.getConfig(deviceSystem));
        desiredCapabilities.setCapability("app", MobileConfig.APP_PATH.getConfig(deviceSystem));

        //设备特性配置
        if(deviceSystem.equals("ios")){
            desiredCapabilities.setCapability("bundleId", MobileConfig.BUNDLE_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeOrgId", MobileConfig.XCODE_ORG_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("xcodeSigningId", MobileConfig.XCODE_SIGNING_ID.getConfig(deviceSystem));
            desiredCapabilities.setCapability("startIWDP", true);
            desiredCapabilities.setCapability("locationServicesEnabled", true);
        }else if(deviceSystem.equals("android")){
            desiredCapabilities.setCapability("appPackage", MobileConfig.APP_PACKAGE.getConfig(deviceSystem));
            desiredCapabilities.setCapability("appActivity", MobileConfig.APP_ACTIVITY.getConfig(deviceSystem));
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("noSign", true);
        }else {
        }

        //全局安装配置
        desiredCapabilities.setCapability("fastReset", true);
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("noReset,", true);
        desiredCapabilities.setCapability("newCommandTimeout", 600);

        //Appium AI自动识别element配置
        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");
        desiredCapabilities.setCapability("customFindModules", customFindModules);
        desiredCapabilities.setCapability("shouldUseCompactResponses", false);
        desiredCapabilities.setCapability("testaiConfidenceThreshold", 0.2);
        desiredCapabilities.setCapability("testaiFindMode", "element_lookup");

        try {
            appiumServerUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(deviceSystem.equals("ios")){
            appiumDriver = new IOSDriver(appiumServerUrl, desiredCapabilities);
        }else if(deviceSystem.equals("android")){
            appiumDriver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
        }else {
            appiumDriver = new AppiumDriver(appiumServerUrl, desiredCapabilities);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }

    public static void setAppiumDriverNull() {
        AppiumInitializa.appiumDriver = null;
        logger.info("-------------------------Appium driver stoped!-------------------------");
    }
}
