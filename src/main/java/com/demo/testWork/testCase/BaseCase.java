package com.demo.testWork.testCase;

import com.demo.config.LogInit;
import com.demo.config.SpringConfig;
import com.demo.frameWork.AppiumServer;
import com.demo.testWork.api.CAPPAPI;
import com.demo.testWork.api.component.LoginOperation;
import com.demo.testWork.api.component.RegisterOperation;
import com.demo.testWork.base.AppiumInitializa;
import com.demo.testWork.base.listener.TestngISuiteListener;
import com.demo.testWork.page.common.*;
import com.demo.testWork.page.home.*;
import com.demo.testWork.page.login.*;
import com.demo.testWork.service.*;
import com.demo.utils.RestTemplateUtil;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;

@Listeners(TestngISuiteListener.class)
@Component
public class BaseCase {

    public Logger logger = LogInit.getInstance();

    @Resource
    public  CommonPage commonPage;
    @Resource
    public  SplashPage splashPage;
    @Resource
    public  LoginPage loginPage;
    @Resource
    public  HomePage homePage;
    @Resource
    public  MePage mePage;
    @Resource
    public LoginService loginService ;
    @Resource
    public LogoutService logoutService ;
    @Resource
    public CAPPAPI cappApi ;
    @Resource
    public LoginOperation login;
    @Resource
    public RegisterOperation register;
    @Resource
    public RestTemplateUtil restTemplateUtil;

    @BeforeSuite
    public void setBeansConfig(){
        ApplicationContext  appCtx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BaseCase baseCase = (BaseCase)appCtx.getBean("baseCase");
        Field[] fields= baseCase.getClass().getDeclaredFields();
        String fieldName ="";
        Object ob = null;

        try {
            for (Field field : fields) {
                ob = field.get(baseCase);
                fieldName = field.getName();
                Annotation[] annotations = ob.getClass().getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.toString().contains("Service")) {
                        this.getClass().getField(fieldName).set(this, ob);
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            logger.info(e);
        }
    }

    @Step("Appium Init")
    @BeforeClass(enabled = true)
    public void setUp(){
        logger.info("-------------------------Start Test Case " + this.getClass().getSimpleName() + "-------------------------");
    }

    @Step("Appium Recycle")
    @AfterClass(enabled = true)
    public void tearDown(){
        //stop server
        if (AppiumServer.appiumService != null || AppiumServer.appiumService.isRunning()) {
            new AppiumServer().stopAppiumService();
        }

        //stop driver
        AppiumInitializa.setAppiumDriverNull();
        logger.info("-------------------------End Test Case " + this.getClass().getSimpleName() + "-------------------------");
    }
}
