package com.demo.testWork.page.login;

import com.demo.testWork.base.PageFactoryBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.springframework.stereotype.Service;

@Service
@Story("SplashPage")
public class SplashPage extends PageFactoryBase {

    private final SplashPage splashPage = this;
    @iOSXCUITFindBy(iOSNsPredicate = "name == '跳过'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_skip_to_registration")
    private MobileElement btnSkip;

    @iOSXCUITFindBy(iOSNsPredicate ="name == '稍后提醒'")
    @AndroidFindBy(accessibility = "稍后提醒")
    private MobileElement btnRemindLater;

    @iOSXCUITFindBy(iOSNsPredicate ="name == '同意'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/splash_permission_positive")
    private MobileElement btnAgree;

    @iOSXCUITFindBy(iOSNsPredicate ="name == '我知道啦!'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_i_know")
    private MobileElement btnIKnow;

    @iOSXCUITFindBy(iOSNsPredicate ="name == '进入首页'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_home")
    private MobileElement btnEnterHomePage;

    public SplashPage(){
        super();
    }

    @Step("clickBtnSkip")
    public SplashPage clickBtnSkip(){
        btnSkip.click();
        return this;
    }

    @Step("clickBtnRemindLater")
    public SplashPage clickBtnRemindLater(){
        btnRemindLater.click();
        return this;
    }

    @Step("clickBtnAgree")
    public SplashPage clickBtnAgree(){
        btnAgree.click();
        return this;
    }

    @Step("clickBtnIKnow")
    public SplashPage clickBtnIKnow(){
        btnIKnow.click();
        return this;
    }

    @Step("clickBtnEnterHomePage")
    public SplashPage clickBtnEnterHomePage(){
        btnEnterHomePage.click();
        return this;
    }
}