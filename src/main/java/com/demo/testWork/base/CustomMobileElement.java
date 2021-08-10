package com.demo.testWork.base;

import com.demo.config.LogInit;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.util.Date;
public class CustomMobileElement{
    private Logger logger = LogInit.getInstance();

    /**
     * 截图（路径写死）
     * 参数：driver 对象
     * return  无
     **/
    @Attachment(value = "Page Screenshot", type = "image/jpg")
    public byte[] Screenshot(AppiumDriver<?> appiumDriver){
        File location = new File("screenshots1"); //在默认的工作目录下面创建一个名字叫screenshots1的文件夹，用来存放图片的
        String screenShotName = location.getAbsolutePath()+File.separator+ new Date().getTime() +".png"; //
//        File scrFile = webElement.getScreenshotAs(OutputType.FILE);
        byte[] scrByte = appiumDriver.getScreenshotAs(OutputType.BYTES);
//        try{
//            FileUtils.copyFile(scrFile, new File(screenShotName));
//        } catch (IOException e) {
//            logger.error("保存失败");
//            e.printStackTrace();
//        }
//        finally {
//            logger.info("Screen shot finished, path in " + screenShotName);
//        }
        return scrByte;
    }

}
