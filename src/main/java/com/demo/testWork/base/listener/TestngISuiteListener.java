package com.demo.testWork.base.listener;

import com.demo.config.LogInit;
import com.demo.config.ResultInit;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;

public class TestngISuiteListener implements ISuiteListener {
    private Logger logger = LogInit.getInstance();

    @Override
    public void onStart(ISuite suite) {
        logger.info("-------------------------Result path start init!-------------------------");
        new ResultInit().initResultFolder();
        logger.info("-------------------------Result path end init!-------------------------");
    }

    /**
     * Use allure client generate report
     * @param suite
     */
    @Override
    public void onFinish(ISuite suite) {
        logger.info("-------------------------Generate report start!-------------------------");

        String allureClientPath = System.getProperty("user.dir") + "/allure-2.13.2/bin/allure";
        if (System.getProperty("os.name").contains("windows")) {
            allureClientPath = System.getProperty("user.dir") + "/allure-2.13.2/bin/allure.bat";
        }

        try {
            Runtime.getRuntime().exec(allureClientPath + " generate " +
                    System.getProperty("user.dir") + "/" + ResultInit.getResultFolder() + "/" + " -o " +
                    System.getProperty("user.dir") + "/" + ResultInit.getResultFolder() + "/report");
        } catch (IOException e) {
            logger.info("-------------------------Generate report error!-------------------------");
            e.printStackTrace();
        }

        logger.info("-------------------------Generate report end!-------------------------");
    }
}
