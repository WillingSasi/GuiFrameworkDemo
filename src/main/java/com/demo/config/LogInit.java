package com.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;

/**
 * 加载log4j xml配置文件
 */
public class LogInit {

    private static Logger logger;

    //私有化构造方法
    private LogInit() {};

    public static Logger getInstance(){
        if (logger == null) {
            logger = logInit();
        }
        return logger;
    }

    private static Logger logInit(){
        ConfigurationSource configurationSource = null;
        try {
            configurationSource = new ConfigurationSource(ClassLoader.getSystemResourceAsStream("systemResources/log4j2Config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (configurationSource != null){
            Configurator.initialize(null, configurationSource);
        }

        return LogManager.getLogger();
    }
}
