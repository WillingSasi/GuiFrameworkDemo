package com.demo.frameWork;

import com.demo.config.LogInit;
import com.demo.config.ProjectSettings;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * 启动Appium服务，非GUI模式启动
 * @author Graham.Liu
 */
public class AppiumServer {
    public Logger logger = LogInit.getInstance();
    private Properties projectSettings = ProjectSettings.getInstance();
    public static AppiumDriverLocalService appiumService;
    private String ip;
    private Integer port;

    /**
     * Start Appium service
     * @author Graham.Liu
     */
    public void startAppiumService(){
        ip = projectSettings.getProperty("appiumIp");
        port = Integer.valueOf(projectSettings.getProperty("appiumPort"));

        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withIPAddress(ip).usingPort(port);
        appiumService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumService.start();
        if (appiumService == null || !appiumService.isRunning()){
            logger.info("-------------------------Appium server node start failed!-------------------------");
        }
    }


    /**
     * Stop Appium Service
     * @author Graham.Liu
     */
    public void stopAppiumService() {
        do {
            appiumService.stop();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (appiumService.isRunning());
        logger.info("-------------------------Appium server node stoped!-------------------------");
    }
}
