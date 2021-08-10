package com.demo.config;

import io.qameta.allure.util.PropertiesUtils;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * 初始化result文件夹及按时间命名文件，存放log，allure-result，allure-report
 * @Author graham
 * @Date 2020。8.13
 */
public class ResultInit {
    private Logger logger = LogInit.getInstance();
    private final String resultDir = "Result";

    private static String resultFolder;

    public void initResultDir(){
        File dir = new File(resultDir);

        if (!dir.isDirectory()) {
            logger.info("Result文件夹不存在!");
            dir.mkdir();
            logger.info("Result文件夹新建成功!");
        }
    }

    public String initResultFolder(){
//        File folderDir = new File(System.getProperty("user.dir") + File.separator + resultDir + File.separator + folderName + File.separator + time);
        File folderDir = new File(PropertiesUtils.getAllureResultPath());

        if (!folderDir.isDirectory()) {
            logger.info("Result文件夹不存在!");
            folderDir.mkdirs();
            logger.info(folderDir.toString()+"文件夹新建成功!");
        }
        resultFolder = folderDir.toString();
        return folderDir.toString();
    }

    public static String getResultFolder() {
        return resultFolder;
    }
}
