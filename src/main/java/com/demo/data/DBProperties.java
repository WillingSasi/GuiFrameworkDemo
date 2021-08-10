package com.demo.data;

import java.util.Properties;

public class DBProperties {
    public static Properties xx;
    public static Properties xxx;
    public static Properties xxxx;

    static {
        xx = new Properties();
        xx.setProperty("jdbc.driver", "oracle.jdbc.driver.OracleDriver");
        xx.setProperty("jdbc.url", "xxxx");
        xx.setProperty("jdbc.username", "xxxx");
        xx.setProperty("jdbc.password", "xxxx");

        xxx = new Properties();
        xxx.setProperty("jdbc.driver", "oracle.jdbc.driver.OracleDriver");
        xxx.setProperty("jdbc.url", "xxxx");
        xxx.setProperty("jdbc.username", "xxxx");
        xxx.setProperty("jdbc.password", "xxxx");

        xxxx = new Properties();
        xxxx.setProperty("jdbc.driver", "oracle.jdbc.driver.OracleDriver");
        xxxx.setProperty("jdbc.url", "xxxx");
        xxxx.setProperty("jdbc.username", "xxxx");
        xxxx.setProperty("jdbc.password", "xxxx");
    }
}
