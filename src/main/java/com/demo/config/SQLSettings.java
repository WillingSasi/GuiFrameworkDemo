package com.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SQLSettings {

    private volatile static Properties properties;

    //私有化构造方法
    private SQLSettings() {};

    public static Properties getInstance(){
        if (properties == null) {
            loadProperties();
        }
        return properties;
    }

    private static void loadProperties(){
        synchronized (Properties.class) {
            if (properties == null) {
                properties = new Properties();
                InputStream inputStream = ClassLoader.getSystemResourceAsStream("systemResources/SQLSettings.properties");
                try {
                    properties.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
