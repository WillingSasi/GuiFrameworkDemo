package com.demo.dao;

import com.demo.config.SQLSettings;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;


public abstract class BaseDao {

    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
    private static final String OR_ADMIN = "http://xxxx";
    private static final Properties sqlSettings = SQLSettings.getInstance();

    /**
     * Open the SqlSession to perform SQL operations
     *
     * @return SqlSession
     */
    public static SqlSession openSession(String environment) {
        try {
            Reader reader = Resources.getResourceAsReader("systemResources/mybatis.xml");
            Properties properties = getEnvironmentProperties(environment);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment, properties);
            return sqlSessionFactory.openSession();
        } catch (Exception e) {
            throw new RuntimeException("Failed to open session for " + environment);
        }
    }

    /**
     * Get Environment Properties
     *
     * @return SqlSession
     */
    private static Properties getEnvironmentProperties(String environment) {
        Properties properties = new Properties();
        if (environment.equalsIgnoreCase("xx")) {
            properties.setProperty("xxxx_URL", fetchConnectionString(environment));
            properties.setProperty("xxxx_USERNAME", sqlSettings.getProperty("Username"));
            properties.setProperty("xxxx_PASSWORD", sqlSettings.getProperty("Password"));
            return properties;
        }
        if (environment.equalsIgnoreCase("xxx")) {
            properties.setProperty("xxxx_URL", fetchConnectionString(environment));
            properties.setProperty("xxxx_USERNAME", sqlSettings.getProperty("Username"));
            properties.setProperty("xxxx_PASSWORD", sqlSettings.getProperty("Password"));
            return properties;
        }
        if (environment.equalsIgnoreCase("xxxx")) {
            properties.setProperty("xxxx_URL", fetchConnectionString(environment));
            properties.setProperty("xxxx_USERNAME", sqlSettings.getProperty("Username"));
            properties.setProperty("xxxx_PASSWORD", sqlSettings.getProperty("Password"));
            return properties;
        }
        throw new RuntimeException("Unsupported environment for " + environment);
    }

    private static String fetchConnectionString(String environment) {
        if (environment.equalsIgnoreCase("xxxx")) {
            environment = "";
        }
        String orAdminLink = OR_ADMIN + sqlSettings.getProperty("DataBase") + environment;
        logger.info("Fetch database url from: " + orAdminLink);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(orAdminLink).openStream()));
            String dbConnectionString = in.readLine();
            logger.info("Database Connection: " + dbConnectionString);
            return dbConnectionString;
        } catch (IOException e) {
            throw new RuntimeException("Could not read database url from " + orAdminLink);
        }
    }
}

